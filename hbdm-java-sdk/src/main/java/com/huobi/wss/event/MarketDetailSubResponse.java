package com.huobi.wss.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MarketDetailSubResponse {
    /**
     * ch : market.BTC_CW.detail
     * ts : 1539842340724
     * tick : {"id":1539842340,"mrid":268041138,"open":6740.47,"close":7800,"high":7800,"low":6726.13,"amount":477.12003120752445,"vol":32414,"count":1716}
     */

    private String ch;
    private Long ts;
    private TickBean tick;


    @Data
    @AllArgsConstructor
    public static class TickBean {
        /**
         * id : 1539842340
         * mrid : 268041138
         * open : 6740.47
         * close : 7800
         * high : 7800
         * low : 6726.13
         * amount : 477.12003120752445
         * vol : 32414
         * count : 1716
         */

        private Long id;
        private Long mrid;
        private BigDecimal open;
        private BigDecimal close;
        private BigDecimal high;
        private BigDecimal low;
        private BigDecimal amount;
        private BigDecimal vol;
        private BigDecimal count;

    }
}
