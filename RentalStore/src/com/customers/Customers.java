package com.customers;

import com.store.RentalRecord;

public abstract class Customers {
	String name;
	String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getNumberOfToolsRented() {
		return 0;
	}
	public void addNumberOfTools(Integer num) {
		
	}
	public void removeNumberOfTools (Integer num) {
		
	}
}
