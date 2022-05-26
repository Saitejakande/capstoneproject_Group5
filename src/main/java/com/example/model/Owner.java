package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Owner")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment 
	private int ownerId;
	private String name;
	private String email;
	private String password;
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		ownerId = ownerId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
