package com.huobi.api.response.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ContractFeeResponse {
    /**
     * status : ok
     * data : [{"symbol":"BTC","open_maker_fee":"-0.00025","open_taker_fee":"0.00075","close_maker_fee":"-0.00025","close_taker_fee":"0.00075","delivery_fee":"0.0005"}]
     * ts : 158797866555
     */

    private String status;
    private Long ts;
    private List<DataBean> data;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * open_maker_fee : -0.00025
         * open_taker_fee : 0.00075
         * close_maker_fee : -0.00025
         * close_taker_fee : 0.00075
         * delivery_fee : 0.0005
         */

        private String symbol;
        @SerializedName("open_maker_fee")
        private String openMakerFee;
        @SerializedName("open_taker_fee")
        private String openTakerFee;
        @SerializedName("close_maker_fee")
        private String closeMakerFee;
        @SerializedName("close_taker_fee")
        private String closeTakerFee;
        @SerializedName("delivery_fee")
        private String deliveryFee;

    }
}
