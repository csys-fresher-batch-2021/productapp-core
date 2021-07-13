package com.naresh.dao;

import java.util.ArrayList;

import com.naresh.model.Product;

public interface ProductDAO {

	boolean save(Product product) throws Exception;
	
	boolean updateProduct(Product product) throws Exception;
	
	boolean deleteProduct(int id) throws Exception;
	
	ArrayList<Product> findAll() throws Exception;
}
