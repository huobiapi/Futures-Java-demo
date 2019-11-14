package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 获取订单明细信息
 */
@Data
@AllArgsConstructor
@Builder
public class ContractOrderDetailRequest {
    private String symbol;//"BTC","ETH"...
    private Long orderId;//订单id
    private Long createdAt;//下单时间戳
    private Integer orderType;//订单类型，1:报单 、 2:撤单 、 3:强平、4:交割
    private Integer pageIndex;//第几页,不填第一页
    private Integer pageSize;//不填默认20，不得多于50
}
