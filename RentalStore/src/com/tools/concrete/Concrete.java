package com.tools.concrete;

import com.tools.Tools;

public class Concrete extends Tools {
	public Concrete(String name) {
		super();
		super.name = name;
		super.category = "Concrete";
		super.base_price = 1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBase_price() {
		return base_price;
	}
	public void setBase_price(Integer base_price) {
		this.base_price = base_price;
	} 
	
}
