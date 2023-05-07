package com.jacaranda.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	private String categoryname;
	private String description;
	
	@OneToMany(mappedBy="categoryObj")
	private List<Element> element;
	
//	constructores
	public Category() {
		super();
	}

	

	public Category(String categoryname, String description, List<Element> element) {
		super();
		this.categoryname = categoryname;
		this.description = description;
		this.element = element;
	}
	
	
	
// getter and setter
	
	public String getCategoryname() {
		return categoryname;
	}
	
	
	
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public List<Element> getElement() {
		return element;
	}
	
	
	
	public void setElement(List<Element> element) {
		this.element = element;
	}



	//	hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(categoryname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(categoryname, other.categoryname);
	}
	
	
}
