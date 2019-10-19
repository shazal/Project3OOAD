package com.customers;

import java.util.ArrayList;
import java.util.List;

import com.optional.Optional;
import com.tools.Tools;

public class Regular extends Customers {
	public Regular(String name) {
		super();
		super.name = name;
		super.type = "regular";
		toolsRented = 0;
	}
	Integer toolsRented = 0;
	public Integer getNumberOfToolsRented() {
		return toolsRented;
	}
	public void addNumberOfTools(Integer num) {
		toolsRented = toolsRented + num;
	}
	public void removeNumberOfTools (Integer num) {
		toolsRented = toolsRented - num;
	}
}
