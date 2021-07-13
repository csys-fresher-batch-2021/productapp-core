package com.naresh.service;

import com.naresh.model.Product;

public class ProductServiceTest {

	public static void main(String[] args) {

		// testValidProduct(); //Expected:Success
		testInValidProductName();// Expected: Invalid Product Name
	}

	private static void testInValidProductName() {
		Product product = new Product(1, "", 100);
		ProductService productService = new ProductService();
		try {
			productService.addProduct(product);
		} catch (Exception e) {
			System.out.println("Error Message:" + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void testValidProduct() {
		Product product = new Product(1, "Sugar", 100);
		ProductService productService = new ProductService();
		try {
			productService.addProduct(product);
		} catch (Exception e) {
			System.out.println("Error Message:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
