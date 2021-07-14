package com.naresh.service;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.exception.DBException;
import com.naresh.exception.ServiceException;
import com.naresh.exception.ValidationException;
import com.naresh.model.Product;
import com.naresh.validator.ProductValidator;

public class ProductService {

	private ProductDAO productDAO = new ProductDAOImpl();
	
	public void addProduct(Product product) throws ServiceException {
		
		try {
			
			//Step 1: Validation
			ProductValidator.validate(product);
			//Step 2: Call DAO 
			productDAO.save(product);
			System.out.println("Successfully added product");
			
		} catch (ValidationException | DBException e ) {

			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
			throw new ServiceException(e, errorMessage);			
		}
		
	}
}
