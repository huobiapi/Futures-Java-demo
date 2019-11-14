package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 闪电平仓下单
 */
@Data
@AllArgsConstructor
@Builder
public class LightningClosePositionRequest {
    private String symbol;//品种代码	"BTC","ETH"...
    private String contractType;//	合约类型	“this_week”:当周，“next_week”:次周，“quarter”:季度
    private String contractCode;//合约代码	BTC190903
    private Integer volume;//委托数量（张）
    private String direction;//“buy”:买，“sell”:卖
    private Long clientOrderId;//（API）客户自己填写和维护，必须保持唯一
}
