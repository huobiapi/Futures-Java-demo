package com.huobi.common.exception;

public class ApiException extends RuntimeException {

	final String errCode;

	public ApiException(String errCode, String errMsg) {
		super(errMsg);
		this.errCode = errCode;
	}

	public ApiException(Exception e) {
		super(e);
		this.errCode = e.getClass().getName();
	}

	public String getErrCode() {
		return this.errCode;
	}

}
