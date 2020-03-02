package com.huobi.wss.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class MarketTradeDetailSubResponse {

    /**
     * ch : market.BTC_NW.trade.detail
     * ts : 1539831709042
     * tick : {"id":265842227,"ts":1539831709001,"data":[{"amount":20,"ts":1539831709001,"id":265842227259096443,"price":6742.25,"direction":"buy"}]}
     */

    private String ch;
    private Long ts;
    private TickBean tick;


    @Data
    @AllArgsConstructor
    public static class TickBean {
        /**
         * id : 265842227
         * ts : 1539831709001
         * data : [{"amount":20,"ts":1539831709001,"id":265842227259096443,"price":6742.25,"direction":"buy"}]
         */

        private Long id;
        private Long ts;
        private List<DataBean> data;


        @Data
        @AllArgsConstructor
        public static class DataBean {
            /**
             * amount : 20
             * ts : 1539831709001
             * id : 265842227259096443
             * price : 6742.25
             * direction : buy
             */

            private BigDecimal amount;
            private Long ts;
            private Long id;
            private BigDecimal price;
            private String direction;

        }
    }
}
