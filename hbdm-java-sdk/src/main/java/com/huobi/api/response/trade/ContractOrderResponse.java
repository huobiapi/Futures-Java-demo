package com.huobi.api.response.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回参数
 * 参数名称	是否必须	类型	描述	取值范围
 * status	true	string	请求处理结果	"ok" , "error"
 * order_id	true	Long	订单ID
 * client_order_id	true	Long	用户下单时填写的客户端订单ID，没填则不返回
 * ts	true	Long	响应生成时间点，单位：毫秒
 */
@Data
@AllArgsConstructor
public class ContractOrderResponse {

    /**
     * status : ok
     * data : {"order_id":88}
     * ts : 158797866555
     */

    private String status;
    private DataBean data;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * order_id : 88
         */

        @SerializedName("order_id")
        private Long orderId;
        @SerializedName("order_id_str")
        private String orderIdStr;
        @SerializedName("client_order_id")
        private Long clientOrderId;

    }
}
