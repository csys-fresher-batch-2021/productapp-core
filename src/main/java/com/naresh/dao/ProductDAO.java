package com.naresh.dao;

import com.naresh.model.Product;

public interface ProductDAO {

	boolean save(Product product) throws Exception;
}
