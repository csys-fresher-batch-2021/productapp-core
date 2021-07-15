package com.naresh.service.product;

import com.naresh.model.Product;
import com.naresh.service.ProductService;

public class AddProductServiceTest {

	public static void main(String[] args) {

		Product product = new Product(1, "Sugar", 100);
		ProductService productService = new ProductService();
		try {
			productService.addProduct(product);
			System.out.println("Successfully added product");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
		}
	}

}
