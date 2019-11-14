package com.huobi.api.response.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractOrderDetailResponse {
    /**
     * status : ok
     * data : {"symbol":"BTC","contract_type":"this_week","contract_code":"BTC180914","volume":111,"price":1111,"order_price_type":"limit","direction":"buy","offset":"open","status":1,"lever_rate":10,"trade_avg_price":10,"margin_frozen":10,"profit":10,"order_source":"web","created_at":1408076414000,"instrument_price":10000,"final_interest":0,"adjust_value":0,"trades":[{"trade_id":112,"trade_volume":1,"trade_price":123.4555,"trade_fee":0.234,"trade_turnover":34.123,"role":"maker","created_at":1490759594752}],"total_page":15,"total_size":3,"current_page":3}
     * ts : 1490759594752
     */

    private String status;
    private DataBean data;
    private Long ts;

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
         * status : 1
         * lever_rate : 10
         * trade_avg_price : 10
         * margin_frozen : 10
         * profit : 10
         * order_source : web
         * created_at : 1408076414000
         * instrument_price : 10000
         * final_interest : 0
         * adjust_value : 0
         * trades : [{"trade_id":112,"trade_volume":1,"trade_price":123.4555,"trade_fee":0.234,"trade_turnover":34.123,"role":"maker","created_at":1490759594752}]
         * total_page : 15
         * total_size : 3
         * current_page : 3
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
        private Integer status;
        @SerializedName("lever_rate")
        private Integer leverRate;
        @SerializedName("trade_avg_price")
        private BigDecimal tradeAvgPrice;
        @SerializedName("margin_frozen")
        private BigDecimal marginFrozen;
        private BigDecimal profit;
        @SerializedName("order_source")
        private String orderSource;
        @SerializedName("created_at")
        private Long createdAt;
        @SerializedName("instrument_price")
        private BigDecimal instrumentPrice;
        @SerializedName("final_interest")
        private BigDecimal finalInterest;
        @SerializedName("adjust_value")
        private BigDecimal adjustValue;
        @SerializedName("total_page")
        private Integer totalPage;
        @SerializedName("total_size")
        private Integer totalSize;
        @SerializedName("current_page")
        private Integer currentPage;
        private List<TradesBean> trades;

        @Data
        @AllArgsConstructor
        public static class TradesBean {
            /**
             * trade_id : 112
             * trade_volume : 1
             * trade_price : 123.4555
             * trade_fee : 0.234
             * trade_turnover : 34.123
             * role : maker
             * created_at : 1490759594752
             */

            private String id;
            @SerializedName("trade_id")
            private Long tradeId;
            @SerializedName("trade_volume")
            private BigDecimal tradeVolume;
            @SerializedName("trade_price")
            private BigDecimal tradePrice;
            @SerializedName("trade_fee")
            private BigDecimal tradeFee;
            @SerializedName("trade_turnover")
            private BigDecimal tradeTurnover;
            private String role;
            @SerializedName("created_at")
            private Long createdAt;

        }
    }
}
