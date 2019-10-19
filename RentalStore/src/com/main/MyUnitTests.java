package com.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.customers.Business;
import com.customers.Casual;
import com.customers.Customers;
import com.optional.ExtensionCord;
import com.optional.Optional;
import com.store.RentalRecord;
import com.store.RentalStore;
import com.tools.Factory;
import com.tools.Tools;
import com.tools.concrete.Concrete;

public class MyUnitTests {
	
	@Test
	public void testTotalCustomers() {
		RentalStore store = new RentalStore();
		store.addCustomer(new Casual("customer1"));
		assertEquals(Integer.valueOf(1), store.getTotalCustomers());		
	}
	
	@Test
	public void testDaysToRent() {
		RentalRecord rentalRecord = new RentalRecord();
		Factory factory = new Factory();
		Tools concreteTool1 = factory.createTools("Concrete");
		rentalRecord.setCustomerName("customer1");
		rentalRecord.addTool(concreteTool1);
		rentalRecord.setDaysToKeep(5);
		rentalRecord.generateBill();
		assertEquals(Integer.valueOf(5), rentalRecord.getDaysToKeep());
	}

	@Test
	public void testAbnormalOptional() {
		RentalStore store = new RentalStore();
		Optional optional = new ExtensionCord();		
		assertNotEquals(null, store.optionalAccessory().getClass());
	}
	
	@Test
	public void testNormalPossibleNumberOfTools() {
		RentalStore store = new RentalStore();
		Customers c = new Casual("customer1");
		assertNotEquals(null, store.possibleNumberOfTools(c));
	}

	@Test
	public void testDaysToRentBusiness() {
		RentalStore store = new RentalStore();
		Customers c = new Business("customer1");		
		assertEquals(Integer.valueOf(7), store.possibleDaysToRent(c));
	}
	
	@Test 
	public void testAddToolToStore() {
		RentalStore store = new RentalStore();
		assertEquals(Integer.valueOf(0), store.toolsRemaining());
		store.addTool(new Concrete("concreteTool1"));
		assertNotEquals(Integer.valueOf(0), store.toolsRemaining());
	}
	
	
	@Test
	public void testFactoryCreateTools() {
		Tools concreteTool1 = new Concrete("Concrete");
		Factory factory = new Factory();
		Tools concreteTool2 = (Concrete) factory.createTools("Concrete");
		assertEquals(concreteTool1.getBase_price(), concreteTool2.getBase_price());
	}
	
	@Test
	public void testFactoryCreateCustomers() {
		Customers casualCustomer1 = new Casual("casualCustomer1");
		casualCustomer1.addNumberOfTools(5);
		Factory factory = new Factory();
		Customers casualCustomer2 = factory.createCustomers("Casual");
		casualCustomer2.addNumberOfTools(5);
		assertEquals(casualCustomer1.getNumberOfToolsRented(), casualCustomer2.getNumberOfToolsRented());
	}
	
	@Test
	public void testRent() {
		RentalStore store = new RentalStore();
		Factory factory = new Factory();
		for (int i = 0 ; i < 5; i++) {
			store.addTool(factory.createTools("Concrete"));
		}
		Customers businessCustomer1 = factory.createCustomers("Business");
		store.rent(businessCustomer1, 3, 7);
		assertEquals(Integer.valueOf(2), store.toolsRemaining());
	}
	
	@Test
	public void testRecordRentalBill() {
		RentalRecord rentalRecord = new RentalRecord();
		Factory factory = new Factory();
		Tools concreteTool1 = factory.createTools("Concrete");
		rentalRecord.setCustomerName("customer1");
		rentalRecord.addTool(concreteTool1);
		rentalRecord.setDaysToKeep(5);
		rentalRecord.generateBill();
		assertNotEquals(concreteTool1.getBase_price(),rentalRecord.getTotalBill());
		rentalRecord.addOptional(new ExtensionCord());
		rentalRecord.generateBill();
		assertEquals(Integer.valueOf(7), rentalRecord.getTotalBill());
	}























}
