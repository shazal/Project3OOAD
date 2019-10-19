package com.optional;

public abstract class Optional {
	Integer base_price = 0;
	String type = "";

	public Integer getBase_price() {
		return base_price;
	}

	public void setBase_price(Integer base_price) {
		this.base_price = base_price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
