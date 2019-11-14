package com.huobi.wss.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class MarketTradeDetailReqResponse {

    /**
     * data : [{"amount":"86","ts":1573107201935,"id":254779168880000,"price":"9467.67","direction":"sell"},{"amount":"120","ts":1573107201935,"id":254779168920000,"price":"9467.67","direction":"sell"},{"amount":"46","ts":1573107201935,"id":254779169100000,"price":"9467.67","direction":"sell"},{"amount":"86","ts":1573107201935,"id":254779169130000,"price":"9467.67","direction":"sell"},{"amount":"232","ts":1573107202096,"id":254779172750000,"price":"9467.67","direction":"sell"},{"amount":"60","ts":1573107202096,"id":254779172750001,"price":"9467.67","direction":"sell"},{"amount":"20","ts":1573107202209,"id":254779176730000,"price":"9467.56","direction":"sell"},{"amount":"10","ts":1573107202633,"id":254779192450000,"price":"9467.09","direction":"sell"},{"amount":"10","ts":1573107202796,"id":254779199200000,"price":"9466.12","direction":"sell"},{"amount":"54","ts":1573107206426,"id":254779294010000,"price":"9466.13","direction":"buy"},{"amount":"28","ts":1573107208537,"id":254779338380000,"price":"9466.13","direction":"buy"},{"amount":"32","ts":1573107210565,"id":254779380350000,"price":"9466.12","direction":"sell"},{"amount":"6","ts":1573107210565,"id":254779380350001,"price":"9466.12","direction":"sell"},{"amount":"34","ts":1573107210565,"id":254779380350002,"price":"9466.12","direction":"sell"},{"amount":"30","ts":1573107210565,"id":254779380350003,"price":"9466.12","direction":"sell"},{"amount":"30","ts":1573107210565,"id":254779380350004,"price":"9466.12","direction":"sell"},{"amount":"12","ts":1573107210565,"id":254779380350005,"price":"9466.12","direction":"sell"},{"amount":"4","ts":1573107210565,"id":254779380350006,"price":"9466.12","direction":"sell"},{"amount":"78","ts":1573107211207,"id":254779393700000,"price":"9466.13","direction":"buy"},{"amount":"54","ts":1573107211207,"id":254779393700001,"price":"9466.13","direction":"buy"},{"amount":"54","ts":1573107211207,"id":254779393700002,"price":"9466.13","direction":"buy"},{"amount":"2","ts":1573107211207,"id":254779393700003,"price":"9466.13","direction":"buy"},{"amount":"58","ts":1573107211207,"id":254779393700004,"price":"9466.13","direction":"buy"},{"amount":"22","ts":1573107211207,"id":254779393700005,"price":"9466.13","direction":"buy"},{"amount":"50","ts":1573107211207,"id":254779393700006,"price":"9466.13","direction":"buy"},{"amount":"4","ts":1573107213560,"id":254779436450000,"price":"9466.13","direction":"buy"},{"amount":"14","ts":1573107213560,"id":254779436450001,"price":"9466.13","direction":"buy"},{"amount":"20","ts":1573107215199,"id":254779465130000,"price":"9466.13","direction":"buy"},{"amount":"54","ts":1573107215199,"id":254779465130001,"price":"9466.13","direction":"buy"},{"amount":"54","ts":1573107215199,"id":254779465130002,"price":"9466.13","direction":"buy"},{"amount":"4","ts":1573107215199,"id":254779465130003,"price":"9466.13","direction":"buy"},{"amount":"8","ts":1573107215199,"id":254779465130004,"price":"9466.13","direction":"buy"},{"amount":"6","ts":1573107215199,"id":254779465130005,"price":"9466.13","direction":"buy"},{"amount":"10","ts":1573107215199,"id":254779465130006,"price":"9466.13","direction":"buy"},{"amount":"2","ts":1573107215199,"id":254779465130007,"price":"9466.13","direction":"buy"},{"amount":"46","ts":1573107215199,"id":254779465130008,"price":"9466.13","direction":"buy"},{"amount":"18","ts":1573107215199,"id":254779465130009,"price":"9466.13","direction":"buy"},{"amount":"6","ts":1573107215199,"id":254779465130010,"price":"9466.13","direction":"buy"},{"amount":"124","ts":1573107215199,"id":254779465130011,"price":"9466.13","direction":"buy"},{"amount":"82","ts":1573107215199,"id":254779465130012,"price":"9466.13","direction":"buy"},{"amount":"20","ts":1573107220030,"id":254779574100000,"price":"9466.13","direction":"buy"},{"amount":"18","ts":1573107220125,"id":254779576390000,"price":"9466.13","direction":"buy"},{"amount":"36","ts":1573107220561,"id":254779585770000,"price":"9466.13","direction":"buy"},{"amount":"60","ts":1573107223297,"id":254779646680000,"price":"9466.13","direction":"buy"},{"amount":"20","ts":1573107223297,"id":254779646680001,"price":"9466.13","direction":"buy"},{"amount":"16","ts":1573107227883,"id":254779741420000,"price":"9466.12","direction":"sell"},{"amount":"8","ts":1573107227883,"id":254779741420001,"price":"9466.12","direction":"sell"},{"amount":"22","ts":1573107227883,"id":254779741420002,"price":"9466.12","direction":"sell"},{"amount":"14","ts":1573107227883,"id":254779741420003,"price":"9466.12","direction":"sell"},{"amount":"2","ts":1573107229118,"id":254779767430000,"price":"9466.12","direction":"sell"}]
     * id : 1573107232
     * rep : market.BTC_CQ.trade.detail
     * status : ok
     */

    private Long id;
    private String rep;
    private String status;
    private List<DataBean> data;


    @Data
    @AllArgsConstructor
    public static class DataBean {
        /**
         * amount : 86
         * ts : 1573107201935
         * id : 254779168880000
         * price : 9467.67
         * direction : sell
         */

        private BigDecimal amount;
        private Long ts;
        private Long id;
        private BigDecimal price;
        private String direction;

    }
}
