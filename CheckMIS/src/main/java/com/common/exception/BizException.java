package com.common.exception;

public class BizException extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer code;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public BizException(Integer code,String message) {
		super(message);
		this.code = code;
	}
	
}
