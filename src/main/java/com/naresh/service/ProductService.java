package com.naresh.service;

import java.util.ArrayList;

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

			// Step 1: Validation
			ProductValidator.validate(product);
			// Step 2: Call DAO
			productDAO.save(product);
			System.out.println("Successfully added product");

		} catch (ValidationException | DBException e) {

			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
			throw new ServiceException(e, errorMessage);
		}

	}

	public void update(Product product) throws ServiceException {
		try {
			productDAO.updateProduct(product);
		} catch (DBException e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
			throw new ServiceException(e, errorMessage);
		}
	}

	public Product searchByProductId(int productId) throws ServiceException {

		Product product = null;
		try {
			product = productDAO.findOne(productId);
			if (product == null) {
				throw new ServiceException("Invalid product Id");
			}
		} catch (DBException e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
			throw new ServiceException(e, errorMessage);
		}
		return product;
	}

	public ArrayList<Product> getAllProducts() throws ServiceException {
		ArrayList<Product> productList = null;
		try {
			productList = productDAO.findAll();

		} catch (DBException e) {

			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
			throw new ServiceException(e, errorMessage);
		}
		return productList;
	}
}
