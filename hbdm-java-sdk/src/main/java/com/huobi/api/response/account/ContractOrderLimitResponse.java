package com.huobi.api.response.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractOrderLimitResponse {
    /**
     * status : ok
     * data : {"order_price_type":"limit","list":[{"symbol":"BTC","types":[{"contract_type":"this_week","open_limit":3000,"close_limit":3000},{"contract_type":"next_week","open_limit":3000,"close_limit":3000},{"contract_type":"quarter","open_limit":3000,"close_limit":3000}]}]}
     * ts : 158797866555
     */

    private String status;
    private DataBean data;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * order_price_type : limit
         * list : [{"symbol":"BTC","types":[{"contract_type":"this_week","open_limit":3000,"close_limit":3000},{"contract_type":"next_week","open_limit":3000,"close_limit":3000},{"contract_type":"quarter","open_limit":3000,"close_limit":3000}]}]
         */

        @SerializedName("order_price_type")
        private String orderPriceType;
        private List<ListBean> list;

        @Data
        @AllArgsConstructor
        public static class ListBean {
            /**
             * symbol : BTC
             * types : [{"contract_type":"this_week","open_limit":3000,"close_limit":3000},{"contract_type":"next_week","open_limit":3000,"close_limit":3000},{"contract_type":"quarter","open_limit":3000,"close_limit":3000}]
             */

            private String symbol;
            private List<TypesBean> types;

            @Data
            @AllArgsConstructor
            public static class TypesBean {
                /**
                 * contract_type : this_week
                 * open_limit : 3000
                 * close_limit : 3000
                 */

                @SerializedName("contract_type")
                private String contractType;
                @SerializedName("open_limit")
                private BigDecimal openLimit;
                @SerializedName("close_limit")
                private BigDecimal closeLimit;

            }
        }
    }
}
