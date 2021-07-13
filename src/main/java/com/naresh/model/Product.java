package com.naresh.model;

public class Product {

	public int id;
	public String name;
	public int price;
	
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

}
