package com.huobi.demo;

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

@Slf4j
/**
 * market websocket
 */
public class WebSocketMarket extends WebSocketClient {
	private static final Logger log = LoggerFactory.getLogger(WebSocketMarket.class);

	private URI uri;

	/**
	 * websocket 操作
	 */
	private String op = "sub";

	/**
	 * 订阅symbol
	 */
	private String symbol = "BTC_CW";

	public static String KLINE = "market.%s.kline.%s";
	public static String DEPTH = "market.%s.depth.%s";
	public static String TRADE = "market.%s.trade.detail";
	public static String DETAIL = "market.%s.detail";
	public static String TICKERS = "market.tickers";
	public static String PERIOD[] = { "1min", "5min", "15min", "30min", "60min", "4hour", "1day", "1mon", "1week",
			"1year" };
	public static String TYPE[] = { "step0", "step1", "step2", "step3", "step4", "step5", "percent10" };

	public WebSocketMarket(URI uri) {
		super(uri, new Draft_17());
		this.uri = uri;
	}

	@Override
	public void onOpen(ServerHandshake shake) {
		// 拼接sub的topic
		String topic = String.format(KLINE, symbol, PERIOD[0]);
		sendWsMarket(op, topic);
	}

	@Override
	public void onMessage(String arg0) {
		if (arg0 != null) {
			log.info("receive message " + arg0);
		}

	}

	@Override
	public void onError(Exception arg0) {
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
	public void onClose(int arg0, String arg1, boolean arg2) {

		log.info("connection close ");
		log.info(arg0 + "   " + arg1 + "  " + arg2);
	}

	@Override
	public void onMessage(ByteBuffer bytes) {

		try {

			String message = new String(ZipUtil.decompress(bytes.array()), "UTF-8");
			JSONObject jsonObject = JSONObject.parseObject(message);
			if (!StringUtils.isEmpty(message)) {

				if (message.indexOf("ping") > 0) {
					String pong = jsonObject.toString();
					send(pong.replace("ping", "pong"));
				} else {
					log.info(message);
				}
			}
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Market KLine market.$symbol.kline.$period sub/req K线
	// 数据，包含单位时间区间的开盘价、收盘价、最高价、最低价、成交量、成交额、成交笔数等数据 $period 可选值：{ 1min, 5min, 15min,
	// 30min, 60min, 4hour,1day, 1mon, 1week, 1year } N
	// Market Depth market.$symbol.depth.$type sub/req 盘口深度，按照不同 step
	// 聚合的买一、买二、买三等和卖一、卖二、卖三等数据 $type 可选值：{ step0, step1, step2, step3, step4,
	// step5, percent10 } （合并深度0-5）；step0时，不合并深度 N
	// Trade Detail market.$symbol.trade.detail sub/req 成交记录，包含成交价格、成交量、成交方向等信息 N
	// Market Detail market.$symbol.detail sub/req
	// 最近24小时成交量、成交额、开盘价、收盘价、最高价、最低价、成交笔数等 N
	// Market Tickers market.tickers

	/**
	 * 行情请求
	 *
	 * @param op
	 * @param topic
	 */
	public void sendWsMarket(String op, String topic) {
		JSONObject req = new JSONObject();
		req.put(op, topic);
		req.put("id", "12312312");
		send(req.toString());
	}

}
