package com.huobi.demo;


import org.java_websocket.client.DefaultSSLWebSocketClientFactory;
import org.java_websocket.client.WebSocketClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Service
@Scope(SCOPE_PROTOTYPE)
public class Client {


    /**
     * 创建连接
     */
    public void connect(WebSocketClient ws) {
//    try {
        //求情连接

//      TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
//        @Override
//        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//          return new java.security.cert.X509Certificate[]{};
//        }
//
//        @Override
//        public void checkClientTrusted(X509Certificate[] chain,
//                                       String authType) {
//        }
//
//        @Override
//        public void checkServerTrusted(X509Certificate[] chain,
//                                       String authType) {
//        }
//      }};
//
//      SSLContext sc = SSLContext.getInstance("TLS");
//      //创建WebSocket工厂
//      sc.init(null, trustAllCerts, new java.security.SecureRandom());
//      ws.setWebSocketFactory(new DefaultSSLWebSocketClientFactory(sc));
//    } catch (NoSuchAlgorithmException e) {
//      e.printStackTrace();
//    } catch (KeyManagementException e) {
//      e.printStackTrace();
//    }

        //进行连接
        ws.connect();
    }

    public static void main(String args[]) {

    }

}
