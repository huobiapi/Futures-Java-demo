package com.huobi.api.enums;

/**
 * 交易类型
 * 0:全部,1:买入开多,2: 卖出开空,3: 买入平空,4: 卖出平多,5: 卖出强平,6: 买入强平,7:交割平多,8: 交割平空
 */
public enum TradeTypeEnum {
    ALL("0"), OPEN_BUY("1"), OPEN_SELL("2"), CLOSE_BUY("3"), CLOSE_SELL("4"),
    FORCE_CLOSE_SELL("5"), FORCE_CLOSE_BUY("6"), DELIVERY_CLOSE_BUY("7"), DELIVERY_CLOSE_SELL("8");

    private String value;

    TradeTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
