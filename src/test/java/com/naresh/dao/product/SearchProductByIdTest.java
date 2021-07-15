package com.naresh.dao.product;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;

public class SearchProductByIdTest {

	public static void main(String[] args) {

		ProductDAO productDAO = new ProductDAOImpl();
		try {
			Product product = productDAO.findOne(1);
			System.out.println(product);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
		}
	}

}
