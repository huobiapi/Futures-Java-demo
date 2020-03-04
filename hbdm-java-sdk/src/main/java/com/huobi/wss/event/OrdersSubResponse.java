package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class OrdersSubResponse {


    /**
     * op : notify
     * topic : orders.btc
     * ts : 1583240402714
     * symbol : BTC
     * contract_type : quarter
     * contract_code : BTC200327
     * volume : 1
     * price : 8902.14
     * order_price_type : opponent
     * direction : sell
     * offset : close
     * status : 6
     * lever_rate : 5
     * order_id : 684505389551849472
     * order_id_str : 684505389551849472
     * client_order_id : null
     * order_source : android
     * order_type : 1
     * created_at : 1583240402365
     * trade_volume : 1
     * trade_turnover : 100.0
     * fee : -2.246650805311E-6
     * trade_avg_price : 8902.14
     * margin_frozen : 0
     * profit : 4.45098478227E-5
     * trade : [{"id":"49664432704-684505389551849472-1","trade_id":49664432704,"trade_volume":1,"trade_price":8902.14,"trade_fee":-2.246650805311E-6,"trade_turnover":100,"created_at":1583240402556,"fee_asset":"BTC","role":"maker"}]
     */

    private String op;
    private String topic;
    private long ts;
    private String symbol;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("contract_code")
    private String contractCode;
    private BigDecimal volume;
    private BigDecimal price;
    @SerializedName("order_price_type")
    private String orderPriceType;
    private String direction;
    private String offset;
    private int status;
    @SerializedName("lever_rate")
    private int leverRate;
    @SerializedName("order_id")
    private long orderId;
    @SerializedName("order_id_str")
    private String orderIdStr;
    @SerializedName("client_order_id")
    private long clientOrderId;
    @SerializedName("order_source")
    private String orderSource;
    @SerializedName("order_type")
    private int orderType;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("trade_volume")
    private BigDecimal tradeVolume;
    @SerializedName("trade_turnover")
    private BigDecimal tradeTurnover;
    private BigDecimal fee;
    @SerializedName("trade_avg_price")
    private BigDecimal tradeAvgPrice;
    @SerializedName("margin_frozen")
    private BigDecimal marginFrozen;
    private BigDecimal profit;
    private List<TradeBean> trade;


    @Data
    @AllArgsConstructor
    public static class TradeBean {
        /**
         * id : 49664432704-684505389551849472-1
         * trade_id : 49664432704
         * trade_volume : 1
         * trade_price : 8902.14
         * trade_fee : -2.246650805311E-6
         * trade_turnover : 100.0
         * created_at : 1583240402556
         * fee_asset : BTC
         * role : maker
         */

        private String id;
        @SerializedName("trade_id")
        private long tradeId;
        @SerializedName("trade_volume")
        private BigDecimal tradeVolume;
        @SerializedName("trade_price")
        private BigDecimal tradePrice;
        @SerializedName("trade_fee")
        private BigDecimal tradeFee;
        @SerializedName("trade_turnover")
        private BigDecimal tradeTurnover;
        @SerializedName("created_at")
        private long createdAt;
        @SerializedName("fee_asset")
        private String feeAsset;
        private String role;

    }
}
