package com.huobi.api.service.market;

import com.huobi.api.enums.TimePeriodTypeEnum;
import com.huobi.api.response.market.*;

public interface MarketAPIService {
    ContractContractCodeResponse getContractContractInfo(String symbol, String contractType, String contractCode);

    ContractIndexResponse getContractIndex(String symbol);

    ContractPriceLimitResponse getContractPriceLimit(String symbol, String contractType, String contractCode);

    ContractOpenInterestResponse getContractOpenInterest(String symbol, String contractType, String contractCode);

    ContractDeliveryPriceResponse getContractDeliveryPrice(String symbol);


    MarketDepthResponse getMarketDepth(String symbol, String contractType);

    MarketHistoryKlineResponse getMarketHistoryKline(String symbol, String period, Integer size);

    MarketDetailMergedResponse getMarketDetailMerged(String symbol);

    MarketTradeResponse getMarketTrade(String symbol);

    MarketHistoryTradeResponse getMarketHistoryTrade(String symbol, Integer size);


    ContractRiskInfoResponse getContractRiskInfo(String symbol);

    ContractInsuranceFundResponse getContractInsuranceFund(String symbol);

    ContractAdjustfactorResponse getContractAdjustfactor(String symbol);

    ContractHisOpenInterestResponse getContractHisOpenInterest(String symbol, String contractType, TimePeriodTypeEnum timePeriodType, Integer size, Integer amountType);

    ContractEliteAccountRatioResponse getContractEliteAccountRatio(String symbol, String period);


    ContractElitePositionRatioResponse getContractElitePositionRatio(String symbol, String period);

    ContractLiquidationOrdersResponse getContractLiquidationOrders(String symbol, Integer tradeType, Integer createDate, Integer pageIndex, Integer pageSize);

    ContractApiStateResponse getContractApiState(String symbol);//查询系统状态
}
