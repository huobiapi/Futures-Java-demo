package com.huobi.api.enums;

/**
 * 订单类型，1:报单 、 2:撤单 、 3:强平、4:交割
 */
public enum OrderTypeEnum {

    DECLARATION("1"), WITHDRAWAL("2"), FORCE_CLOSE("3"), DELIVERY("4");

    private String value;

    OrderTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
