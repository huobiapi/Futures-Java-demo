package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class LiquidationOrdersSubResponse {


    /**
     * op : notify
     * topic : liquidationOrders.btc
     * ts : 1489474082831
     * symbol : BTC
     * contract_code : BTC180914
     * direction : buy
     * offset : close
     * volume : 111
     * price : 1111
     * created_at : 1408076414000
     */

    private String op;
    private String topic;
    private long ts;
    private String symbol;
    @SerializedName("contract_code")
    private String contractCode;
    private String direction;
    private String offset;
    private BigDecimal volume;
    private BigDecimal price;
    @SerializedName("created_at")
    private long createdAt;

}
