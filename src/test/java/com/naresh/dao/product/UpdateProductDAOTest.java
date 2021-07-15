package com.naresh.dao.product;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;

public class UpdateProductDAOTest {

	public static void main(String[] args) {

		
		ProductDAO productDAO = new ProductDAOImpl();
		
		Product product = new Product(1, "Sugar", 200);
		
		try {
			productDAO.updateProduct(product);
			System.out.println("Successfully updated product");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
		}
	}

}
