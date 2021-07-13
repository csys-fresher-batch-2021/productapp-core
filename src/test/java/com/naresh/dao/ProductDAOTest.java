package com.naresh.dao;

import com.naresh.model.Product;

public class ProductDAOTest {

	public static void main(String[] args) {

		Product product = new Product(1, "Sugar", 100);
		ProductDAO productDAO = new ProductDAOImpl();
		try {
			productDAO.save(product);
			System.out.println("Successfully added product");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
		}
	}

}
