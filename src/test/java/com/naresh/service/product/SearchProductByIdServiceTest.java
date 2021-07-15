package com.naresh.service.product;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;
import com.naresh.service.ProductService;

public class SearchProductByIdServiceTest {

	public static void main(String[] args) {

		ProductService productService = new ProductService();
		try {
			Product product = productService.searchByProductId(1);
			System.out.println(product);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
		}
	}

}
