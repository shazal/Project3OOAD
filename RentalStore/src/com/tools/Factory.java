package com.tools;

import com.customers.Business;
import com.customers.Casual;
import com.customers.Customers;
import com.customers.Regular;
import com.tools.concrete.Concrete;
import com.tools.painting.Painting;
import com.tools.plumbing.Plumbing;
import com.tools.woodwork.Woodwork;
import com.tools.yardwork.Yardwork;

public class Factory {
	public static int concreteTools = 0;
	public static int paintingTools = 0;
	public static int plumbingTools = 0;
	public static int woodworkTools = 0;
	public static int yardworkTools = 0;
	
	public static int casualCustomer = 0;
	public static int businessCustomer = 0;
	public static int regularCustomer = 0;
	
	public Tools createTools(String name) {
		if (name.contentEquals("Concrete")) {
			concreteTools = concreteTools + 1;
			return new Concrete("concreteTool"+Integer.toString(concreteTools));
		} else if (name.contentEquals("Painting")) {
			paintingTools = paintingTools + 1;
			return new Painting("paintingTool"+Integer.toString(paintingTools));			
		} else if (name.contentEquals("Plumbing")) {
			plumbingTools = plumbingTools + 1;
			return new Plumbing("plumbingTool"+Integer.toString(plumbingTools));			
		} else if (name.contentEquals("Woodwork")) {
			woodworkTools = woodworkTools + 1;
			return new Woodwork("woodworkTool"+Integer.toString(woodworkTools));			
		} else if (name.contentEquals("Yardwork")) {
			yardworkTools = yardworkTools + 1;
			return new Yardwork("yardworkTool"+Integer.toString(yardworkTools));			
		} else 
			return null;
	}
	
	public Customers createCustomers(String name) {
		if (name.contentEquals("Casual")) {
			casualCustomer = casualCustomer + 1;
			return new Casual("casualCustomer"+Integer.toString(casualCustomer));
		} else if (name.contentEquals("Business")) {
			businessCustomer = businessCustomer + 1;
			return new Business("businessCustomer"+Integer.toString(businessCustomer));
		} else if (name.contentEquals("Regular")) {
			regularCustomer = regularCustomer + 1;
			return new Regular("regularCustomer"+Integer.toString(regularCustomer));
		}  else 
			return null;
	}
}
