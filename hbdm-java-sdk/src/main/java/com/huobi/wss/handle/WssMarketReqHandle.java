package com.huobi.wss.handle;

import com.alibaba.fastjson.JSONObject;
import com.huobi.wss.SubscriptionListener;
import com.huobi.wss.util.ZipUtil;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 合约站行情请求处理器
 */
public class WssMarketReqHandle {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private WebSocketClient webSocketClient;
    private String pushUrl;//合约站行情请求地址
    private Long lastPingTime = System.currentTimeMillis();


    public WssMarketReqHandle(String pushUrl, SubscriptionListener<String> callBack) throws URISyntaxException, InterruptedException {
        this.pushUrl = pushUrl;
        doConnect(callBack);
    }


    private void doConnect(SubscriptionListener<String> callBack) throws URISyntaxException, InterruptedException {
        webSocketClient = new WebSocketClient(new URI(pushUrl)) {

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                logger.debug("onOpen Success");
                dealReconnect();
                dealPing();
            }


            @Override
            public void onMessage(String s) {
                logger.debug("onMessage:{}", s);
            }

            @Override
            public void onMessage(ByteBuffer bytes) {
                try {
                    lastPingTime=System.currentTimeMillis();
                    String message = new String(ZipUtil.decompress(bytes.array()), "UTF-8");
                    JSONObject JSONMessage = JSONObject.parseObject(message);
                    Object ch = JSONMessage.get("data");
                    Object ping = JSONMessage.get("ping");

                    if (ch != null) {
                        callBack.onReceive(message);
                    }
                    if (ping != null) {
                        dealPing();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


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

        webSocketClient.connectBlocking();

    }


    public void doReq(String channel) {
        webSocketClient.send(channel);
    }


    private void dealReconnect() {
        try {
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {

                    try {
                        if ((webSocketClient.isClosed() && !webSocketClient.isClosing()) || System.currentTimeMillis() - lastPingTime > 10*1000) {
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


    private void dealPing() {
        try {
            JSONObject jsonMessage = new JSONObject();
            jsonMessage.put("pong", System.currentTimeMillis());
            logger.debug("发送pong:{}", jsonMessage.toString());
            webSocketClient.send(jsonMessage.toString());
        } catch (Throwable t) {
            logger.error("dealPing出现了异常");
        }
    }


}
