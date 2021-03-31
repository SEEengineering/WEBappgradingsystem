package com.mcharrison.jwtauthentication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "current_users")
public class AllUsers {
	
	@Id
	private String ID;

	private String name;
	private String Lastname;
	private String email;
	private int phone;
	private String address;
	private String sex;
	private String role;
	
	
	protected AllUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected AllUsers(String iD, String name, String lastname, String email, int phone, String address, String sex,
			String role) {
		super();
		ID = iD;
		this.name = name;
		Lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
		this.role = role;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	
	
	

}
