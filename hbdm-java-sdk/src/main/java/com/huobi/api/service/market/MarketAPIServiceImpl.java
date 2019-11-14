package com.huobi.api.service.market;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.enums.TimePeriodTypeEnum;
import com.huobi.api.exception.ApiException;
import com.huobi.api.response.market.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MarketAPIServiceImpl implements MarketAPIService {

    String url_prex = "https://api.hbdm.com";


    /**
     * @param symbol       "BTC","ETH"...
     * @param contractType 合约类型: （this_week:当周 next_week:下周 quarter:季度）
     * @param contractCode 合约code
     * @return 如果不填，默认查询所有所有合约信息; 如果contract_code填了值，那就按照contract_code去查询; 如果contract_code没有填值，则按照symbol+contract_type去查询;
     */
    @Override
    public ContractContractCodeResponse getContractContractInfo(String symbol, String contractType, String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            if (StringUtils.isNotEmpty(contractType)) {
                params.put("contract_type", contractType);
            }
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_CONTRACT_INFO, params);
            ContractContractCodeResponse response = JSON.parseObject(body, ContractContractCodeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);


    }

    @Override
    public ContractIndexResponse getContractIndex(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_INDEX, params);
            ContractIndexResponse response = JSON.parseObject(body, ContractIndexResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractPriceLimitResponse getContractPriceLimit(String symbol, String contractType, String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            if (StringUtils.isNotEmpty(contractType)) {
                params.put("contract_type", contractType);
            }
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_PRICE_LIMIT, params);
            ContractPriceLimitResponse response = JSON.parseObject(body, ContractPriceLimitResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    /**
     * 获取当前可用合约总持仓量
     *
     * @param symbol       "BTC","ETH"...
     * @param contractType 合约类型 (当周:"this_week", 次周:"next_week", 季度:"quarter")
     * @param contractCode BTC191018
     * @return
     */
    @Override
    public ContractOpenInterestResponse getContractOpenInterest(String symbol, String contractType, String contractCode) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            if (StringUtils.isNotEmpty(contractType)) {
                params.put("contract_type", contractType);
            }
            if (StringUtils.isNotEmpty(contractCode)) {
                params.put("contract_code", contractCode);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_OPEN_INTEREST, params);
            ContractOpenInterestResponse response = JSON.parseObject(body, ContractOpenInterestResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractDeliveryPriceResponse getContractDeliveryPrice(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_DELIVERY_PRICE, params);
            ContractDeliveryPriceResponse response = JSON.parseObject(body, ContractDeliveryPriceResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarketDepthResponse getMarketDepth(String symbol, String type) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            if (StringUtils.isNotEmpty(type)) {
                params.put("type", type);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_DEPTH, params);
            MarketDepthResponse response = JSON.parseObject(body, MarketDepthResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    /**
     * 获取K线数据
     *
     * @param symbol 合约名称 如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约
     * @param period K线类型  1min, 5min, 15min, 30min, 60min,4hour,1day, 1mon
     * @param size   获取数量  默认： 150	 取值范围：[1,2000]
     * @return
     */
    @Override
    public MarketHistoryKlineResponse getMarketHistoryKline(String symbol, String period, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol.toUpperCase());
            params.put("period", period);
            params.put("size", size);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_HISTORY_KLINE, params);
            MarketHistoryKlineResponse response = JSON.parseObject(body, MarketHistoryKlineResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarketDetailMergedResponse getMarketDetailMerged(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_DETAIL_MERGED, params);
            MarketDetailMergedResponse response = JSON.parseObject(body, MarketDetailMergedResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarketTradeResponse getMarketTrade(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_TRADE, params);
            MarketTradeResponse response = JSON.parseObject(body, MarketTradeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public MarketHistoryTradeResponse getMarketHistoryTrade(String symbol, Integer size) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            if (size != null) {
                params.put("size", size);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.MARKET_HISTORY_TRADE, params);
            MarketHistoryTradeResponse response = JSON.parseObject(body, MarketHistoryTradeResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractRiskInfoResponse getContractRiskInfo(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_RISK_INFO, params);
            ContractRiskInfoResponse response = JSON.parseObject(body, ContractRiskInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractInsuranceFundResponse getContractInsuranceFund(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_INSURANCE_FUND, params);
            ContractInsuranceFundResponse response = JSON.parseObject(body, ContractInsuranceFundResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractAdjustfactorResponse getContractAdjustfactor(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_ADJUSTFACTOR, params);
            ContractAdjustfactorResponse response = JSON.parseObject(body, ContractAdjustfactorResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractHisOpenInterestResponse getContractHisOpenInterest(String symbol, String contractType, TimePeriodTypeEnum timePeriodType, Integer size, Integer amountType) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol);
            }
            if (StringUtils.isNotEmpty(contractType)) {
                params.put("contract_type", contractType);
            }
            if (timePeriodType != null) {
                params.put("period", timePeriodType.getValue());
            }

            if (size != null) {
                params.put("size", size);
            }
            if (amountType != null) {
                params.put("amount_type", amountType);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_HIS_OPEN_INTEREST, params);
            ContractHisOpenInterestResponse response = JSON.parseObject(body, ContractHisOpenInterestResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractEliteAccountRatioResponse getContractEliteAccountRatio(String symbol, String period) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol);
            params.put("period", period);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_ELITE_ACCOUNT_RATIO, params);
            ContractEliteAccountRatioResponse response = JSON.parseObject(body, ContractEliteAccountRatioResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractElitePositionRatioResponse getContractElitePositionRatio(String symbol, String period) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol);
            params.put("period", period);
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_ELITE_POSITION_RATIO, params);
            ContractElitePositionRatioResponse response = JSON.parseObject(body, ContractElitePositionRatioResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    @Override
    public ContractLiquidationOrdersResponse getContractLiquidationOrders(String symbol, Integer tradeType, Integer createDate, Integer pageIndex, Integer pageSize) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", symbol);
            params.put("trade_type", tradeType);
            params.put("create_date", createDate);


            if (pageIndex != null) {
                params.put("page_index", pageIndex);
            }
            if (pageSize != null) {
                params.put("page_size", pageSize);
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_LIQUIDATION_ORDERS, params);
            ContractLiquidationOrdersResponse response = JSON.parseObject(body, ContractLiquidationOrdersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }

    /**
     * 查询系统状态
     *
     * @param symbol 如果缺省，默认返回所有品种
     * @return
     */
    @Override
    public ContractApiStateResponse getContractApiState(String symbol) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(symbol)) {
                params.put("symbol", symbol.toUpperCase());
            }
            body = HbdmHttpClient.getInstance().doGet(url_prex + HuobiFutureAPIConstants.CONTRACT_API_STATE, params);
            ContractApiStateResponse response = JSON.parseObject(body, ContractApiStateResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            body = e.getMessage();
        }
        throw new ApiException(body);
    }
}
