package com.huobi.api.request.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 获取历史成交记录
 */
@Data
@AllArgsConstructor
@Builder
public class ContractMatchresultsRequest {
    private String symbol;//品种代码	"BTC","ETH"...
    private Integer tradeType;//交易类型	0:全部,1:买入开多,2: 卖出开空,3: 买入平空,4: 卖出平多,5: 卖出强平,6: 买入强平
    private Integer createDate;//日期	7，90（7天或者90天）
    private String contractCode;//合约code
    private Integer pageIndex;//页码，不填默认第1页	1
    private Integer pageSize;//每页条数，不填默认20	20	不得多于50
}
