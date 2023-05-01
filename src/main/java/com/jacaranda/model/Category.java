package com.jacaranda.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

	@Id
	private String categoryname;
	private String description;
	
//	constructores
	public Category() {
		super();
	}

	public Category(String categoryname, String description) {
		super();
		this.categoryname = categoryname;
		this.description = description;
	}

//	getter and setter
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
