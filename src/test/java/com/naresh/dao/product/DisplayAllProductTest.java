package com.naresh.dao.product;

import java.util.ArrayList;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;

public class DisplayAllProductTest {

	public static void main(String[] args) {

		ProductDAO productDAO = new ProductDAOImpl();
		try {
			ArrayList<Product> productList = productDAO.findAll();
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
