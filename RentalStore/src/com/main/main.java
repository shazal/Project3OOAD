package com.main;

import com.customers.Customers;
import com.store.RentalRecord;
import com.store.RentalStore;
import com.store.RentalStoreRegistry;
import com.tools.Factory;
import com.tools.Tools;

public class main {
	public static void main(String[] args) {
		RentalStore store = new RentalStore();
//		RentalStoreRegistry registry = new RentalStoreRegistry(store);
		Factory factory = new Factory();
		
		for (int i = 0 ; i < 5; i++) {
			store.addTool(factory.createTools("Concrete"));
			store.addTool(factory.createTools("Painting"));
			store.addTool(factory.createTools("Plumbing"));
			store.addTool(factory.createTools("Woodwork"));
			store.addTool(factory.createTools("Yardwork"));
		}
		store.removeTool("yardworkTool5");
		for (int i = 0; i < 4; i++) {
			store.addCustomer(factory.createCustomers("Casual"));
			store.addCustomer(factory.createCustomers("Business"));
			store.addCustomer(factory.createCustomers("Regular"));
		}
		
		for (int day = 0; day<69; day++) {
			if ((day%2) == 0) {
				System.out.println("Day "+Integer.toString(day/2+1)+"\nlisting completed rentals\n");					
			} else {
				System.out.println("Night "+Integer.toString(day/2+1)+"\nlisting completed rentals\n");									
			}
			store.listCompletedRentalRecords();
			for (Customers c: store.getCustomers()) {
				if (c.getNumberOfToolsRented() != 3) {
					Integer toolsToRent = store.possibleNumberOfTools(c);
					Integer daysToKeep = store.possibleDaysToRent(c);
					if (store.toolsRemaining() > toolsToRent) {
//						System.out.println(c.getName()+ " arrived at the store!");
						c.addNumberOfTools(toolsToRent);
						store.rent(c,toolsToRent, daysToKeep);					
					}
				}
			}
			for (RentalRecord r: store.getRentalRecords()) {
				if (r.getDaysToKeep() == 0) {
					store.addCompletedRentalRecords(r);
					for (Customers c:store.getCustomers()) {
						if (c.getName().contentEquals(r.getCustomerName())) {
							c.removeNumberOfTools(r.totalTools());
//							System.out.println(c.getName()+" returned " + Integer.valueOf(r.totalTools())+" tool ");
						}
					}
					for (Tools i:r.getTools()) {
						store.addTool(i);
//						System.out.println(r.getCustomerName()+ " returned "+ i.getName());
					}
					store.notifyAllObservers();
				}
				r.setDaysToKeep(r.getDaysToKeep()-1);
			}
			store.cleanRentalRecords();
			store.listActiveRentalRecords();
			store.listStoreTools();
			System.out.println("Store made "+Integer.toString(store.getDailyBalance())+"$ today!");
			store.setDailyBalance(0);
			System.out.println("");
			
		}
		Integer totalCasual = 0;
		Integer totalBusiness = 0;
		Integer totalRegular = 0;
		for (RentalRecord r:store.getCompletedRentalRecords()) {
			if (r.getCustomerType().contentEquals("casual")) {
				totalCasual += 1;
			} else if (r.getCustomerType().contentEquals("business")) {
				totalBusiness += 1;
			} else if (r.getCustomerType().contentEquals("regular")) {
				totalRegular += 1;
			}
		}
		System.out.println("Store completed "+Integer.toString(totalBusiness+totalCasual+totalRegular)+" rentals!");
		System.out.println("Regular had "+Integer.toString(totalRegular)+" rentals!");
		System.out.println("Casual had "+Integer.toString(totalCasual)+" rentals!");
		System.out.println("Business had "+Integer.toString(totalBusiness)+" rentals!");
		System.out.println("Store made "+Integer.toString(store.getTotalBalance())+"$ in total");
	}	
}
