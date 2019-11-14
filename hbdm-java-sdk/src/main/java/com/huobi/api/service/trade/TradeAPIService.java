package com.huobi.api.service.trade;

import com.huobi.api.request.trade.*;
import com.huobi.api.response.trade.*;

public interface TradeAPIService {
    ContractOrderResponse contractOrderRequest(ContractOrderRequest request);//合约下单

    ContractBatchorderResponse contractBatchorderRequest(ContractBatchorderRequest request);//合约批量下单

    ContractCancelResponse contractCancelRequest(ContractCancelRequest request);//撤销订单

    ContractCancelallResponse contractCancelallRequest(ContractCancelallRequest request);//全部撤单

    ContractOrderInfoResponse contractOrderInfoRequest(ContractOrderInfoRequest request);//获取合约订单信息


    ContractOrderDetailResponse contractOrderDetailRequest(ContractOrderDetailRequest request);//获取订单明细信息

    ContractOpenordersResponse contractOpenordersRequest(ContractOpenordersRequest request);//获取合约当前未成交委托

    ContractHisordersResponse contractHisordersRequest(ContractHisordersRequest request);//获取合约历史委托

    ContractMatchresultsResponse contractMatchresultsRequest(ContractMatchresultsRequest request);//获取历史成交记录

    LightningClosePositionResponse lightningClosePositionRequest(LightningClosePositionRequest request);//闪电平仓下单
}
