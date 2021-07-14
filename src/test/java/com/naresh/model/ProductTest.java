package com.naresh.model;

public class ProductTest {

	public static void main(String[] args) {

		Product product1 = new Product(1, "Sugar", 100);
		//hide the internals
		//product1.price = -100;
		
		
		//provide setter methods to set values
		product1.setPrice(-100);
		
		System.out.println(product1.getPrice());
	}

}
