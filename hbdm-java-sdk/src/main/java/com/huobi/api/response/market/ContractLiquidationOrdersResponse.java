package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractLiquidationOrdersResponse {

    /**
     * status : ok
     * data : {"orders":[{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":138,"price":8110.63,"created_at":1571156173812},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":6,"price":8099.81,"created_at":1571156168239},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":14,"price":8140.3,"created_at":1571156157269},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":2,"price":8110.13,"created_at":1571156155300},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":3,"price":8105.92,"created_at":1571156154754},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":58,"price":8098.42,"created_at":1571156153979},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":13,"price":8124.98,"created_at":1571156153311},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":25,"price":8095.39,"created_at":1571156149036},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":100,"price":8107.6,"created_at":1571156147508},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":82,"price":8103.73,"created_at":1571156147327},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":90,"price":8100.68,"created_at":1571156147288},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":2,"price":8130.92,"created_at":1571156146269},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":130,"price":8115.14,"created_at":1571156146186},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":23,"price":8116.24,"created_at":1571156146072},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":3,"price":8103.47,"created_at":1571156145243},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":2,"price":8117.16,"created_at":1571156145170},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":24,"price":8121.14,"created_at":1571156140246},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":2,"price":8116.99,"created_at":1571156138395},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":65,"price":8135.54,"created_at":1571156132493},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":5,"price":8147.03,"created_at":1571156132007}],"total_page":27,"current_page":1,"total_size":538}
     * ts : 1571194664573
     */

    private String status;
    private DataBean data;
    private Long ts;

    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * orders : [{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":138,"price":8110.63,"created_at":1571156173812},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":6,"price":8099.81,"created_at":1571156168239},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":14,"price":8140.3,"created_at":1571156157269},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":2,"price":8110.13,"created_at":1571156155300},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":3,"price":8105.92,"created_at":1571156154754},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":58,"price":8098.42,"created_at":1571156153979},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":13,"price":8124.98,"created_at":1571156153311},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":25,"price":8095.39,"created_at":1571156149036},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":100,"price":8107.6,"created_at":1571156147508},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":82,"price":8103.73,"created_at":1571156147327},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":90,"price":8100.68,"created_at":1571156147288},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":2,"price":8130.92,"created_at":1571156146269},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":130,"price":8115.14,"created_at":1571156146186},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":23,"price":8116.24,"created_at":1571156146072},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":3,"price":8103.47,"created_at":1571156145243},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":2,"price":8117.16,"created_at":1571156145170},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":24,"price":8121.14,"created_at":1571156140246},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":2,"price":8116.99,"created_at":1571156138395},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":65,"price":8135.54,"created_at":1571156132493},{"contract_code":"BTC191227","symbol":"BTC","direction":"sell","offset":"close","volume":5,"price":8147.03,"created_at":1571156132007}]
         * total_page : 27
         * current_page : 1
         * total_size : 538
         */

        @SerializedName("total_page")
        private Integer totalPage;
        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("total_size")
        private Integer totalSize;
        private List<OrdersBean> orders;

        @Data
        @AllArgsConstructor
        public static class OrdersBean {
            /**
             * contract_code : BTC191227
             * symbol : BTC
             * direction : sell
             * offset : close
             * volume : 138
             * price : 8110.63
             * created_at : 1571156173812
             */

            @SerializedName("contract_code")
            private String contractCode;
            private String symbol;
            private String direction;
            private String offset;
            private Integer volume;
            private BigDecimal price;
            @SerializedName("created_at")
            private Long createdAt;
        }
    }
}
