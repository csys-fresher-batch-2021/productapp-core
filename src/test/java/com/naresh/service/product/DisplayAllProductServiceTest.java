package com.naresh.service.product;

import java.util.ArrayList;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;
import com.naresh.service.ProductService;

public class DisplayAllProductServiceTest {

	public static void main(String[] args) {

		ProductService productService = new ProductService();
		try {
			ArrayList<Product> productList = productService.getAllProducts();
			for (Product product : productList) {
				System.out.println(product);
			}
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
		}
	}

}
