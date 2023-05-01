package com.jacaranda.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userdb")
public class User {

	@Id
	private String username;
	private String password;
	private String realusername;
	private String email;
	private boolean administrator;
	
//	constructores
	public User() {
		super();
	}

	public User(String username, String password, String realusername, String email, boolean administrator) {
		super();
		this.username = username;
		this.password = password;
		this.realusername = realusername;
		this.email = email;
		this.administrator = administrator;
	}
	
	
	// getter and setter
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRealusername() {
		return realusername;
	}
	
	public void setRealusername(String realusername) {
		this.realusername = realusername;
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
	
	//hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(username);
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
		return Objects.equals(username, other.username);
	}
	



	
	
}
