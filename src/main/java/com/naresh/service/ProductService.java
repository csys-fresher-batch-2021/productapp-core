package com.naresh.service;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;
import com.naresh.validator.ProductValidator;

public class ProductService {

	private ProductDAO productDAO = new ProductDAOImpl();
	
	public void addProduct(Product product) throws Exception {
		
		try {
			
			//Step 1: Validation
			ProductValidator.validate(product);
			//Step 2: Call DAO 
			productDAO.save(product);
			System.out.println("Successfully added product");
			
		} catch (Exception e) {

			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
			throw new Exception(errorMessage);
			
		}
	}
}
