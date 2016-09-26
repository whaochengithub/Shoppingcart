package com.whc.shoppingcart.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


public class User {
	
	private int id;

	private String userName;
	
	
	private String password;
	
	
	private String e_mail;
	
	private Integer phone;
	
	
	//private Set<Product> products = new HashSet<Product>();
	
	public User(){
		
	}
	
	public User(int id, String userName, String password, String e_mail, Integer phone) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.e_mail = e_mail;
		this.phone = phone;
		//this.products = products;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	
}
