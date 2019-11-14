package com.huobi.wss.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huobi.wss.SubscriptionListener;
import com.huobi.wss.util.ApiSignature;
import com.huobi.wss.util.ZipUtil;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 合约站订单推送处理器
 */
public class WssNotificationHandle {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private WebSocketClient webSocketClient;
    private String accessKey;
    private String secretKey;
    private String pushUrl;//订单推送访问地址
    private Long lastPingTime = System.currentTimeMillis();


    public WssNotificationHandle(String pushUrl, String accessKey, String secretKey) {
        this.pushUrl = pushUrl;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public void sub(List<String> channels, SubscriptionListener<String> callback) throws URISyntaxException {
        doConnect(channels, callback);
    }


    private void doConnect(List<String> channels, SubscriptionListener<String> callback) throws URISyntaxException {
        webSocketClient = new WebSocketClient(new URI(pushUrl)) {

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                addAuth();
                doSub(channels);
                dealReconnect();
            }


            @Override
            public void onMessage(String s) {
                logger.debug("onMessage:{}", s);
            }

            @Override
            public void onMessage(ByteBuffer bytes) {
                executorService.execute(() -> {
                    try {
                        lastPingTime = System.currentTimeMillis();
                        String message = new String(ZipUtil.decompress(bytes.array()), "UTF-8");
                        JSONObject JSONMessage = JSONObject.parseObject(message);
                        Object op = JSONMessage.get("op");
                        if (op != null && op.toString().equalsIgnoreCase("notify")) {
                            callback.onReceive(message);
                        }

                        if (op != null && op.toString().equalsIgnoreCase("ping")) {
                            dealPing(Long.valueOf(JSONMessage.get("ts").toString()));
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });

            }

            @Override
            public void onClose(int i, String s, boolean b) {
                logger.error("onClose i:{},s:{},b:{}", i, s, b);
            }

            @Override
            public void onError(Exception e) {
                logger.error("onError:{}", e);
            }
        };

        webSocketClient.connect();
    }


    private void doSub(List<String> channels) {
        channels.stream().forEach(e -> {
            JSONObject sub = new JSONObject();
            sub.put("op", "sub");
            sub.put("topic", e);
            webSocketClient.send(sub.toString());
        });
    }


    private void dealPing(Long ts) {
        try {
            JSONObject jsonMessage = new JSONObject();
            jsonMessage.put("op", "pong");
            jsonMessage.put("ts", ts);
            logger.debug("发送pong:{}", ts);
            webSocketClient.send(jsonMessage.toString());
        } catch (Throwable t) {
            logger.error("dealPing出现了异常", t);
        }


    }


    public void addAuth() {
        if (StringUtils.isEmpty(secretKey) || StringUtils.isEmpty(accessKey)) {
            return;
        }
        Map<String, String> map = new HashMap<>();
        ApiSignature as = new ApiSignature();
        try {

            //组合签名map
            //Combined signature map
            as.createSignature(accessKey, secretKey, "GET", "api.hbdm.com", "/notification", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("op", "auth");
        map.put("type", "api");
        String req = JSON.toJSONString(map);
        logger.info("before send ");
        webSocketClient.send(req);
        logger.info("after send ");
    }


    private void dealReconnect() {
        try {
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {

                    try {
                        if ((webSocketClient.isClosed() && !webSocketClient.isClosing()) || System.currentTimeMillis() - lastPingTime > 10 * 1000) {
                            logger.error("isClosed:{},isClosing:{}，准备重连", webSocketClient.isClosed(), webSocketClient.isClosing());
                            Boolean reconnectResult = webSocketClient.reconnectBlocking();
                            logger.error("重连的结果为：{}", reconnectResult);
                            if (!reconnectResult) {
                                webSocketClient.closeBlocking();
                                logger.error("closeBlocking");
                            }

                        }
                    } catch (Throwable e) {
                        logger.error("dealReconnect异常", e);
                    }

                }
            }, 60, 10, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("dealReconnect scheduledExecutorService异常", e);
        }

    }


}
