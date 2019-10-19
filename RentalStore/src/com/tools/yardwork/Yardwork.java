package com.tools.yardwork;

import com.tools.Tools;

public class Yardwork  extends Tools{
	public Yardwork(String name) {
		super();
		super.name = name;
		super.category = "Yardwork";
		super.base_price = 5;
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
