package com.jacaranda.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	
	  @OneToMany(mappedBy="userObjOrd") private List<Order> order;
	 

	
/*userDetails
	userDetails y 
	nos obliga a implementar el getUsername(), get Password 
	y otros metodos que te importa
	*/
	
//	constructores
	public User() {
		super();
		this.username = null;
		this.password = null;
		this.realusername = null;
		this.email = null;
		this.administrator = false;
		this.order = null;
	}

	
	public User(String username, String password, String realusername, String email, boolean administrator,
		List<Order> order) {
	super();
	this.username = username;
	this.password = password;
	this.realusername = realusername;
	this.email = email;
	this.administrator = administrator;
	this.order = order;
}

//	getter and setter
	
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



	public List<Order> getOrder() {
		return order;
	}



	public void setOrder(List<Order> order) {
		this.order = order;
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
