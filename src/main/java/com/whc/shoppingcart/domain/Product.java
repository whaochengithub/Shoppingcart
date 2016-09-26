package com.whc.shoppingcart.domain;


import javax.persistence.*;


public class Product {
	
	private int id;
	
	private String name;
	
	
	private String description;
	
	
	private float price;
	
	
	private int cal;
	

	private String sku;

	
	private Integer owner_id;
	
	private String owner_name;
	
	
	public Product(){
		
	}
	
	public Product(int id, String name, String description, float price, int cal, String sku, int owner_id,
			String owner_name) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.cal = cal;
		this.sku = sku;
		this.owner_id = owner_id;
		this.owner_name = owner_name;
		
	}
	
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		this.cal = cal;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	

	
	
	
	
}
