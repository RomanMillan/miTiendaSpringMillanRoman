package com.jacaranda.model;

import java.util.Objects;

public class Receipt {

	private int id_element;
	private int id_order;
	
//	constructores
	public Receipt() {
		super();
	}

	public Receipt(int id_element, int id_order) {
		super();
		this.id_element = id_element;
		this.id_order = id_order;
	}

//	getter and setter
	public int getId_element() {
		return id_element;
	}

	public void setId_element(int id_element) {
		this.id_element = id_element;
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

//	hashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(id_element, id_order);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receipt other = (Receipt) obj;
		return id_element == other.id_element && id_order == other.id_order;
	}
	
	
}
