package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ContractDeliveryPriceResponse {


    /**
     * status : ok
     * data : {"delivery_price":8422.236174351585}
     * ts : 1570779282124
     */

    private String status;
    private DataBean data;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * delivery_price : 8422.236174351585
         */

        @SerializedName("delivery_price")
        private BigDecimal deliveryPrice;

    }
}
