package com.naresh.model;

public class Product {

	private int id;
	private String name;
	private int price;
	
	public Product() {
		
	}
	public Product(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	public void setPrice(int price) {
		if(price < 0) {
			throw new IllegalArgumentException("Invalid Price");
		}
		this.price= price;
	}
	
	public int getPrice() {
		return price;
	}
	
	

}
