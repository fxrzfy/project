package com.core.pageModel;

public class SuggestBean {
	private String value;
	private Object data;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public SuggestBean(String value, Object data) {
		super();
		this.value = value;
		this.data = data;
	}
	
}
