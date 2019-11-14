package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 备注
 * 如果contract_code填了值，那就按照contract_code去下单，如果contract_code没有填值，则按照symbol+contract_type去下单。
 * <p>
 * 对手价下单price价格参数不用传，对手价下单价格是买一和卖一价,optimal_5：最优5档、optimal_10：最优10档、optimal_20：最优20档下单price价格参数不用传，"limit":限价，"post_only":只做maker单 需要传价格。
 * <p>
 * 一次最多允许20个订单。
 */
@Data
@AllArgsConstructor
@Builder
public class ContractBatchorderRequest {
    private List<ContractOrderRequest> list;

}
