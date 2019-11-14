package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractPriceLimitResponse {

    /**
     * status : ok
     * data : [{"symbol":"BTC","contract_code":"BTC191011","contract_type":"this_week","high_limit":8750.09,"low_limit":8079.82}]
     * ts : 1570775227012
     */

    private String status;
    private Long ts;
    private List<DataBean> data;


    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * contract_code : BTC191011
         * contract_type : this_week
         * high_limit : 8750.09
         * low_limit : 8079.82
         */

        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("contract_type")
        private String contractType;
        @SerializedName("high_limit")
        private BigDecimal highLimit;
        @SerializedName("low_limit")
        private BigDecimal lowLimit;

    }
}
