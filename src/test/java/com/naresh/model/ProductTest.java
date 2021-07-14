package com.naresh.model;

public class ProductTest {

	public static void main(String[] args) {

		Product product1 = new Product(1, "Sugar", 100);
		Product product2 =  new Product();
		product2.setId(2);
		product2.setName("Tomato");
		product2.setPrice(30);		
		
		System.out.println("P1 Price:" + product1.getPrice());
		System.out.println("P2 Price:" + product2.getPrice());
	}

}
