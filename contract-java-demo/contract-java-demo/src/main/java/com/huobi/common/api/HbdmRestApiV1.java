package com.huobi.common.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpException;

import com.alibaba.fastjson.JSON;
import com.huobi.common.request.Order;
import com.huobi.common.util.HbdmHttpClient;

public class HbdmRestApiV1 implements IHbdmRestApi {

	private String secret_key;

	private String api_key;

	private String url_prex;

	public HbdmRestApiV1(String url_prex, String api_key, String secret_key) {
		this.api_key = api_key;
		this.secret_key = secret_key;
		this.url_prex = url_prex;
	}

	public HbdmRestApiV1(String url_prex) {
		this.url_prex = url_prex;

	}

	public static final String HUOBI_FUTURE_TICKER = "/market/detail/merged";
	public static final String HUOBI_FUTURE_DEPTH = "/market/depth";
	public static final String HUOBI_FUTURE_KLINE = "/market/history/kline";
	public static final String HUOBI_FUTURE_TRADE = "/market/history/trade";

	// 获取合约信息 /v1/contract_contract_info
	public static final String HUOBI_FUTURE_CONTRACT_INFO = "/api/v1/contract_contract_info";
	// 获取合约指数v1/contract_index
	public static final String HUOBI_FUTURE_CONTRACT_INDEX = "/api/v1/contract_index";
	// 获取合约最低最高限价/v1/contract_price_limit
	public static final String HUOBI_FUTURE_CONTRACT_PRICE_LIMIT = "/api/v1/contract_price_limit";

	// 获取合约总持仓量
	public static final String HUOBI_FUTURE_CONTRACT_OPEN_INTEREST = "/api/v1/contract_open_interest";

	// 订单明细
	public static final String HUOBI_FUTURE_CONTRACT_ORDER_DETAIL = "/api/v1/contract_order_detail";

	public static final String HUOBI_FUTURE_CONTRACT_HISORDERS = "/api/v1/contract_hisorders";

	// 批量下单contract_batchorder
	public static final String HUOBI_FUTURE_CONTRACT_BATCHORDER = "/api/v1/contract_batchorder";
	// account相关
	public static final String HUOBI_FUTURE_ACCOUNT_INFO = "/api/v1/contract_account_info";
	public static final String HUOBI_FUTURE_POSITION_INFO = "/api/v1/contract_position_info";
	public static final String HUOBI_FUTURE_ORDER = "/api/v1/contract_order";
	public static final String HUOBI_FUTURE_ORDER_CANCEL = "/api/v1/contract_cancel";
	public static final String HUOBI_FUTURE_ORDER_INFO = "/api/v1/contract_order_info";
	public static final String HUOBI_FUTURE_ORDER_CANCEL_ALL = "/api/v1/contract_cancelall";
	public static final String HUOBI_CONTRACE_CODE = "/api/v1/contract_open_interest";
	public static final String HUOBI_CONTRACE_OPENORDERS = "/api/v1/contract_openorders";

