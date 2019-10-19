package com.store;

public class RentalStoreRegistry extends Observer{

	public RentalStoreRegistry(RentalStore subject){
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Store has "+Integer.toString(subject.toolsRemaining())+" tools left!\n");
	}

}
