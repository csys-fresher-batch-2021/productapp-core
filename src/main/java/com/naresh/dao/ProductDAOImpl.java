package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.naresh.model.Product;
import com.naresh.util.ConnectionUtil;

public class ProductDAOImpl implements ProductDAO {

	public boolean save(Product product) throws Exception {

		String sql = "insert into products(id,name,price) values(" + product.id + ",'" + product.name + "',"
				+ product.price + ")";//Bad Practice: Avoid appending query string. SQL Injection.
		System.out.println(sql);

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		int rows = pst.executeUpdate();
		System.out.println("No of rows inserted :" + rows);

		return false;
	}

	public boolean deleteProduct(int id) throws Exception {

		String sql = "delete from products where id = ?";// Good Practice
		System.out.println(sql);

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, id);// 1st ?
		
		
		int rows = pst.executeUpdate();
		System.out.println("No of rows deleted :" + rows);

		return false;
	}
	
	public boolean updateProduct(Product product) throws Exception {

		String sql = "update products set price = ? where id = ?";// Good Practice
		System.out.println(sql);

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, product.price);// 1st ?
		pst.setInt(2, product.id);		
		
		int rows = pst.executeUpdate();
		System.out.println("No of rows update :" + rows);

		return false;
	}

}
