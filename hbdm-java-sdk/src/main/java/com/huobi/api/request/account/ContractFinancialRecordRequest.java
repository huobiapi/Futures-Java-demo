package com.huobi.api.request.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ContractFinancialRecordRequest {
    private String symbol;//品种代码	"BTC","ETH"...
    private String type;//不填查询全部类型,【查询多类型中间用，隔开】	平多：3，平空：4，开仓手续费-吃单：5，开仓手续费-挂单：6，平仓手续费-吃单：7，平仓手续费-挂单：8，交割平多：9，交割平空：10，交割手续费：11，强制平多：12，强制平空：13，从币币转入：14，转出至币币：15，结算未实现盈亏-多仓：16，结算未实现盈亏-空仓：17，穿仓分摊：19，系统：26，活动奖励：28，返利：29
    private Integer createDate;//7，90 (7天 ，90天) ，不填默认为7
    private Integer pageIndex;//第几页,不填默认第一页
    private Integer pageSize;//不填默认20，不得多于50
}
