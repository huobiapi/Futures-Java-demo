package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractOpenInterestResponse {


    /**
     * status : ok
     * data : [{"volume":86299,"amount":1025.1259743561113,"symbol":"BTC","contract_type":"this_week","contract_code":"BTC191011"}]
     * ts : 1570779150321
     */

    private String status;
    private Long ts;
    private List<DataBean> data;


    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * volume : 86299
         * amount : 1025.1259743561113
         * symbol : BTC
         * contract_type : this_week
         * contract_code : BTC191011
         */

        private BigDecimal volume;
        private BigDecimal amount;
        private String symbol;
        @SerializedName("contract_type")
        private String contractType;
        @SerializedName("contract_code")
        private String contractCode;

    }
}
