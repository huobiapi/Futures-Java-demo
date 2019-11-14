package com.huobi.api.response.transfer;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuturesTransferResponse {

    /**
     * status : ok
     * data : 48523811
     * err-code : dw-account-transfer-error
     * err-msg : 由于其他服务不可用导致的划转失败
     */

    private String status;
    private Object data;
    @SerializedName("err-code")
    private String errCode;
    @SerializedName("err-msg")
    private String errMsg;

}
