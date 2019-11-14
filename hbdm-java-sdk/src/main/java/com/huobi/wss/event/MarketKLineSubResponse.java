package com.huobi.wss.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class MarketKLineSubResponse {

    /**
     * ch : market.BTC_CQ.kline.1min
     * ts : 1489474082831
     * tick : {"id":1489464480,"mrid":268168237,"vol":100,"count":0,"open":7962.62,"close":7962.62,"low":7962.62,"high":7962.62,"amount":0.3}
     */

    private String ch;
    private Long ts;
    private TickBean tick;

    @Data
    @AllArgsConstructor
    public static class TickBean {
        /**
         * id : 1489464480
         * mrid : 268168237
         * vol : 100
         * count : 0
         * open : 7962.62
         * close : 7962.62
         * low : 7962.62
         * high : 7962.62
         * amount : 0.3
         */

        private Long id;
        private BigDecimal mrid;
        private BigDecimal vol;
        private BigDecimal count;
        private BigDecimal open;
        private BigDecimal close;
        private BigDecimal low;
        private BigDecimal high;
        private BigDecimal amount;

    }
}
