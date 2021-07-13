package com.naresh.dao;

import com.naresh.model.Product;

public class ProductDAOImpl implements ProductDAO{

	public boolean save(Product product) throws Exception {

		String sql="insert into products(id,name,price) values(" + product.id + ",'"+ product.name + "'," + product.price + ")";
		System.out.println(sql);
		return false;
	}

	
}
