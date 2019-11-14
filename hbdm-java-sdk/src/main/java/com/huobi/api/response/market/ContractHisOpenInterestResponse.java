package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractHisOpenInterestResponse {
    /**
     * status : ok
     * data : {"symbol":"BTC","contract_type":"this_week","tick":[{"volume":1,"amount_type":1,"ts":1529387842137}]}
     * ts : 158797866555
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
         * tick : [{"volume":1,"amount_type":1,"ts":1529387842137}]
         */

        private String symbol;
        private String contract_type;
        private List<TickBean> tick;

        @Data
        @AllArgsConstructor
        public static class TickBean {
            /**
             * volume : 1
             * amount_type : 1
             * ts : 1529387842137
             */

            private BigDecimal volume;
            @SerializedName("amount_type")
            private Integer amountType;
            private Long ts;

        }
    }
}
