package com.tools;

public abstract class Tools {
	protected String category = "";
	protected String name = "";
	protected Integer base_price;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBase_price() {
		return 0;
	}
	public void setBase_price(Integer base_price) {
		this.base_price = base_price;
	} 

	
}
