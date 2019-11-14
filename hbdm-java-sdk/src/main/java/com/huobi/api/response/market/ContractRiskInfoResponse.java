package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractRiskInfoResponse {

    /**
     * status : ok
     * data : [{"symbol":"BTC","insurance_fund":457.06542829785315,"estimated_clawback":0},{"symbol":"BSV","insurance_fund":135.96936585278442,"estimated_clawback":0},{"symbol":"BCH","insurance_fund":285.9666682903252,"estimated_clawback":0},{"symbol":"XRP","insurance_fund":4972848.682465245,"estimated_clawback":0},{"symbol":"ETH","insurance_fund":22892.41049355472,"estimated_clawback":0},{"symbol":"EOS","insurance_fund":287544.8584444354,"estimated_clawback":0},{"symbol":"LTC","insurance_fund":37127.219091037085,"estimated_clawback":0},{"symbol":"TRX","insurance_fund":1.5535403357534453E7,"estimated_clawback":0}]
     * ts : 1570779722680
     */

    private String status;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * insurance_fund : 457.06542829785315
         * estimated_clawback : 0
         */

        private String symbol;
        @SerializedName("insurance_fund")
        private BigDecimal insuranceFund;
        @SerializedName("estimated_clawback")
        private Integer estimatedClawback;

    }
}
