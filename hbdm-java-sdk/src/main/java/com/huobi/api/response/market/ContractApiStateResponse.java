package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ContractApiStateResponse {

    /**
     * status : ok
     * data : [{"symbol":"BTC","open":1,"close":1,"cancel":1,"transfer_in":1,"transfer_out":1},{"symbol":"BSV","open":1,"close":1,"cancel":1,"transfer_in":1,"transfer_out":1},{"symbol":"BCH","open":1,"close":1,"cancel":1,"transfer_in":1,"transfer_out":1},{"symbol":"XRP","open":1,"close":1,"cancel":1,"transfer_in":1,"transfer_out":1},{"symbol":"ETH","open":1,"close":1,"cancel":1,"transfer_in":1,"transfer_out":1},{"symbol":"EOS","open":1,"close":1,"cancel":1,"transfer_in":1,"transfer_out":1},{"symbol":"LTC","open":1,"close":1,"cancel":1,"transfer_in":1,"transfer_out":1},{"symbol":"TRX","open":1,"close":1,"cancel":1,"transfer_in":1,"transfer_out":1}]
     * ts : 1571363224839
     */

    private String status;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * open : 1
         * close : 1
         * cancel : 1
         * transfer_in : 1
         * transfer_out : 1
         */

        private String symbol;
        private Integer open;
        private Integer close;
        private Integer cancel;
        @SerializedName("transfer_in")
        private Integer transferIn;
        @SerializedName("transfer_out")
        private Integer transferOut;

    }
}
