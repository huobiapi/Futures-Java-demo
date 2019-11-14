package com.huobi.api.response.market;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class MarketDetailMergedResponse {

    /**
     * ch : market.BTC_CQ.detail.merged
     * status : ok
     * tick : {"amount":"351515.0554673879065919920182059260577760508","ask":[8444.32,180],"bid":[8444.31,2887],"close":"8444.31","count":622984,"high":"8855","id":1570779412,"low":"8400.01","open":"8610.32","ts":1570779413025,"vol":"30185276"}
     * ts : 1570779413025
     */

    private String ch;
    private String status;
    private TickBean tick;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class TickBean {
        /**
         * amount : 351515.0554673879065919920182059260577760508
         * ask : [8444.32,180]
         * bid : [8444.31,2887]
         * close : 8444.31
         * count : 622984
         * high : 8855
         * id : 1570779412
         * low : 8400.01
         * open : 8610.32
         * ts : 1570779413025
         * vol : 30185276
         */

        private String amount;
        private String close;
        private Integer count;
        private String high;
        private Integer id;
        private String low;
        private String open;
        private Long ts;
        private String vol;
        private List<BigDecimal> ask;
        private List<BigDecimal> bid;

    }
}
