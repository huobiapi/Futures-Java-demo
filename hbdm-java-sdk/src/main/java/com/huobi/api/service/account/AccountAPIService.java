package com.huobi.api.service.account;


import com.huobi.api.request.account.ContractFinancialRecordRequest;
import com.huobi.api.request.trade.*;
import com.huobi.api.response.account.*;
import com.huobi.api.response.trade.*;

public interface AccountAPIService {


    //2获取合约资产接口开始
    ContractAccountInfoResponse getContractAccountInfo(String symbol);//获取用户账户信息

    ContractPositionInfoResponse getContractPositionInfo(String symbol);//获取用户持仓信息

    ContractSubAccountListResponse getContractSubAccountList(String symbol);//查询母账户下所有子账户资产信息

    ContractSubAccountInfoResponse getContractSubAccountInfo(String symbol, Long subUid);//查询单个子账户资产信息

    ContractSubPositionInfoResponse getContractSubPositionInfo(String symbol, Long subUid);//查询单个子账户持仓信息

    ContractFinancialRecordResponse getContractFinancialRecord(ContractFinancialRecordRequest request);//查询用户财务记录

    ContractOrderLimitResponse getContractOrderLimitResponse(String symbol, String orderPriceType);//查询用户当前的下单量限制

    ContractFeeResponse getContractFeeResponse(String symbol);//查询用户当前的手续费费率

    ContractTransferLimitResponse getContractTransferLimitResponse(String symbol);//查询用户当前的划转限制

    ContractPositionLimitResponse getContractPositionLimitResponse(String symbol);//用户持仓量限制的查询


    //2获取合约资产接口结束



}
