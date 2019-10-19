package com.store;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Random;

import com.customers.Customers;
import com.optional.AccessoryKit;
import com.optional.ExtensionCord;
import com.optional.Optional;
import com.optional.ProtectiveGear;
import com.tools.*;

public class RentalStore {
	
	Integer dailyBalance = 0;
	Integer totalBalance = 0;
	List<Tools> tools = new ArrayList<Tools>();
	List<Customers> customers = new ArrayList<Customers>();
	List<RentalRecord> rentalRecords = new ArrayList<RentalRecord>();
	List<RentalRecord> completedRentalRecords = new ArrayList<RentalRecord>();
	@SuppressWarnings("deprecation")
	List<RentalStoreRegistry> observers = new ArrayList<RentalStoreRegistry>();
	
	public void attach(RentalStoreRegistry rentalStoreRegistry){
	    observers.add(rentalStoreRegistry);		
	}
	
	public void notifyAllObservers(){
	   for (RentalStoreRegistry observer : observers) {
		   observer.update();
	   }
	} 
	
	public void addTool(Tools tool) {
		tools.add(tool);
	}
	public void showTools() {
		for (Tools i:tools){
			System.out.println(i.getName());
		}
	}
	public void removeTool(String tool) {
		for (Tools i:tools) {
			if (i.getName().contentEquals(tool)) {
				tools.remove(i);
				break;
			}
		}
	}
	public Integer getTotalCustomers() {
		return customers.size();
	}

	public void addCustomer(Customers tool) {
		customers.add(tool);
	}
	public void showCustomers() {
		for (Customers i:customers){
			System.out.println(i.getName());
		}
	}
	public void removeCustomer(String customer) {
		for (Customers i:customers) {
			if (i.getName().contentEquals(customer)) {
				customers.remove(i);
				break;
			}
		}
	}
	
	public void cleanRentalRecords() {
		rentalRecords.removeIf(x -> x.daysToKeep == -1); 
	}
	public void rent(Customers c, Integer toolsToRent, Integer daysToKeep) {
		Optional optional = optionalAccessory();
		RentalRecord rentalRecord = new RentalRecord();
		for (int i=0; i < toolsToRent; i++) {
			rentalRecord.addTool(tools.get(0));
			tools.remove(0);
			rentalRecord.setDaysToKeep(daysToKeep);
			rentalRecord.setDaysToKeepInitially(daysToKeep);
			rentalRecord.addOptional(optional);
			rentalRecord.generateBill();
			rentalRecord.setCustomerName(c.getName());
			rentalRecord.setCustomerType(c.getType());
			rentalRecords.add(rentalRecord);
			dailyBalance = dailyBalance + rentalRecord.getTotalBill();
			totalBalance = totalBalance + rentalRecord.getTotalBill();
			notifyAllObservers();
		}
	}
	
	public Optional optionalAccessory() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		Integer temp = rand.nextInt(3);
		if (temp == 0) {
//			extension cord
			return new ExtensionCord();
		} else if (temp == 1) {
			return new AccessoryKit();
		} else {
			return new ProtectiveGear();
		}
	}
	public Integer possibleDaysToRent(Customers c) {
		Random rand = new Random();
		if (c.getType().equalsIgnoreCase("casual")) {
			return rand.nextInt(1)+1;			
		} else if (c.getType().equalsIgnoreCase("business")) {
			return 7;
		} else if (c.getType().equalsIgnoreCase("regular")) {
			return rand.nextInt(3)+3;			
		} else {
			System.out.println("Unknown Customer type!");
		}
		return null;		
	}
	
	public Integer possibleNumberOfTools(Customers c) {
		
		Random rand = new Random();
		if (c.getType().contentEquals("casual")) {
			if (c.getNumberOfToolsRented() == 2) {
				return 1;
			} else {
				return rand.nextInt(1)+1;
			}
		} else if (c.getType().contentEquals("business")) {
			return 3;
		} else if (c.getType().contentEquals("regular")) {
			if (c.getNumberOfToolsRented() == 0) {
				return rand.nextInt(3)+1;				
			} else if (c.getNumberOfToolsRented() == 1) {
				return rand.nextInt(2)+1;	
			} else if (c.getNumberOfToolsRented() == 2) {
				return 1;
			}
		} else {
			System.out.println("Unknown Customer type!");
		}
		return null;		
	}
	public Integer toolsRemaining() {
		return tools.size();
	}
	public List<Tools> getTools() {
		return tools;
	}
	public void setTools(List<Tools> tools) {
		this.tools = tools;
	}
	public List<Customers> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}
	public List<RentalRecord> getRentalRecords() {
		return rentalRecords;
	}
	public void setRentalRecords(List<RentalRecord> rentalRecords) {
		this.rentalRecords = rentalRecords;
	}
	public void addCompletedRentalRecords(RentalRecord r) {
		completedRentalRecords.add(r);
	}
	public void listCompletedRentalRecords() {
		System.out.println("Total completed rentals: "+Integer.toString(completedRentalRecords.size()));
		for (RentalRecord r:completedRentalRecords) {
			System.out.println("Rental Record "+Integer.valueOf(r.getId()));
			System.out.println("Customer name "+r.getCustomerName());
			System.out.println("Rented number of tools: "+Integer.valueOf(r.getTools().size()));
			for (Tools t:r.getTools()) {
				System.out.println(" ------    "+t.getName());
			}
			System.out.println("Rented for " +Integer.toString(r.getDaysToKeepInitially())+" days ");
			System.out.println("Rented optional: "+r.getOptional().getType());
			System.out.println("Rental bill: "+Integer.valueOf(r.getTotalBill()));
			System.out.println();
		}
	}
	public void listActiveRentalRecords() {
		System.out.println("Total Active rentals: "+Integer.toString(rentalRecords.size()));
		for (RentalRecord r:rentalRecords) {
			System.out.println("Rental Record "+Integer.valueOf(r.getId()));
			System.out.println("Customer name "+r.getCustomerName());
			System.out.println("Rented number of tools: "+Integer.valueOf(r.getTools().size()));
			for (Tools t:r.getTools()) {
				System.out.println(" ------    "+t.getName());
			}
			System.out.println("Rented for " +Integer.toString(r.getDaysToKeepInitially())+" days ");
			System.out.println("Rented optional: "+r.getOptional().getType());
			System.out.println("Rental bill: "+Integer.valueOf(r.getTotalBill()));
			System.out.println();
		}
	}
	public void listStoreTools() {
		System.out.println("Total Tools: "+Integer.toString(tools.size()));
		for (Tools r:tools) {
			System.out.println(r.getName() +" of type "+r.getCategory());
		}		
		System.out.println();
	}

	public Integer getDailyBalance() {
		return dailyBalance;
	}

	public void setDailyBalance(Integer dailyBalance) {
		this.dailyBalance = dailyBalance;
	}

	public Integer getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Integer totalBalance) {
		this.totalBalance = totalBalance;
	}

	public List<RentalRecord> getCompletedRentalRecords() {
		return completedRentalRecords;
	}

	public void setCompletedRentalRecords(List<RentalRecord> completedRentalRecords) {
		this.completedRentalRecords = completedRentalRecords;
	}

}
