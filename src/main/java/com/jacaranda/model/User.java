package com.jacaranda.model;

import java.util.Objects;

public class User {

	private String user;
	private String password;
	private String name;
	private String email;
	private boolean administrator;
	
//	constructores
	public User() {
		super();
	}

	public User(String user, String password, String name, String email, boolean administrator) {
		super();
		this.user = user;
		this.password = password;
		this.name = name;
		this.email = email;
		this.administrator = administrator;
	}

//	getter and setter
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

//	hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(user, other.user);
	}
	
	
	
}
