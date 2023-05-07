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
@Table(name="elementdb")
public class Element {

	@Id
	private String elementname;
	private String description;
	private int stock;
	private int price;
	
	@ManyToOne
	@JoinColumn(name="key_category")
	private Category categoryObj;
	
	@OneToMany(mappedBy="elementObjRec")
	private List<Receipt> receipt;
	
//	Constructores
	public Element() {
		super();
	}


	public Element(String elementname, String description, int stock, int price, Category categoryObj,
			List<Receipt> receipt) {
		super();
		this.elementname = elementname;
		this.description = description;
		this.stock = stock;
		this.price = price;
		this.categoryObj = categoryObj;
		this.receipt = receipt;
	}
	
	// getter and setter
	public String getElementname() {
		return elementname;
	}
	
	
	public void setElementname(String elementname) {
		this.elementname = elementname;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getStock() {
		return stock;
	}
	
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public int getPrice() {
		return price;
	}
	
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public Category getCategoryObj() {
		return categoryObj;
	}
	
	
	public void setCategoryObj(Category categoryObj) {
		this.categoryObj = categoryObj;
	}
	
	
	public List<Receipt> getReceipt() {
		return receipt;
	}
	
	
	public void setReceipt(List<Receipt> receipt) {
		this.receipt = receipt;
	}

//hashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(elementname);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return Objects.equals(elementname, other.elementname);
	}


	
}
