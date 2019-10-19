package com.tools.painting;

import com.tools.Tools;

public class Painting  extends Tools{
	public Painting(String name) {
		super();
		super.name = name;
		super.category = "Painting";
		super.base_price = 2;
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
