package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 获取合约历史委托
 */
@Data
@AllArgsConstructor
@Builder
public class ContractHisordersRequest {
    private String symbol;//品种代码	"BTC","ETH"...
    private Integer tradeType;//交易类型	0:全部,1:买入开多,2: 卖出开空,3: 买入平空,4: 卖出平多,5: 卖出强平,6: 买入强平,7:交割平多,8: 交割平空
    private Integer type;//类型	1:所有订单,2:结束状态的订单
    private Integer status;//订单状态	0:全部,3:未成交, 4: 部分成交,5: 部分成交已撤单,6: 全部成交,7:已撤单
    private Integer createDate;//日期	7，90（7天或者90天）
    private String contractCode;//合约代码
    private String orderType;//订单类型  1：限价单、3：对手价、4：闪电平仓、5：计划委托、6：post_only、7：最优5档、8：最优10档、9：最优20档、10：fok、11：ioc
    private Integer pageIndex;//页码，不填默认第1页	1
    private Integer pageSize;//每页条数，不填默认20	20	不得多于50
}
