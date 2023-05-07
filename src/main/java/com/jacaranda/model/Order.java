package com.jacaranda.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orderdb")
public class Order {

	@Id
	private int numbreOrder;
	private String dateOrder;
	private int vat;
	
	@ManyToOne
	@JoinColumn(name="key_user")
	private User userObjOrd;
	
	@OneToMany(mappedBy="orderObjRec")
	private List<Receipt> receipt;
	
//	Constructores
	public Order() {
		super();
	}


	public Order(int numbreOrder, String dateOrder, int vat, User userObjOrd, List<Receipt> receipt) {
		super();
		this.numbreOrder = numbreOrder;
		this.dateOrder = dateOrder;
		this.vat = vat;
		this.userObjOrd = userObjOrd;
		this.receipt = receipt;
	}



	// getter and setter
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


	public User getUserObjOrd() {
		return userObjOrd;
	}


	public void setUserObjOrd(User userObjOrd) {
		this.userObjOrd = userObjOrd;
	}


	public List<Receipt> getReceipt() {
		return receipt;
	}


	public void setReceipt(List<Receipt> receipt) {
		this.receipt = receipt;
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
