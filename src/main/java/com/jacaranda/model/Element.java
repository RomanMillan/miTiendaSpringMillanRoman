package com.jacaranda.model;

import java.util.Objects;

public class Element {

	private int id;
	private String name;
	private String description;
	private int strock;
	private int price;
	private int id_category;
	
	
//	Constructores
	public Element() {
		super();
	}

	public Element(int id, String name, String description, int strock, int price, int id_category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.strock = strock;
		this.price = price;
		this.id_category = id_category;
	}

//	getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStrock() {
		return strock;
	}

	public void setStrock(int strock) {
		this.strock = strock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

//	hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}
	
	
	
}
