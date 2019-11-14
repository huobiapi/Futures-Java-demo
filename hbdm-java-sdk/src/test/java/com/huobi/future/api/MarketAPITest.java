package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.enums.TimePeriodTypeEnum;
import com.huobi.api.response.market.*;
import com.huobi.api.service.market.MarketAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class MarketAPITest implements BaseTest {

    MarketAPIServiceImpl huobiAPIService = new MarketAPIServiceImpl();


    @Test
    public void getContractContractInfo() {
        ContractContractCodeResponse result =
                huobiAPIService.getContractContractInfo("", "", "");
        logger.debug("1.获取合约信息：{}", JSON.toJSONString(result));
    }

    //ok
    @Test
    public void getContractIndex() {
        ContractIndexResponse result =
                huobiAPIService.getContractIndex("btc");
        logger.debug("2.获取合约指数信息：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractPriceLimit() {
        ContractPriceLimitResponse result =
                huobiAPIService.getContractPriceLimit("btc", "this_week", "");
        logger.debug("3.获取合约最高限价和最低限价：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractOpenInterest() {
        ContractOpenInterestResponse result =
                huobiAPIService.getContractOpenInterest("btc", "this_week", "");
        logger.debug("4.获取当前可用合约总持仓量：{}", JSON.toJSONString(result));
        result =
                huobiAPIService.getContractOpenInterest("", "", "");
        logger.debug("4.获取当前可用合约总持仓量：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractDeliveryPrice() {
        ContractDeliveryPriceResponse result =
                huobiAPIService.getContractDeliveryPrice("btc");
        logger.debug("5.获取预估交割价：{}", JSON.toJSONString(result));
    }


    @Test
    public void getMarketDepth() {
        MarketDepthResponse result =
                huobiAPIService.getMarketDepth("BTC_CW", "step0");
        logger.debug("6.获取行情深度数据：{}", JSON.toJSONString(result));
    }


    @Test
    public void getMarketHistoryKline() {
        MarketHistoryKlineResponse result =
                huobiAPIService.getMarketHistoryKline("btc_cw", "1min", 10);
        logger.debug("7.获取K线数据：{}", JSON.toJSONString(result));
    }

    @Test
    public void getMarketDetailMerged() {
        MarketDetailMergedResponse result =
                huobiAPIService.getMarketDetailMerged("btc_cw");
        logger.debug("8.获取聚合行情：{}", JSON.toJSONString(result));
    }

    @Test
    public void getMarketTrade() {
        MarketTradeResponse result =
                huobiAPIService.getMarketTrade("btc_cw");
        logger.debug("获取市场最近成交记录：{}", JSON.toJSONString(result));
    }

    @Test
    public void getMarketHistoryTrade() {
        MarketHistoryTradeResponse result =
                huobiAPIService.getMarketHistoryTrade("btc_cw", 10);
        logger.debug("批量获取最近的交易记录：{}", JSON.toJSONString(result));
    }


    @Test
    public void getContractRiskInfoResponse() {
        ContractRiskInfoResponse result =
                huobiAPIService.getContractRiskInfo("btc");
        logger.debug("查询合约风险准备金余额和预估分摊比例：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractInsuranceFundResponse() {
        ContractInsuranceFundResponse result =
                huobiAPIService.getContractInsuranceFund("btc");
        logger.debug("查询合约风险准备金余额历史数据：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractAdjustfactorResponse() {
        ContractAdjustfactorResponse result =
                huobiAPIService.getContractAdjustfactor("btc");
        logger.debug("查询平台阶梯调整系数：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractHisOpenInterestResponse() {
        ContractHisOpenInterestResponse result =
                huobiAPIService.getContractHisOpenInterest("btc", "this_week", TimePeriodTypeEnum.ONE_DAY, 10, 1);
        logger.debug("平台持仓量的查询：{}", JSON.toJSONString(result));
    }


    @Test
    public void getContractEliteAccountRatioResponse() {
        ContractEliteAccountRatioResponse result =
                huobiAPIService.getContractEliteAccountRatio("btc", "60min");
        logger.debug("15.精英账户多空持仓对比-账户数：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractElitePositionRatioResponse() {
        ContractElitePositionRatioResponse result =
                huobiAPIService.getContractElitePositionRatio("btc", "5min");
        logger.debug("16.精英账户多空持仓对比-持仓量：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractLiquidationOrdersResponse() {
        ContractLiquidationOrdersResponse result =
                huobiAPIService.getContractLiquidationOrders("btc", 0, 7, null, null);
        logger.debug("17.获取强平订单：{}", JSON.toJSONString(result));
    }

    @Test
    public void getContractApiState() {
        ContractApiStateResponse result =
                huobiAPIService.getContractApiState("");
        logger.debug("18.查询系统状态：{}", JSON.toJSONString(result));
    }


}
