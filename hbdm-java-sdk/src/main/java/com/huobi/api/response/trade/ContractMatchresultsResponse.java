package com.huobi.api.response.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
public class ContractMatchresultsResponse {
    /**
     * data : {"current_page":1,"total_page":1,"total_size":2,"trades":[{"contract_code":"EOS190419","contract_type":"this_week","create_date":1555553626736,"direction":"sell","match_id":3635853382,"offset":"close","offset_profitloss":0.15646398812252696,"order_id":1118,"symbol":"EOS","trade_fee":-0.002897500905469032,"trade_price":5.522,"trade_turnover":80,"role":"maker","trade_volume":8}]}
     * status : ok
     * ts : 1555654870867
     */

    private DataBean data;
    private String status;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * current_page : 1
         * total_page : 1
         * total_size : 2
         * trades : [{"contract_code":"EOS190419","contract_type":"this_week","create_date":1555553626736,"direction":"sell","match_id":3635853382,"offset":"close","offset_profitloss":0.15646398812252696,"order_id":1118,"symbol":"EOS","trade_fee":-0.002897500905469032,"trade_price":5.522,"trade_turnover":80,"role":"maker","trade_volume":8}]
         */

        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("total_page")
        private Integer totalPage;
        @SerializedName("total_size")
        private Integer totalSize;
        private List<TradesBean> trades;
        @Data
        @AllArgsConstructor
        public static class TradesBean {
            /**
             * contract_code : EOS190419
             * contract_type : this_week
             * create_date : 1555553626736
             * direction : sell
             * match_id : 3635853382
             * offset : close
             * offset_profitloss : 0.15646398812252696
             * order_id : 1118
             * symbol : EOS
             * trade_fee : -0.002897500905469032
             * trade_price : 5.522
             * trade_turnover : 80
             * role : maker
             * trade_volume : 8
             */

            private String id;
            @SerializedName("contract_code")
            private String contractCode;
            @SerializedName("contract_type")
            private String contractType;
            @SerializedName("create_date")
            private Long createDate;
            private String direction;
            @SerializedName("match_id")
            private Long matchId;
            private String offset;
            @SerializedName("offset_profitloss")
            private BigDecimal offsetProfitloss;
            @SerializedName("order_id")
            private Long orderId;
            @SerializedName("order_id_str")
            private Long orderIdStr;
            private String symbol;
            @SerializedName("trade_fee")
            private double tradeFee;
            @SerializedName("trade_price")
            private BigDecimal tradePrice;
            @SerializedName("trade_turnover")
            private BigDecimal tradeTurnover;
            private String role;
            @SerializedName("trade_volume")
            private BigDecimal tradeVolume;
            @SerializedName("order_source")
            private String orderSource;

        }
    }
}
