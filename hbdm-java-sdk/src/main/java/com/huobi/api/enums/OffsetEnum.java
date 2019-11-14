package com.huobi.api.enums;

public enum OffsetEnum {
    //"open":开 "close":平
    OPEN("open"), CLOSE("close");

    private String value;

    OffsetEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
