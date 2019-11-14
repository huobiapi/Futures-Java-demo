package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractEliteAccountRatioResponse {

    /**
     * status : ok
     * data : {"list":[{"buy_ratio":0.58,"sell_ratio":0.39,"locked_ratio":0.03,"ts":1571126400000},{"buy_ratio":0.58,"sell_ratio":0.39,"locked_ratio":0.03,"ts":1571130000000},{"buy_ratio":0.59,"sell_ratio":0.39,"locked_ratio":0.02,"ts":1571133600000},{"buy_ratio":0.58,"sell_ratio":0.38,"locked_ratio":0.04,"ts":1571137200000},{"buy_ratio":0.62,"sell_ratio":0.37,"locked_ratio":0.01,"ts":1571140800000},{"buy_ratio":0.62,"sell_ratio":0.37,"locked_ratio":0.01,"ts":1571144400000},{"buy_ratio":0.61,"sell_ratio":0.38,"locked_ratio":0.01,"ts":1571148000000},{"buy_ratio":0.63,"sell_ratio":0.37,"locked_ratio":0,"ts":1571151600000},{"buy_ratio":0.61,"sell_ratio":0.39,"locked_ratio":0,"ts":1571155200000},{"buy_ratio":0.65,"sell_ratio":0.35,"locked_ratio":0,"ts":1571158800000},{"buy_ratio":0.64,"sell_ratio":0.36,"locked_ratio":0,"ts":1571162400000},{"buy_ratio":0.64,"sell_ratio":0.36,"locked_ratio":0,"ts":1571166000000},{"buy_ratio":0.64,"sell_ratio":0.36,"locked_ratio":0,"ts":1571169600000},{"buy_ratio":0.65,"sell_ratio":0.35,"locked_ratio":0,"ts":1571173200000},{"buy_ratio":0.65,"sell_ratio":0.35,"locked_ratio":0,"ts":1571176800000},{"buy_ratio":0.64,"sell_ratio":0.36,"locked_ratio":0,"ts":1571180400000},{"buy_ratio":0.63,"sell_ratio":0.37,"locked_ratio":0,"ts":1571184000000},{"buy_ratio":0.62,"sell_ratio":0.38,"locked_ratio":0,"ts":1571187600000},{"buy_ratio":0.61,"sell_ratio":0.39,"locked_ratio":0,"ts":1571191200000},{"buy_ratio":0.62,"sell_ratio":0.38,"locked_ratio":0,"ts":1571194800000}],"symbol":"BTC"}
     * ts : 1571194993834
     */

    private String status;
    private DataBean data;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * list : [{"buy_ratio":0.58,"sell_ratio":0.39,"locked_ratio":0.03,"ts":1571126400000},{"buy_ratio":0.58,"sell_ratio":0.39,"locked_ratio":0.03,"ts":1571130000000},{"buy_ratio":0.59,"sell_ratio":0.39,"locked_ratio":0.02,"ts":1571133600000},{"buy_ratio":0.58,"sell_ratio":0.38,"locked_ratio":0.04,"ts":1571137200000},{"buy_ratio":0.62,"sell_ratio":0.37,"locked_ratio":0.01,"ts":1571140800000},{"buy_ratio":0.62,"sell_ratio":0.37,"locked_ratio":0.01,"ts":1571144400000},{"buy_ratio":0.61,"sell_ratio":0.38,"locked_ratio":0.01,"ts":1571148000000},{"buy_ratio":0.63,"sell_ratio":0.37,"locked_ratio":0,"ts":1571151600000},{"buy_ratio":0.61,"sell_ratio":0.39,"locked_ratio":0,"ts":1571155200000},{"buy_ratio":0.65,"sell_ratio":0.35,"locked_ratio":0,"ts":1571158800000},{"buy_ratio":0.64,"sell_ratio":0.36,"locked_ratio":0,"ts":1571162400000},{"buy_ratio":0.64,"sell_ratio":0.36,"locked_ratio":0,"ts":1571166000000},{"buy_ratio":0.64,"sell_ratio":0.36,"locked_ratio":0,"ts":1571169600000},{"buy_ratio":0.65,"sell_ratio":0.35,"locked_ratio":0,"ts":1571173200000},{"buy_ratio":0.65,"sell_ratio":0.35,"locked_ratio":0,"ts":1571176800000},{"buy_ratio":0.64,"sell_ratio":0.36,"locked_ratio":0,"ts":1571180400000},{"buy_ratio":0.63,"sell_ratio":0.37,"locked_ratio":0,"ts":1571184000000},{"buy_ratio":0.62,"sell_ratio":0.38,"locked_ratio":0,"ts":1571187600000},{"buy_ratio":0.61,"sell_ratio":0.39,"locked_ratio":0,"ts":1571191200000},{"buy_ratio":0.62,"sell_ratio":0.38,"locked_ratio":0,"ts":1571194800000}]
         * symbol : BTC
         */

        private String symbol;
        private List<ListBean> list;

        @Data
        @AllArgsConstructor
        public static class ListBean {
            /**
             * buy_ratio : 0.58
             * sell_ratio : 0.39
             * locked_ratio : 0.03
             * ts : 1571126400000
             */

            @SerializedName("buy_ratio")
            private BigDecimal buyRatio;
            @SerializedName("sell_ratio")
            private BigDecimal sellRatio;
            @SerializedName("locked_ratio")
            private BigDecimal lockedRatio;
            private Long ts;

        }
    }
}
