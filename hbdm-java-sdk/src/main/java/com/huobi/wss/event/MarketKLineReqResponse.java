package com.huobi.wss.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
public class MarketKLineReqResponse {


    /**
     * id :
     * rep : market.BTC_CQ.kline.1min
     * wsid : 3906345855
     * status : ok
     * data : [{"id":1572537600,"open":9346.52,"close":9362.95,"low":9346.51,"high":9370,"amount":600.2317307880123,"vol":56170,"count":1025}]
     */

    private String id;
    private String rep;
    private Long wsid;
    private String status;
    private List<DataBean> data;


    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * id : 1572537600
         * open : 9346.52
         * close : 9362.95
         * low : 9346.51
         * high : 9370
         * amount : 600.2317307880123
         * vol : 56170
         * count : 1025
         */

        private Long id;
        private BigDecimal open;
        private BigDecimal close;
        private BigDecimal low;
        private BigDecimal high;
        private BigDecimal amount;
        private BigDecimal vol;
        private BigDecimal count;

    }
}
