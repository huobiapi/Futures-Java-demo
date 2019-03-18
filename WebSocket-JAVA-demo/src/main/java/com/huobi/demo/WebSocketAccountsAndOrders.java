package com.huobi.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
/**
 * AccountsAndOrders websocket
 */
public class WebSocketAccountsAndOrders extends WebSocketClient {
    private static final Logger log = LoggerFactory.getLogger(WebSocketAccountsAndOrders.class);

    private URI uri;
    private String accessKey;
    private String secretKey;

    /**
     * sub请求的topic 包含 accounts，orders.*等
     */
    private String aOTopic = "orders.eth";


    public WebSocketAccountsAndOrders(URI uri, String accessKey, String secretKey) {
        super(uri, new Draft_17());
        this.uri = uri;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }


    @Override
    /**
     * 建立连接
     */
    public void onOpen(ServerHandshake shake) {
        addAuth();
    }

    @Override
    /**
     * 此处不需要操作
     */
    public void onMessage(String arg0) {
        if (arg0 != null) {
            log.info("receive message " + arg0);
        }

    }

    @Override
    /**
     * 发送异常处理
     */
    public void onError(Exception arg0) {
//    TODO 异常处理
        String message = "";
        try {
            message = new String(arg0.getMessage().getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("has error ,the message is :" + message);
        arg0.printStackTrace();
    }

    @Override
    /**
     * 关闭连接处理
     */
    public void onClose(int arg0, String arg1, boolean arg2) {
//    TODO 关闭连接处理
        log.info("connection close ");
        log.info(arg0 + "   " + arg1 + "  " + arg2);
    }

    @Override
    /**
     * 接收服务器信息
     */
    public void onMessage(ByteBuffer bytes) {

        try {
//  TODO  可添加自定义消息处理
//    接收服务器信息 并进行解压
            String message = new String(ZipUtil.decompress(bytes.array()), "UTF-8");
            System.out.println(message);
//    将信息转为放入JSONObject
            JSONObject jsonObject = JSONObject.parseObject(message);

            String op = jsonObject.getString("op");

            Integer errCode = jsonObject.getInteger("err-code");

            if (!StringUtils.isEmpty(message)) {

                if ("ping".equals(op)) {
                    String pong = jsonObject.toString();
                    send(pong.replace("ping", "pong"));

                } else if ("auth".equals(op)) {
                    //鉴权结果

                    if (errCode != 0) {
                        //鉴权失败打印信息
                        log.info(message);
                    } else {

                        //鉴权成功发送sub 请求
                        sendSub(aOTopic, "12123");
                    }
                } else if ("sub".equals(op)) {
                    if (errCode == 0) {
                       //sendUnSub("orders.eth", "12123");
                    }
                    //TODO  结束的服务器消息处理 message 为接收到消息
                    log.info(message);
                }else if ("notify".equals(op)) {
                    //这里接收到订单的推送消息，做业务处理
                    log.info("接收到订单的推送消息报文:"+message);
                }
            }
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 发送账户订单请求鉴权
     */
    public void addAuth() {
        Map<String, String> map = new HashMap<>();
        ApiSignature as = new ApiSignature();
        try {

            String theHost = uri.getHost() + ":" + uri.getPort();
            //组合签名map
            as.createSignature(accessKey, secretKey, "GET", "api.hbdm.com", "/notification", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put(ApiSignature.op, ApiSignature.opValue);
        map.put("cid", "111");
        map.put("type", "api");

        String req = JSON.toJSONString(map);
        log.info("before send ");
        send(req);
        log.info("after send ");
    }

    /**
     * 发送账户订单sub请求
     *
     * @param topic 订阅topic
     * @param cid   标识
     */
    public void sendSub(String topic, String cid) {
        JSONObject req = new JSONObject();
        req.put("op", "sub");
        if (cid != null) {
            req.put("cid", cid);
        }
        req.put("topic", topic);
        send(req.toString());
    }

    public void sendUnSub(String topic, String cid) {
        JSONObject req = new JSONObject();
        req.put("op", "unsub");
        if (cid != null) {
            req.put("cid", cid);
        }
        req.put("topic", topic);
        send(req.toString());
    }

    /**
     * 发送账户订单取消订阅发送unsub请求
     *
     * @param topic unsub请求topic
     * @param cid   标识
     */
    public void sendWsUnSubSuccess(String topic, String cid) {


        JSONObject req = new JSONObject();
        req.put("op", "sub");
        req.put("cid", cid);
        req.put("topic", topic);
        send(req.toString());
    }


    /**
     * 发送账户订单req请求
     *
     * @param topic
     * @param orderId
     * @param symbol
     * @param states
     * @param cid
     */
    public void sendWsReq(String topic, String orderId, String symbol, String states, String cid) {
        JSONObject req = new JSONObject();
        req.put("op", "req");
        req.put("cid", cid);
        req.put("topic", topic);
        if (orderId != null) {
            req.put("order-id", orderId);
        }
        if (symbol != null) {
            req.put("symbol", symbol);
        }
        if (symbol != null) {
            req.put("states", states);
        }
        send(req.toString());
    }

}
