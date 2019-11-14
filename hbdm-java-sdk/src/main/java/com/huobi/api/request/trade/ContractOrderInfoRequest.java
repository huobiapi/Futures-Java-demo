package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 获取合约订单信息
 * 备注：
 * order_id和client_order_id都可以用来查询，同时只可以设置其中一种，如果设置了两种，默认以order_id来查询。周五交割结算后，会把结束状态的订单（5部分成交已撤单 6全部成交 7已撤单）删除掉。
 * <p>
 * client_order_id，24小时有效，超过24小时的订单根据client_order_id将查询不到。
 */
@Data
@AllArgsConstructor
@Builder
public class ContractOrderInfoRequest {
    private String orderId;//订单ID(多个订单ID中间以","分隔,一次最多允许查询50个订单)
    private String clientOrderId;//客户订单ID(多个订单ID中间以","分隔,一次最多允许查询50个订单)
    private String symbol;//"BTC","ETH"...
}
