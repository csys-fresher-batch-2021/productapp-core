package com.naresh.service.product;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;
import com.naresh.service.ProductService;

public class UpdateProductServiceTest {

	public static void main(String[] args) {

		
		ProductService productService = new ProductService();
		
		Product product = new Product(1, "Sugar", 200);
		
		try {
			productService.update(product);
			System.out.println("Successfully updated product");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
		}
	}

}
