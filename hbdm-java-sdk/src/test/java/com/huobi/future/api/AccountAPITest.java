package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.request.account.ContractFinancialRecordRequest;
import com.huobi.api.response.account.*;
import com.huobi.api.service.account.AccountAPIServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class AccountAPITest implements BaseTest {


    AccountAPIServiceImpl huobiAPIService = new AccountAPIServiceImpl("", "");


    @Test
    public void getContractAccountInfo() {
        ContractAccountInfoResponse response = huobiAPIService.getContractAccountInfo("btc");
        logger.debug("1.获取用户账户信息：{}", JSON.toJSONString(response));
        response = huobiAPIService.getContractAccountInfo("");
        logger.debug("1.获取用户账户信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractPositionInfo() {
        ContractPositionInfoResponse response = huobiAPIService.getContractPositionInfo("btc");
        logger.debug("2.获取用户持仓信息：{}", JSON.toJSONString(response));

        response = huobiAPIService.getContractPositionInfo("");
        logger.debug("2.获取用户持仓信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractSubAccountList() {
        ContractSubAccountListResponse response = huobiAPIService.getContractSubAccountList("btc");
        logger.debug("3.查询母账户下所有子账户资产信息：{}", JSON.toJSONString(response));

        response = huobiAPIService.getContractSubAccountList("");
        logger.debug("3.查询母账户下所有子账户资产信息：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractSubAccountInfo() {
        ContractSubAccountInfoResponse response = huobiAPIService.getContractSubAccountInfo("", 1l);
        logger.debug("4.查询单个子账户资产信息：{}", JSON.toJSONString(response));
        logger.debug(response.getStatus());
    }

    @Test
    public void getContractSubPositionInfo() {
        ContractSubPositionInfoResponse response = huobiAPIService.getContractSubPositionInfo("", 1l);
        logger.debug("5.查询单个子账户持仓信息：{}", JSON.toJSONString(response));
        logger.debug(response.getStatus());
    }


    @Test
    public void getContractFinancialRecord() {

        ContractFinancialRecordRequest request = ContractFinancialRecordRequest.builder()
                .symbol("btc")
                .type("8")
                .build();
        ContractFinancialRecordResponse response = huobiAPIService.getContractFinancialRecord(request);
        logger.debug("6.查询用户财务记录：{}", JSON.toJSONString(response));
    }


    @Test
    public void getContractOrderLimitResponse() {
        ContractOrderLimitResponse response = huobiAPIService.getContractOrderLimitResponse("btc", "limit");
        logger.debug("7.查询用户当前的下单量限制：{}", JSON.toJSONString(response));
        response = huobiAPIService.getContractOrderLimitResponse("", "limit");
        logger.debug("7.查询用户当前的下单量限制：{}", JSON.toJSONString(response));
    }


    @Test
    public void getContractFeeResponse() {
        ContractFeeResponse response = huobiAPIService.getContractFeeResponse("btc");
        logger.debug("8.查询用户当前的手续费费率：{}", JSON.toJSONString(response));
        response = huobiAPIService.getContractFeeResponse("");
        logger.debug("8.查询用户当前的手续费费率：{}", JSON.toJSONString(response));
    }

    @Test
    public void getContractTransferLimitResponse() {
        ContractTransferLimitResponse response = huobiAPIService.getContractTransferLimitResponse("btc");
        logger.debug("9.查询用户当前的划转限制：{}", JSON.toJSONString(response));
        response = huobiAPIService.getContractTransferLimitResponse("");
        logger.debug("9.查询用户当前的划转限制：{}", JSON.toJSONString(response));
    }


    @Test
    public void getContractPositionLimitResponse() {
        ContractPositionLimitResponse response = huobiAPIService.getContractPositionLimitResponse("btc");
        logger.debug("10.用户持仓量限制的查询：{}", JSON.toJSONString(response));

        response = huobiAPIService.getContractPositionLimitResponse("");
        logger.debug("10.用户持仓量限制的查询：{}", JSON.toJSONString(response));
    }


}
