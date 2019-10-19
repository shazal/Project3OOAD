package com.store;

import java.util.ArrayList;
import java.util.List;

import com.optional.Optional;
import com.tools.Tools;

public class RentalRecord {
	static Integer uid = 0;
	List<Tools> tools = new ArrayList<Tools> ();
	Optional optional;
	String customerName;
	String customerType;
	Integer daysToKeep = 0;
	Integer daysToKeepInitially = 0;
	Integer totalBill = 0;
	Integer id = 0;
	public RentalRecord() {
		super();
		id = uid++;
	}	
	public List<Tools> getTools() {
		return tools;
	}
	public void setTools(List<Tools> tools) {
		this.tools = tools;
	}
	public Optional getOptional() {
		return optional;
	}
	public void setOptional(Optional optional) {
		this.optional = optional;
	}
	public Integer getDaysToKeep() {
		return daysToKeep;
	}
	public void setDaysToKeep(Integer daysToKeep) {
		this.daysToKeep = daysToKeep;
	}
	
	public void addTool(Tools tool) {
		tools.add(tool);
	}
	public void removeTool(String tool) {
		for (Tools i:tools) {
			if (i.getName().contentEquals(tool)) {
				tools.remove(i);
				break;
			}
		}
	}
	public Integer totalTools() {
		return tools.size();
	}
	public void addOptional(Optional tool) {
		optional = tool;
	}
	
	public void generateBill() {
		// TODO Auto-generated method stub
		totalBill = 0;
		for (Tools i:tools) {
			totalBill = totalBill + (i.getBase_price()*daysToKeep);
		}
		if (optional != null) {
			totalBill = totalBill + optional.getBase_price();			
		}
		this.setTotalBill(totalBill);
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(Integer totalBill) {
		this.totalBill = totalBill;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDaysToKeepInitially(Integer daysToKeep2) {
		// TODO Auto-generated method stub
		this.daysToKeepInitially = daysToKeep2;
	}
	public Integer getDaysToKeepInitially() {
		// TODO Auto-generated method stub
		return daysToKeepInitially;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
}
