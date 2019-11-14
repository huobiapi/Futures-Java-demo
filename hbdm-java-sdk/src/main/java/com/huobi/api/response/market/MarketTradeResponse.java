package com.huobi.api.response.market;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MarketTradeResponse {
    /**
     * ch : market.BTC_CQ.trade.detail
     * status : ok
     * tick : {"data":[{"amount":"4","direction":"sell","id":215887296800001,"price":"8440.22","ts":1570779457271}],"id":1570779457791,"ts":1570779457791}
     * ts : 1570779457791
     */

    private String ch;
    private String status;
    private TickBean tick;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class TickBean {
        /**
         * data : [{"amount":"4","direction":"sell","id":215887296800001,"price":"8440.22","ts":1570779457271}]
         * id : 1570779457791
         * ts : 1570779457791
         */

        private Long id;
        private Long ts;
        private List<DataBean> data;

        @Data
        @AllArgsConstructor
        public static class DataBean {
            /**
             * amount : 4
             * direction : sell
             * id : 215887296800001
             * price : 8440.22
             * ts : 1570779457271
             */

            private String amount;
            private String direction;
            private Long id;
            private String price;
            private Long ts;

        }
    }
}
