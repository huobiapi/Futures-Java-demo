package com.huobi.api.response.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractPositionLimitResponse {
    /**
     * status : ok
     * data : [{"symbol":"BTC","list":[{"contract_type":"all","buy_limit":5000,"sell_limit":5000},{"contract_type":"this_week","buy_limit":3000,"sell_limit":3000},{"contract_type":"next_week","buy_limit":3000,"sell_limit":3000},{"contract_type":"quarter","buy_limit":3000,"sell_limit":3000}]}]
     * ts : 158797866555
     */

    private String status;
    private long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * list : [{"contract_type":"all","buy_limit":5000,"sell_limit":5000},{"contract_type":"this_week","buy_limit":3000,"sell_limit":3000},{"contract_type":"next_week","buy_limit":3000,"sell_limit":3000},{"contract_type":"quarter","buy_limit":3000,"sell_limit":3000}]
         */

        private String symbol;
        private List<ListBean> list;

        @Data
        @AllArgsConstructor
        public static class ListBean {
            /**
             * contract_type : all
             * buy_limit : 5000
             * sell_limit : 5000
             */

            private String contract_type;
            @SerializedName("buy_limit")
            private BigDecimal buyLimit;
            @SerializedName("sell_limit")
            private BigDecimal sellLimit;

        }
    }
}
