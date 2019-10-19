package com.tools.plumbing;

import com.tools.Tools;

public class Plumbing  extends Tools{
	public Plumbing(String name) {
		super();
		super.name = name;
		super.category = "Plumbing";
		super.base_price = 3;
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
