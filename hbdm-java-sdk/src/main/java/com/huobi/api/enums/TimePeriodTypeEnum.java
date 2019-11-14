package com.huobi.api.enums;

//1小时:"60min"，4小时:"4hour"，12小时:"12hour"，1天:"1day"
public enum TimePeriodTypeEnum {


    ONE_HOUR("60min"),FOUR_DAY("4hour"),TWELVE_MON("12hour"),ONE_DAY("1day");


    private String value;

    TimePeriodTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
