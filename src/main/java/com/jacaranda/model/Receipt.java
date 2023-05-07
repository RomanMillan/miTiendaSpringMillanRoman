package com.jacaranda.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Receipt {
	
	@Id
	@ManyToOne
	@JoinColumn(name="key_order")
	private Order orderObjRec;
	
	@Id
	@ManyToOne
	@JoinColumn(name="key_element")
	private Element elementObjRec;
	
//	constructores
	public Receipt() {
		super();
	}

	public Receipt(Order orderObjRec, Element elementObjRec) {
		super();
		this.orderObjRec = orderObjRec;
		this.elementObjRec = elementObjRec;
	}

//	getter and setter
	public Order getOrderObjRec() {
		return orderObjRec;
	}
	
	public void setOrderObjRec(Order orderObjRec) {
		this.orderObjRec = orderObjRec;
	}
	
	public Element getElementObjRec() {
		return elementObjRec;
	}
	
	public void setElementObjRec(Element elementObjRec) {
		this.elementObjRec = elementObjRec;
	}
	
//	hashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(elementObjRec, orderObjRec);
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
		return Objects.equals(elementObjRec, other.elementObjRec) && Objects.equals(orderObjRec, other.orderObjRec);
	}
	
		

	
	
	
}
