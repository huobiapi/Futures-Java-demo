package com.huobi.common.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huobi.common.request.Order;

public class HbdmClient {
	private static Logger logger = LoggerFactory.getLogger(HbdmClient.class);

	public static void main(String[] args) throws HttpException, IOException {

		/**
		 * get请求无需发送身份认证,通常用于获取行情，市场深度等公共信息
		 */
		String api_key = ""; // huobi申请的apiKey,API调试过程中有问题或者有疑问可反馈微信号shaoxiaofeng1118
		String secret_key = ""; // huobi申请的secretKey
		String url_prex = "https://api.hbdm.com";//火币api接口地址https://api.hbdm.com
		IHbdmRestApi futureGetV1 = new HbdmRestApiV1(url_prex);
		IHbdmRestApi futurePostV1 = new HbdmRestApiV1(url_prex, api_key, secret_key);

		// 获取合约信息
		String contractInfo = futureGetV1.futureContractInfo("BTC", "", "");
		logger.info("获取合约信息" + contractInfo);

		// 获取合约指数信息
		String contractindex = futureGetV1.futureContractIndex("BTC");
		logger.info("获取合约指数信息" + contractindex);

		// 获取合约最高限价和最低限价
		String pricelimit = futureGetV1.futurePriceLimit("BTC", "", "");
		logger.info("获取合约最高限价和最低限价" + pricelimit);
		// 获取当前可用合约总持仓量
		String openInterest = futureGetV1.futureOpenInterest("BTC", "", "");
		logger.info("获取当前可用合约总持仓量" + openInterest);

		// 获取行情深度数据
		String marketDepth = futureGetV1.futureMarketDepth("BTC_CW", "step0");
		logger.info("获取行情深度数据" + marketDepth);

		// 获取K线数据
		String historyKline = futureGetV1.futureMarketHistoryKline("BTC_CW", "15min","100");
		logger.info("获取K线数据" + historyKline);

		// 获取聚合行情
		String merged = futureGetV1.futureMarketDetailMerged("BTC_CW");
		logger.info("获取聚合行情" + merged);

		// 获取市场最近成交记录
		String trade = futurePostV1.futureMarketDetailTrade("BTC_CW", "10");
		logger.info("获取市场最近成交记录" + trade);

		// 批量获取最近的交易记录
		String historTrade = futurePostV1.futureMarketHistoryTrade("BTC_CW", "10");
		logger.info("批量获取最近的交易记录" + historTrade);
		// 获取用户账户信息
		String accountInfo = futurePostV1.futureContractAccountInfo("BTC");
		logger.info("获取用户账户信息" + accountInfo);

		// 获取用户持仓信息
		String positionInfo = futurePostV1.futureContractPositionInfo("BTC");
		logger.info("获取用户持仓信息" + positionInfo);

		// 合约下单
		String contractOrder = futurePostV1.futureContractOrder("BTC", "this_week", "BTC181116", "", "6188", "12",
				"buy", "open", "10", "limit");

		logger.info("合约下单返回" + contractOrder);
		
		//批量下单
		List<Order> orders = new ArrayList<>();
		Order order1 = new Order("BTC", "this_week", "BTC181110", "10", "6400", "1","buy", "open", "10", "limit");
		Order order2 = new Order("BTC", "this_week", "BTC181110", "12", "6398", "2","buy", "open", "10", "limit");
		orders.add(order1);
		orders.add(order2);
		String futureContractBatchOorder = futurePostV1.futureContractBatchorder(orders);
		logger.info("批量下单返回" + futureContractBatchOorder);

		// 合约取消订单
		String contractcancel = futurePostV1.futureContractCancel("123556", "","BTC");
		logger.info("合约取消订单" + contractcancel);

		// 合约全部撤单
		String contractCancelall = futurePostV1.futureContractCancelall("BTC");
		logger.info("合约全部撤单" + contractCancelall);

		// 获取合约订单信息
		String contractOrderInfo = futurePostV1.futureContractOrderInfo("4", "","BTC","1");
		logger.info("获取合约订单信息" + contractOrderInfo);

		// 获取订单明细信息
		String detail = futurePostV1.futureContractOrderDetail("BTC", "123556", "1", "100","1539345271124","1");
		logger.info("获取订单明细信息" + detail);

		// 获取合约当前未成交委托
		String openorders = futurePostV1.futureContractOpenorders("BTC", "1", "100");
		logger.info("获取合约当前未成交委托" + openorders);

		// 获取合约历史委托
		String orderDetail = futurePostV1.futureContractHisorders("BTC", "0", "1", "0", "90", "1", "20");
		logger.info("获取合约历史委托" + orderDetail);
	}

}
