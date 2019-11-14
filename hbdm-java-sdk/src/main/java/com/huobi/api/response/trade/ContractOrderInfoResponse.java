package com.huobi.api.response.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
public class ContractOrderInfoResponse {
    /**
     * status : ok
     * data : [{"symbol":"BTC","contract_type":"this_week","contract_code":"BTC180914","volume":111,"price":1111,"order_price_type":"limit","direction":"buy","offset":"open","lever_rate":10,"order_id":106837,"client_order_id":10683,"order_source":"web","order_type":"1","created_at":1408076414000,"trade_volume":1,"trade_turnover":1200,"fee":0,"trade_avg_price":10,"margin_frozen":10,"profit ":10,"status":0},{"symbol":"ETH","contract_type":"this_week","contract_code":"ETH180921","volume":111,"price":1111,"order_price_type":"limit","direction":"buy","offset":"open","lever_rate":10,"order_id":106837,"client_order_id":10683,"order_source":"web","order_type":"1","created_at":1408076414000,"trade_volume":1,"trade_turnover":1200,"fee":0,"trade_avg_price":10,"margin_frozen":10,"profit ":10,"status":0}]
     * ts : 1490759594752
     */

    private String status;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * contract_type : this_week
         * contract_code : BTC180914
         * volume : 111
         * price : 1111
         * order_price_type : limit
         * direction : buy
         * offset : open
         * lever_rate : 10
         * order_id : 106837
         * client_order_id : 10683
         * order_source : web
         * order_type : 1
         * created_at : 1408076414000
         * trade_volume : 1
         * trade_turnover : 1200
         * fee : 0
         * trade_avg_price : 10
         * margin_frozen : 10
         * profit  : 10
         * status : 0
         */

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
        @SerializedName("lever_rate")
        private Integer leverRate;
        @SerializedName("order_id")
        private Long orderId;
        @SerializedName("order_id_str")
        private String orderIdStr;
        @SerializedName("client_order_id")
        private Long clientOrderId;
        @SerializedName("order_source")
        private String orderSource;
        @SerializedName("order_type")
        private String orderType;
        @SerializedName("created_at")
        private Long createdAt;
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
        private Integer status;

    }
}
