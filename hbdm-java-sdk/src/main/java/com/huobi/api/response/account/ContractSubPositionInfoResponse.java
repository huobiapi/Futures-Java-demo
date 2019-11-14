package com.huobi.api.response.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractSubPositionInfoResponse {

    /**
     * status : ok
     * ts : 158797866555
     * data : [{"symbol":"BTC","contract_code":"BTC180914","contract_type":"this_week","volume":1,"available":0,"frozen":0.3,"cost_open":422.78,"cost_hold":422.78,"profit_unreal":7.096E-5,"profit_rate":0.07,"profit":0.97,"position_margin":3.4,"lever_rate":10,"direction":"buy"}]
     */

    private String status;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * contract_code : BTC180914
         * contract_type : this_week
         * volume : 1
         * available : 0
         * frozen : 0.3
         * cost_open : 422.78
         * cost_hold : 422.78
         * profit_unreal : 7.096E-5
         * profit_rate : 0.07
         * profit : 0.97
         * position_margin : 3.4
         * lever_rate : 10
         * direction : buy
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
