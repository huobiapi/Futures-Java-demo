package com.huobi.api.response.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractSubAccountListResponse {

    /**
     * status : ok
     * ts : 1499223904680
     * data : [{"sub_uid":9910049,"list":[{"symbol":"BTC","margin_balance":1,"liquidation_price":100,"risk_rate":100},{"symbol":"ETH","margin_balance":1,"liquidation_price":100,"risk_rate":100}]},{"sub_uid":9910048,"list":[{"symbol":"BTC","margin_balance":1,"liquidation_price":100,"risk_rate":100},{"symbol":"ETH","margin_balance":1,"liquidation_price":100,"risk_rate":100}]}]
     */

    private String status;
    private long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * sub_uid : 9910049
         * list : [{"symbol":"BTC","margin_balance":1,"liquidation_price":100,"risk_rate":100},{"symbol":"ETH","margin_balance":1,"liquidation_price":100,"risk_rate":100}]
         */

        @SerializedName("sub_uid")
        private Long subUid;
        private List<ListBean> list;

        @Data
        @AllArgsConstructor
        public static class ListBean {
            /**
             * symbol : BTC
             * margin_balance : 1
             * liquidation_price : 100
             * risk_rate : 100
             */

            private String symbol;
            @SerializedName("margin_balance")
            private BigDecimal marginBalance;
            @SerializedName("liquidation_price")
            private BigDecimal liquidationPrice;
            @SerializedName("risk_rate")
            private BigDecimal riskRate;

        }
    }
}
