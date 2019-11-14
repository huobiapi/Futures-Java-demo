package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractIndexResponse {


    /**
     * status : ok
     * data : [{"symbol":"BTC","index_price":8456.1525,"index_ts":1570773156009},{"symbol":"BSV","index_price":86.66406256393333,"index_ts":1570773156009},{"symbol":"BCH","index_price":227.80188098,"index_ts":1570773156009},{"symbol":"XRP","index_price":0.2695273939,"index_ts":1570773156009},{"symbol":"ETH","index_price":188.90368889,"index_ts":1570773156009},{"symbol":"EOS","index_price":3.073967118625,"index_ts":1570773156009},{"symbol":"LTC","index_price":56.5775746625,"index_ts":1570773156009},{"symbol":"TRX","index_price":0.01612614503,"index_ts":1570773156009}]
     * ts : 1570773159720
     */

    private String status;
    private Long ts;
    private List<DataBean> data;


    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * index_price : 8456.1525
         * index_ts : 1570773156009
         */

        private String symbol;
        @SerializedName("index_price")
        private BigDecimal indexPrice;
        @SerializedName("index_ts")
        private Long indexTs;

    }
}
