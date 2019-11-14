package com.huobi.api.response.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ContractBatchorderResponse {

    /**
     * status : ok
     * data : {"errors":[{"index":0,"err_code":200417,"err_msg":"invalid symbol"},{"index":3,"err_code":200415,"err_msg":"invalid symbol"}],"success":[{"index":1,"order_id":161256,"client_order_id":1344567},{"index":2,"order_id":161257,"client_order_id":1344569}]}
     * ts : 1490759594752
     */

    private String status;
    private DataBean data;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        private List<ErrorsBean> errors;
        private List<SuccessBean> success;

        @Data
        @AllArgsConstructor
        public static class ErrorsBean {
            /**
             * index : 0
             * err_code : 200417
             * err_msg : invalid symbol
             */

            private Integer index;
            @SerializedName("err_code")
            private Integer errCode;
            @SerializedName("err_msg")
            private String errMsg;

        }

        @Data
        @AllArgsConstructor
        public static class SuccessBean {
            /**
             * index : 1
             * order_id : 161256
             * client_order_id : 1344567
             */

            private Integer index;
            @SerializedName("order_id")
            private Long orderId;
            @SerializedName("order_id_str")
            private String orderIdStr;
            @SerializedName("client_order_id")
            private Long clientOrderId;

        }
    }
}
