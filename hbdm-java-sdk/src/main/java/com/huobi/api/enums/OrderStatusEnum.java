package com.huobi.api.enums;

/**
 * 0:全部,3:未成交, 4: 部分成交,5: 部分成交已撤单,6: 全部成交,7:已撤单
 */
public enum OrderStatusEnum {

    ALL("0"), UN_DEAL("3"), PART_DEAL("4"),
    PART_DEAL_CANCEL("5"), ALL_DEAL("6"), CANCEL("7");

    private String value;

    OrderStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
