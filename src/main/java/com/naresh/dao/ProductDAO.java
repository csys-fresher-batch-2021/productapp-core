package com.naresh.dao;

import java.util.ArrayList;

import com.naresh.exception.DBException;
import com.naresh.model.Product;

public interface ProductDAO {

	boolean save(Product product) throws DBException;
	
	boolean updateProduct(Product product) throws DBException;
	
	boolean deleteProduct(int id) throws DBException;
	
	ArrayList<Product> findAll() throws DBException;
	
	Product findOne(int productId) throws DBException;
}
