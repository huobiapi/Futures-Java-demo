package com.huobi.api.enums;

public enum DirectionEnum {

    //"buy":买 "sell":卖
    BUY("buy"), SELL("sell");

    private String value;

    DirectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
