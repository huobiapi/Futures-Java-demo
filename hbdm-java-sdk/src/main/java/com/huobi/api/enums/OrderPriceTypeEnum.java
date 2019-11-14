package com.huobi.api.enums;

/**
 * 订单报价类型 "limit":限价, "opponent":对手价, "post_only":只做maker单,post only下单只受用户持仓数量限制,
 * optimal_5：最优5档、optimal_10：最优10档、optimal_20：最优20档
 */
public enum OrderPriceTypeEnum {

    LIMIT("limit"), OPPONENT("opponent"), POST_ONLY("post_only"),
    OPTIMAL_5("optimal_5"), OPTIMAL_10("optimal_10"), OPTIMAL_20("optimal_20");

    private String value;

    OrderPriceTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
