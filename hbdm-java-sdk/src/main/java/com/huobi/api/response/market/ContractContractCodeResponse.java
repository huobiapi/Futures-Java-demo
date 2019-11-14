package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractContractCodeResponse {


    /**
     * status : ok
     * data : [{"symbol":"BTC","contract_code":"BTC191011","contract_type":"this_week","contract_size":100,"price_tick":0.01,"delivery_date":"20191011","create_date":"20190927","contract_status":1},{"symbol":"BTC","contract_code":"BTC191018","contract_type":"next_week","contract_size":100,"price_tick":0.01,"delivery_date":"20191018","create_date":"20191004","contract_status":1},{"symbol":"BTC","contract_code":"BTC191227","contract_type":"quarter","contract_size":100,"price_tick":0.01,"delivery_date":"20191227","create_date":"20190913","contract_status":1},{"symbol":"ETH","contract_code":"ETH191011","contract_type":"this_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191011","create_date":"20190927","contract_status":1},{"symbol":"ETH","contract_code":"ETH191018","contract_type":"next_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191018","create_date":"20191004","contract_status":1},{"symbol":"ETH","contract_code":"ETH191227","contract_type":"quarter","contract_size":10,"price_tick":0.001,"delivery_date":"20191227","create_date":"20190913","contract_status":1},{"symbol":"EOS","contract_code":"EOS191011","contract_type":"this_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191011","create_date":"20190927","contract_status":1},{"symbol":"EOS","contract_code":"EOS191018","contract_type":"next_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191018","create_date":"20191004","contract_status":1},{"symbol":"EOS","contract_code":"EOS191227","contract_type":"quarter","contract_size":10,"price_tick":0.001,"delivery_date":"20191227","create_date":"20190913","contract_status":1},{"symbol":"LTC","contract_code":"LTC191011","contract_type":"this_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191011","create_date":"20190927","contract_status":1},{"symbol":"LTC","contract_code":"LTC191018","contract_type":"next_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191018","create_date":"20191004","contract_status":1},{"symbol":"LTC","contract_code":"LTC191227","contract_type":"quarter","contract_size":10,"price_tick":0.001,"delivery_date":"20191227","create_date":"20190913","contract_status":1},{"symbol":"BCH","contract_code":"BCH191011","contract_type":"this_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191011","create_date":"20190927","contract_status":1},{"symbol":"BCH","contract_code":"BCH191018","contract_type":"next_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191018","create_date":"20191004","contract_status":1},{"symbol":"BCH","contract_code":"BCH191227","contract_type":"quarter","contract_size":10,"price_tick":0.001,"delivery_date":"20191227","create_date":"20190913","contract_status":1},{"symbol":"XRP","contract_code":"XRP191011","contract_type":"this_week","contract_size":10,"price_tick":1.0E-4,"delivery_date":"20191011","create_date":"20190927","contract_status":1},{"symbol":"XRP","contract_code":"XRP191018","contract_type":"next_week","contract_size":10,"price_tick":1.0E-4,"delivery_date":"20191018","create_date":"20191004","contract_status":1},{"symbol":"XRP","contract_code":"XRP191227","contract_type":"quarter","contract_size":10,"price_tick":1.0E-4,"delivery_date":"20191227","create_date":"20190913","contract_status":1},{"symbol":"TRX","contract_code":"TRX191011","contract_type":"this_week","contract_size":10,"price_tick":1.0E-5,"delivery_date":"20191011","create_date":"20190927","contract_status":1},{"symbol":"TRX","contract_code":"TRX191018","contract_type":"next_week","contract_size":10,"price_tick":1.0E-5,"delivery_date":"20191018","create_date":"20191004","contract_status":1},{"symbol":"TRX","contract_code":"TRX191227","contract_type":"quarter","contract_size":10,"price_tick":1.0E-5,"delivery_date":"20191227","create_date":"20190913","contract_status":1},{"symbol":"BSV","contract_code":"BSV191011","contract_type":"this_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191011","create_date":"20190927","contract_status":1},{"symbol":"BSV","contract_code":"BSV191018","contract_type":"next_week","contract_size":10,"price_tick":0.001,"delivery_date":"20191018","create_date":"20191004","contract_status":1},{"symbol":"BSV","contract_code":"BSV191227","contract_type":"quarter","contract_size":10,"price_tick":0.001,"delivery_date":"20191227","create_date":"20190913","contract_status":1}]
     * ts : 1570776917938
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
         * contract_size : 100
         * price_tick : 0.01
         * delivery_date : 20191011
         * create_date : 20190927
         * contract_status : 1
         */

        private String symbol;
        @SerializedName("contract_code")
        private String contractCode;
        @SerializedName("contract_type")
        private String contractType;
        @SerializedName("contract_size")
        private Integer contractSize;
        @SerializedName("price_tick")
        private BigDecimal priceTick;
        @SerializedName("delivery_date")
        private String deliveryDate;
        @SerializedName("create_date")
        private String createDate;
        @SerializedName("contract_status")
        private Integer contractStatus;

    }
}
