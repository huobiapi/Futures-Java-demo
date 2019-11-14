package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


/**
 * 全部撤单
 * 备注
 * 只传symbol，撤该该品种下所有周期的合约
 * 只要有contract_code，则撤销该code的合约
 * 只传symbol+contract_type， 则撤销二者拼接所成的合约订单
 */
@Data
@AllArgsConstructor
@Builder
public class ContractCancelallRequest {
    private String symbol;//"BTC","ETH"...
    private String contractType;//合约类型 ("this_week":当周 "next_week":下周 "quarter":季度)
    private String contractCode;//BTC180914


}