	@Override
	public String futureContractInfo(String symbol, String contractType, String contractCode) {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(contractType)) {
			params.put("contract_type", contractType);
		}
		if (!StringUtils.isEmpty(symbol)) {
			params.put("contract_code", contractCode);
		}
		String contractinfoRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_CONTRACT_INFO, params);
		return contractinfoRes;
	}

	@Override
	public String futureContractIndex(String symbol) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		String contractindexRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_CONTRACT_INDEX,
				params);
		return contractindexRes;
	}

	@Override
	public String futurePriceLimit(String symbol, String contractType, String contractCode)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(contractType)) {
			params.put("contract_type", contractType);
		}
		if (!StringUtils.isEmpty(symbol)) {
			params.put("contract_code", contractCode);
		}
		String contractinfoRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_CONTRACT_PRICE_LIMIT,
				params);
		return contractinfoRes;
	}

	@Override
	public String futureOpenInterest(String symbol, String contractType, String contractCode)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(contractType)) {
			params.put("contract_type", contractType);
		}
		if (!StringUtils.isEmpty(symbol)) {
			params.put("contract_code", contractCode);
		}
		String contractinfoRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_CONTRACT_OPEN_INTEREST,
				params);
		return contractinfoRes;
	}

	public String futureMarketDepth(String symbol, String type) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(type)) {
			params.put("type", type);
		}
		String contractinfoRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_DEPTH, params);
		return contractinfoRes;
	}

	public String futureMarketHistoryKline(String symbol, String period,String size) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(period)) {
			params.put("period", period);
		}
		if (!StringUtils.isEmpty(size)) {
			params.put("size", size);
		}
		String res = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_KLINE, params);
		return res;
	}

	public String futureMarketDetailMerged(String symbol) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}		
		String res = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_TICKER, params);
		return res;
	}

	public String futureMarketDetailTrade(String symbol, String size) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(size)) {
			params.put("size", size);
		}
		String res = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_TRADE, params);
		return res;
	}

	public String futureMarketHistoryTrade(String symbol, String size) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(size)) {
			params.put("size", size);
		}
		String res = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_TRADE, params);
		return res;
	}

	public String futureContractAccountInfo(String symbol) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}

		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_ACCOUNT_INFO, params, new HashMap<>());
		return res;
	}

	public String futureContractPositionInfo(String symbol) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}

		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_POSITION_INFO, params, new HashMap<>());
		return res;
	}

	public String futureContractOrder(String symbol, String contractType, String contractCode, String clientOrderId,
			String price, String volume, String direction, String offset, String leverRate, String orderPriceType)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(contractType)) {
			params.put("contract_type", contractType);
		}

		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(clientOrderId)) {
			params.put("client_order_id", clientOrderId);
		}
		if (!StringUtils.isEmpty(price)) {
			params.put("price", price);
		}
		if (!StringUtils.isEmpty(volume)) {
			params.put("volume", volume);
		}
		if (!StringUtils.isEmpty(direction)) {
			params.put("direction", direction);
		}
		if (!StringUtils.isEmpty(offset)) {
			params.put("offset", offset);
		}
		if (!StringUtils.isEmpty(leverRate)) {
			params.put("lever_rate", leverRate);
		}
		if (!StringUtils.isEmpty(orderPriceType)) {
			params.put("order_price_type", orderPriceType);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST", url_prex + HUOBI_FUTURE_ORDER,
				params, new HashMap<>());
		return res;
	}

	public String futureContractBatchorder(List<Order> orders) throws HttpException, IOException {
		Map<String, Object> params = new HashMap<>();
		params.put("orders_data", orders);
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST", url_prex + HUOBI_FUTURE_CONTRACT_BATCHORDER,
				params, new HashMap<>());
		return res;
	}

	public String futureContractCancel(String orderId, String clientOrderId,String symbol) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(orderId)) {
			params.put("order_id", orderId);
		}
		if (!StringUtils.isEmpty(clientOrderId)) {
			params.put("client_order_id", clientOrderId);
		}
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_ORDER_CANCEL, params, new HashMap<>());
		return res;
	}

	public String futureContractCancelall(String symbol) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}

		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_ORDER_CANCEL_ALL, params, new HashMap<>());
		return res;
	}

	public String futureContractOrderInfo(String orderId, String clientOrderId,String symbol,String orderType) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(orderId)) {
			params.put("order_id", orderId);
		}
		if (!StringUtils.isEmpty(clientOrderId)) {
			params.put("client_order_id", clientOrderId);
		}
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(symbol)) {
			params.put("order_type", orderType);
		}	
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_ORDER_INFO, params, new HashMap<>());
		return res;
	}

	public String futureContractOrderDetail(String symbol, String orderId, String pageIndex, String pageSize,String createdAt,String orderType)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(orderId)) {
			params.put("order_id", orderId);
		}
		if (!StringUtils.isEmpty(pageIndex)) {
			params.put("page_index", pageIndex);
		}
		if (!StringUtils.isEmpty(pageSize)) {
			params.put("page_size", pageSize);
		}
		if (!StringUtils.isEmpty(createdAt)) {
			params.put("created_at", createdAt);
		}
		if (!StringUtils.isEmpty(orderType)) {
			params.put("order_type", orderType);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_CONTRACT_ORDER_DETAIL, params, new HashMap<>());
		return res;
	}

	public String futureContractOpenorders(String symbol, String pageIndex, String pageSize)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(pageIndex)) {
			params.put("page_index", pageIndex);
		}
		if (!StringUtils.isEmpty(pageSize)) {
			params.put("page_size", pageSize);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_CONTRACE_OPENORDERS, params, new HashMap<>());
		return res;
	}

	public String futureContractHisorders(String symbol, String tradeType, String type, String status,
			String createDate, String pageIndex, String pageSize) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(symbol)) {
			params.put("symbol", symbol);
		}
		if (!StringUtils.isEmpty(tradeType)) {
			params.put("trade_type", tradeType);
		}
		if (!StringUtils.isEmpty(type)) {
			params.put("type", type);
		}
		if (!StringUtils.isEmpty(createDate)) {
			params.put("create_date", createDate);
		}
		if (!StringUtils.isEmpty(status)) {
			params.put("status", status);
		}
		if (!StringUtils.isEmpty(pageIndex)) {
			params.put("page_index", pageIndex);
		}
		if (!StringUtils.isEmpty(pageSize)) {
			params.put("page_size", pageSize);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_CONTRACT_HISORDERS, params, new HashMap<>());
		return res;
	}
}
