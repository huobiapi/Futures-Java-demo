package com.huobi.api.response.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractSubAccountInfoResponse {

    /**
     * status : ok
     * data : [{"symbol":"BTC","margin_balance":1,"margin_position":0,"margin_frozen":3.33,"margin_available":0.34,"profit_real":3.45,"profit_unreal":7.45,"withdraw_available":4.0989898,"risk_rate":100,"liquidation_price":100,"adjust_factor":0.1}]
     * ts : 158797866555
     */

    private String status;
    private long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * margin_balance : 1
         * margin_position : 0
         * margin_frozen : 3.33
         * margin_available : 0.34
         * profit_real : 3.45
         * profit_unreal : 7.45
         * withdraw_available : 4.0989898
         * risk_rate : 100
         * liquidation_price : 100
         * adjust_factor : 0.1
         */

        private String symbol;
        @SerializedName("margin_balance")
        private BigDecimal marginBalance;
        @SerializedName("margin_position")
        private BigDecimal marginPosition;
        @SerializedName("margin_frozen")
        private BigDecimal marginFrozen;
        @SerializedName("margin_available")
        private BigDecimal marginAvailable;
        @SerializedName("profit_real")
        private BigDecimal profitReal;
        @SerializedName("profit_unreal")
        private BigDecimal profitUnreal;
        @SerializedName("withdraw_available")
        private BigDecimal withdrawAvailable;
        @SerializedName("risk_rate")
        private BigDecimal riskRate;
        @SerializedName("liquidation_price")
        private BigDecimal liquidationPrice;
        @SerializedName("adjust_factor")
        private BigDecimal adjustFactor;
        @SerializedName("lever_rate")
        private Integer leverRate;
        @SerializedName("margin_static")
        private BigDecimal marginStatic;

    }
}
