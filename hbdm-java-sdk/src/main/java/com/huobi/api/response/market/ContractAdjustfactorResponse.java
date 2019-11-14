package com.huobi.api.response.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ContractAdjustfactorResponse {


    /**
     * status : ok
     * data : [{"symbol":"BTC","list":[{"lever_rate":5,"ladders":[{"ladder":0,"min_size":0,"max_size":999,"adjust_factor":0.05},{"ladder":1,"min_size":1000,"max_size":9999,"adjust_factor":0.06},{"ladder":2,"min_size":10000,"max_size":null,"adjust_factor":0.08}]},{"lever_rate":20,"ladders":[{"ladder":0,"min_size":0,"max_size":999,"adjust_factor":0.2},{"ladder":1,"min_size":1000,"max_size":9999,"adjust_factor":0.24},{"ladder":2,"min_size":10000,"max_size":null,"adjust_factor":0.28}]},{"lever_rate":10,"ladders":[{"ladder":0,"min_size":0,"max_size":999,"adjust_factor":0.1},{"ladder":1,"min_size":1000,"max_size":9999,"adjust_factor":0.12},{"ladder":2,"min_size":10000,"max_size":null,"adjust_factor":0.14}]},{"lever_rate":1,"ladders":[{"ladder":0,"min_size":0,"max_size":999,"adjust_factor":0.01},{"ladder":1,"min_size":1000,"max_size":9999,"adjust_factor":0.015},{"ladder":2,"min_size":10000,"max_size":null,"adjust_factor":0.02}]}]},{"symbol":"BSV","list":[{"lever_rate":1,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.015},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.015},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.02}]},{"lever_rate":10,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.15},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.2},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.25}]},{"lever_rate":5,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.075},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.1},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.12}]},{"lever_rate":20,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.35},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.4},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.45}]}]},{"symbol":"BCH","list":[{"lever_rate":10,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.12},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.16},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.2}]},{"lever_rate":20,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.28},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.32},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.38}]},{"lever_rate":1,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.015},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.015},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.02}]},{"lever_rate":5,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.06},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.08},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.1}]}]},{"symbol":"XRP","list":[{"lever_rate":20,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.35},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.4},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.45}]},{"lever_rate":10,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.15},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.2},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.25}]},{"lever_rate":1,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.015},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.015},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.02}]},{"lever_rate":5,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.075},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.1},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.12}]}]},{"symbol":"ETH","list":[{"lever_rate":20,"ladders":[{"ladder":0,"min_size":0,"max_size":9999,"adjust_factor":0.28},{"ladder":1,"min_size":10000,"max_size":49999,"adjust_factor":0.32},{"ladder":2,"min_size":50000,"max_size":null,"adjust_factor":0.38}]},{"lever_rate":10,"ladders":[{"ladder":0,"min_size":0,"max_size":9999,"adjust_factor":0.12},{"ladder":1,"min_size":10000,"max_size":49999,"adjust_factor":0.16},{"ladder":2,"min_size":50000,"max_size":null,"adjust_factor":0.2}]},{"lever_rate":5,"ladders":[{"ladder":0,"min_size":0,"max_size":9999,"adjust_factor":0.06},{"ladder":1,"min_size":10000,"max_size":49999,"adjust_factor":0.08},{"ladder":2,"min_size":50000,"max_size":null,"adjust_factor":0.1}]},{"lever_rate":1,"ladders":[{"ladder":0,"min_size":0,"max_size":9999,"adjust_factor":0.015},{"ladder":1,"min_size":10000,"max_size":49999,"adjust_factor":0.015},{"ladder":2,"min_size":50000,"max_size":null,"adjust_factor":0.02}]}]},{"symbol":"EOS","list":[{"lever_rate":20,"ladders":[{"ladder":0,"min_size":0,"max_size":9999,"adjust_factor":0.28},{"ladder":1,"min_size":10000,"max_size":49999,"adjust_factor":0.32},{"ladder":2,"min_size":50000,"max_size":null,"adjust_factor":0.38}]},{"lever_rate":5,"ladders":[{"ladder":0,"min_size":0,"max_size":9999,"adjust_factor":0.06},{"ladder":1,"min_size":10000,"max_size":49999,"adjust_factor":0.08},{"ladder":2,"min_size":50000,"max_size":null,"adjust_factor":0.1}]},{"lever_rate":10,"ladders":[{"ladder":0,"min_size":0,"max_size":9999,"adjust_factor":0.12},{"ladder":1,"min_size":10000,"max_size":49999,"adjust_factor":0.16},{"ladder":2,"min_size":50000,"max_size":null,"adjust_factor":0.2}]},{"lever_rate":1,"ladders":[{"ladder":0,"min_size":0,"max_size":9999,"adjust_factor":0.015},{"ladder":1,"min_size":10000,"max_size":49999,"adjust_factor":0.015},{"ladder":2,"min_size":50000,"max_size":null,"adjust_factor":0.02}]}]},{"symbol":"LTC","list":[{"lever_rate":20,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.28},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.32},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.38}]},{"lever_rate":10,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.12},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.16},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.2}]},{"lever_rate":5,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.06},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.08},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.1}]},{"lever_rate":1,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.015},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.015},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.02}]}]},{"symbol":"TRX","list":[{"lever_rate":10,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.15},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.2},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.25}]},{"lever_rate":5,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.075},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.1},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.12}]},{"lever_rate":20,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.35},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.4},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.45}]},{"lever_rate":1,"ladders":[{"ladder":0,"min_size":0,"max_size":4999,"adjust_factor":0.015},{"ladder":1,"min_size":5000,"max_size":19999,"adjust_factor":0.015},{"ladder":2,"min_size":20000,"max_size":null,"adjust_factor":0.02}]}]}]
     * ts : 1570779915091
     */

    private String status;
    private Long ts;
    private List<DataBean> data;


    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * symbol : BTC
         * list : [{"lever_rate":5,"ladders":[{"ladder":0,"min_size":0,"max_size":999,"adjust_factor":0.05},{"ladder":1,"min_size":1000,"max_size":9999,"adjust_factor":0.06},{"ladder":2,"min_size":10000,"max_size":null,"adjust_factor":0.08}]},{"lever_rate":20,"ladders":[{"ladder":0,"min_size":0,"max_size":999,"adjust_factor":0.2},{"ladder":1,"min_size":1000,"max_size":9999,"adjust_factor":0.24},{"ladder":2,"min_size":10000,"max_size":null,"adjust_factor":0.28}]},{"lever_rate":10,"ladders":[{"ladder":0,"min_size":0,"max_size":999,"adjust_factor":0.1},{"ladder":1,"min_size":1000,"max_size":9999,"adjust_factor":0.12},{"ladder":2,"min_size":10000,"max_size":null,"adjust_factor":0.14}]},{"lever_rate":1,"ladders":[{"ladder":0,"min_size":0,"max_size":999,"adjust_factor":0.01},{"ladder":1,"min_size":1000,"max_size":9999,"adjust_factor":0.015},{"ladder":2,"min_size":10000,"max_size":null,"adjust_factor":0.02}]}]
         */

        private String symbol;
        private List<ListBean> list;



        @Data
        @AllArgsConstructor
        public static class ListBean {
            /**
             * lever_rate : 5
             * ladders : [{"ladder":0,"min_size":0,"max_size":999,"adjust_factor":0.05},{"ladder":1,"min_size":1000,"max_size":9999,"adjust_factor":0.06},{"ladder":2,"min_size":10000,"max_size":null,"adjust_factor":0.08}]
             */

            private Integer lever_rate;
            private List<LaddersBean> ladders;


            @Data
            @AllArgsConstructor
            public static class LaddersBean {
                /**
                 * ladder : 0
                 * min_size : 0
                 * max_size : 999
                 * adjust_factor : 0.05
                 */

                private Integer ladder;
                @SerializedName("min_size")
                private Integer minSize;
                @SerializedName("max_size")
                private Integer maxSize;
                @SerializedName("adjust_factor")
                private BigDecimal adjustFactor;

            }
        }
    }
}
