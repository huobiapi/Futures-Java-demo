package com.huobi.api.response.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractFinancialRecordResponse {
    /**
     * status : ok
     * data : {"financial_record":[{"id":192838272,"ts":1408076414000,"symbol":"BTC","type":1,"amount":1}],"total_page":15,"current_page":3,"total_size":3}
     * ts : 1490759594752
     */

    private String status;
    private DataBean data;
    private long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * financial_record : [{"id":192838272,"ts":1408076414000,"symbol":"BTC","type":1,"amount":1}]
         * total_page : 15
         * current_page : 3
         * total_size : 3
         */

        @SerializedName("total_page")
        private Integer totalPage;
        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("total_size")
        private Integer totalSize;
        @SerializedName("financial_record")
        private List<FinancialRecordBean> financialRecord;

        @Data
        @AllArgsConstructor
        public static class FinancialRecordBean {
            /**
             * id : 192838272
             * ts : 1408076414000
             * symbol : BTC
             * type : 1
             * amount : 1
             */

            private Long id;
            private Long ts;
            private String symbol;
            private Integer type;
            private BigDecimal amount;

        }
    }
}
