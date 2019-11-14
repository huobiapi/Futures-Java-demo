package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


/**
 * 撤销订单
 * 备注：
 * order_id和client_order_id都可以用来撤单，同时只可以设置其中一种，如果设置了两种，默认以order_id来撤单。
 * <p>
 * 撤单接口返回结果只代表撤单命令发送成功，建议根据订单查询接口查询订单的状态来确定订单是否已真正撤销。
 */
@Data
@AllArgsConstructor
@Builder
public class ContractCancelRequest {
    private String orderId;//订单ID(多个订单ID中间以","分隔,一次最多允许撤消50个订单)
    private String clientOrderId;//客户订单ID(多个订单ID中间以","分隔,一次最多允许撤消50个订单)
    private String symbol;//"BTC","ETH"...
}
