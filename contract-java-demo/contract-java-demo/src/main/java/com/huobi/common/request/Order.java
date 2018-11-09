package com.huobi.common.request;

public class Order {

	public String symbol;
	public String contractType;
	public String contractCode;
	public String clientOrderId;
	public String price;
	public String volume;
	public String direction;
	public String offset;
	public String leverRate;
	public String orderPriceType;

	public Order(String symbol, String contractType, String contractCode, String clientOrderId, String price,
			String volume, String direction, String offset, String leverRate, String orderPriceType) {
		super();
		this.symbol = symbol;
		this.contractType = contractType;
		this.contractCode = contractCode;
		this.clientOrderId = clientOrderId;
		this.price = price;
		this.volume = volume;
		this.direction = direction;
		this.offset = offset;
		this.leverRate = leverRate;
		this.orderPriceType = orderPriceType;
	}

	public Order() {
		super();
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getClientOrderId() {
		return clientOrderId;
	}

	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getLeverRate() {
		return leverRate;
	}

	public void setLeverRate(String leverRate) {
		this.leverRate = leverRate;
	}

	public String getOrderPriceType() {
		return orderPriceType;
	}

	public void setOrderPriceType(String orderPriceType) {
		this.orderPriceType = orderPriceType;
	}

}
