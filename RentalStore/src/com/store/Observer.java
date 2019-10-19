package com.store;

public abstract class Observer {
	protected RentalStore subject;
	public abstract void update();
}
