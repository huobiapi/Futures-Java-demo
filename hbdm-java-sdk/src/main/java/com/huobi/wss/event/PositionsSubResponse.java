package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class PositionsSubResponse {
    /**
     * op : notify
     * topic : positions
     * ts : 1571740440561
     * event : init
     * data : [{"symbol":"BTC","contract_code":"BTC191227","contract_type":"quarter","volume":35,"available":25,"frozen":10,"cost_open":8135.630996330059,"cost_hold":7963.82,"profit_unreal":0.0181957332654965,"profit_rate":0.2072142060453463,"profit":0.0089144864299505,"position_margin":0.04212918493267756,"lever_rate":10,"direction":"buy","last_price":8307.78},{"symbol":"BTC","contract_code":"BTC191227","contract_type":"quarter","volume":0,"available":0,"frozen":0,"cost_open":0,"cost_hold":0,"profit_unreal":0,"profit_rate":0,"profit":0,"position_margin":0,"lever_rate":10,"direction":"sell","last_price":8307.78}]
     */

    private String op;
    private String topic;
    private Long ts;
    private String event;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * contract_code : BTC191227
         * contract_type : quarter
         * volume : 35.0
         * available : 25.0
         * frozen : 10.0
         * cost_open : 8135.630996330059
         * cost_hold : 7963.82
         * profit_unreal : 0.0181957332654965
         * profit_rate : 0.2072142060453463
         * profit : 0.0089144864299505
         * position_margin : 0.04212918493267756
         * lever_rate : 10
         * direction : buy
         * last_price : 8307.78
         */

        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("contract_type")
        private String contractType;
        private BigDecimal volume;
        private BigDecimal available;
        private BigDecimal frozen;
        @SerializedName("cost_open")
        private BigDecimal costOpen;
        @SerializedName("cost_hold")
        private BigDecimal costHold;
        @SerializedName("profit_unreal")
        private BigDecimal profitUnreal;
        @SerializedName("profit_rate")
        private BigDecimal profitRate;
        private BigDecimal profit;
        @SerializedName("position_margin")
        private BigDecimal positionMargin;
        @SerializedName("lever_rate")
        private Integer leverRate;
        private String direction;
        @SerializedName("last_price")
        private BigDecimal lastPrice;

    }
}
