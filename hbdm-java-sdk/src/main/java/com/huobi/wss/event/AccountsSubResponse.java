package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountsSubResponse {


    /**
     * op : notify
     * topic : accounts
     * ts : 1583239414628
     * event : init
     * data : [{"symbol":"BTC","margin_balance":1.7535590617661905,"margin_static":1.7355318016108807,"margin_position":0.33021635865066457,"margin_frozen":0,"margin_available":1.423342703115526,"profit_real":0.014472102710629512,"profit_unreal":0.0180272601553096,"risk_rate":5.280333712513856,"liquidation_price":4373.089742505218,"withdraw_available":1.4053154429602162,"lever_rate":5,"adjust_factor":0.03}]
     */

    private String op;
    private String topic;
    private long ts;
    private String event;
    private List<DataBean> data;


    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * margin_balance : 1.7535590617661905
         * margin_static : 1.7355318016108807
         * margin_position : 0.33021635865066457
         * margin_frozen : 0.0
         * margin_available : 1.423342703115526
         * profit_real : 0.014472102710629512
         * profit_unreal : 0.0180272601553096
         * risk_rate : 5.280333712513856
         * liquidation_price : 4373.089742505218
         * withdraw_available : 1.4053154429602162
         * lever_rate : 5
         * adjust_factor : 0.03
         */

        private String symbol;
        @SerializedName("margin_balance")
        private BigDecimal marginBalance;
        @SerializedName("margin_static")
        private BigDecimal marginStatic;
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
        @SerializedName("risk_rate")
        private BigDecimal riskRate;
        @SerializedName("liquidation_price")
        private BigDecimal liquidationPrice;
        @SerializedName("withdraw_available")
        private BigDecimal withdrawAvailable;
        @SerializedName("lever_rate")
        private int leverRate;
        @SerializedName("adjust_factor")
        private BigDecimal adjustFactor;

    }
}
