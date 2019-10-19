package com.tools.woodwork;

import com.tools.Tools;

public class Woodwork  extends Tools{
	public Woodwork(String name) {
		super();
		super.name = name;
		super.category = "Woodwork";
		super.base_price = 4;
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
