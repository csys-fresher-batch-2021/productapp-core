package com.naresh.validator;

import com.naresh.model.Product;

public class ProductValidatorTest {

	
	
	public static void main(String[] args) {

		//testValidProduct();// Expectation: SUCCESS
		//testInValidProductName();// Expectation: Invalid Product Name
		testInValidProductPrice();// Expectation: Invalid Product Price
	}
	
	private static void testInValidProductPrice() {
		Product product = new Product(1,"Sugar",-50);
		
		try {
			ProductValidator.validate(product);
			System.out.println("Validation Success");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Validation Failed:" + errorMessage);
			e.printStackTrace();
		}
	}
	
	private static void testInValidProductName() {
		Product product = new Product(1,"",100);
		
		try {
			ProductValidator.validate(product);
			System.out.println("Validation Success");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Validation Failed:" + errorMessage);
			e.printStackTrace();
		}
	}

	private static void testValidProduct() {
		Product product = new Product(1,"Sugar",100);
		
		try {
			ProductValidator.validate(product);
			System.out.println("Validation Success");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Validation Failed:" + errorMessage);
			e.printStackTrace();
		}
	}

}
