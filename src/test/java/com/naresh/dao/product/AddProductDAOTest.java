package com.naresh.dao.product;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;

public class AddProductDAOTest {

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
