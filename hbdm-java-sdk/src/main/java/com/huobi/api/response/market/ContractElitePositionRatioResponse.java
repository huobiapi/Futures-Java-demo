package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractElitePositionRatioResponse {

    /**
     * status : ok
     * data : {"list":[{"buy_ratio":0.442,"sell_ratio":0.558,"ts":1571126400000},{"buy_ratio":0.442,"sell_ratio":0.558,"ts":1571130000000},{"buy_ratio":0.442,"sell_ratio":0.558,"ts":1571133600000},{"buy_ratio":0.439,"sell_ratio":0.561,"ts":1571137200000},{"buy_ratio":0.436,"sell_ratio":0.564,"ts":1571140800000},{"buy_ratio":0.436,"sell_ratio":0.564,"ts":1571144400000},{"buy_ratio":0.433,"sell_ratio":0.567,"ts":1571148000000},{"buy_ratio":0.432,"sell_ratio":0.568,"ts":1571151600000},{"buy_ratio":0.424,"sell_ratio":0.576,"ts":1571155200000},{"buy_ratio":0.42,"sell_ratio":0.58,"ts":1571158800000},{"buy_ratio":0.42,"sell_ratio":0.58,"ts":1571162400000},{"buy_ratio":0.42,"sell_ratio":0.58,"ts":1571166000000},{"buy_ratio":0.42,"sell_ratio":0.58,"ts":1571169600000},{"buy_ratio":0.421,"sell_ratio":0.579,"ts":1571173200000},{"buy_ratio":0.421,"sell_ratio":0.579,"ts":1571176800000},{"buy_ratio":0.415,"sell_ratio":0.585,"ts":1571180400000},{"buy_ratio":0.413,"sell_ratio":0.587,"ts":1571184000000},{"buy_ratio":0.41,"sell_ratio":0.59,"ts":1571187600000},{"buy_ratio":0.408,"sell_ratio":0.592,"ts":1571191200000},{"buy_ratio":0.408,"sell_ratio":0.592,"ts":1571194800000}],"symbol":"BTC"}
     * ts : 1571194869285
     */

    private String status;
    private DataBean data;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * list : [{"buy_ratio":0.442,"sell_ratio":0.558,"ts":1571126400000},{"buy_ratio":0.442,"sell_ratio":0.558,"ts":1571130000000},{"buy_ratio":0.442,"sell_ratio":0.558,"ts":1571133600000},{"buy_ratio":0.439,"sell_ratio":0.561,"ts":1571137200000},{"buy_ratio":0.436,"sell_ratio":0.564,"ts":1571140800000},{"buy_ratio":0.436,"sell_ratio":0.564,"ts":1571144400000},{"buy_ratio":0.433,"sell_ratio":0.567,"ts":1571148000000},{"buy_ratio":0.432,"sell_ratio":0.568,"ts":1571151600000},{"buy_ratio":0.424,"sell_ratio":0.576,"ts":1571155200000},{"buy_ratio":0.42,"sell_ratio":0.58,"ts":1571158800000},{"buy_ratio":0.42,"sell_ratio":0.58,"ts":1571162400000},{"buy_ratio":0.42,"sell_ratio":0.58,"ts":1571166000000},{"buy_ratio":0.42,"sell_ratio":0.58,"ts":1571169600000},{"buy_ratio":0.421,"sell_ratio":0.579,"ts":1571173200000},{"buy_ratio":0.421,"sell_ratio":0.579,"ts":1571176800000},{"buy_ratio":0.415,"sell_ratio":0.585,"ts":1571180400000},{"buy_ratio":0.413,"sell_ratio":0.587,"ts":1571184000000},{"buy_ratio":0.41,"sell_ratio":0.59,"ts":1571187600000},{"buy_ratio":0.408,"sell_ratio":0.592,"ts":1571191200000},{"buy_ratio":0.408,"sell_ratio":0.592,"ts":1571194800000}]
         * symbol : BTC
         */

        private String symbol;
        private List<ListBean> list;

        @Data
        @AllArgsConstructor
        public static class ListBean {
            /**
             * buy_ratio : 0.442
             * sell_ratio : 0.558
             * ts : 1571126400000
             */

            @SerializedName("buy_ratio")
            private BigDecimal buyRatio;
            @SerializedName("sell_ratio")
            private BigDecimal sellRatio;
            private Long ts;

        }
    }
}
