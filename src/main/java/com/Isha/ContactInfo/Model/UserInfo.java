package com.Isha.ContactInfo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String password;
	private String role;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserInfo(Integer id, String name, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
