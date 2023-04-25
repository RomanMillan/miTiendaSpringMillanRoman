package com.jacaranda.model;

import java.util.Objects;

public class Order {

	private int numbreOrder;
	private String dateOrder;
	private int vat;
	
//	Constructores
	public Order() {
		super();
	}

	public Order(int numbreOrder, String dateOrder, int vat) {
		super();
		this.numbreOrder = numbreOrder;
		this.dateOrder = dateOrder;
		this.vat = vat;
	}

//	getter and setter
	public int getNumbreOrder() {
		return numbreOrder;
	}

	public void setNumbreOrder(int numbreOrder) {
		this.numbreOrder = numbreOrder;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

// hashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(numbreOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return numbreOrder == other.numbreOrder;
	}
	
	
}
