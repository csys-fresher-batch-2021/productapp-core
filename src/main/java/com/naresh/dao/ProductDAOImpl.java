package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naresh.exception.DBException;
import com.naresh.model.Product;
import com.naresh.util.ConnectionUtil;

public class ProductDAOImpl implements ProductDAO {

	public boolean save(Product product) throws DBException {

		String sql = "insert into products(id,name,price) values(" + product.id + ",'" + product.name + "',"
				+ product.price + ")";// Bad Practice: Avoid appending query string. SQL Injection.
		System.out.println(sql);

		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Unable to add products");
		}

		return false;
	}

	public boolean deleteProduct(int id) throws DBException {

		String sql = "delete from products where id = ?";// Good Practice
		System.out.println(sql);

		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, id);// 1st ?

			int rows = pst.executeUpdate();
			System.out.println("No of rows deleted :" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Unable to delete product ");
		}

		return false;
	}

	public boolean updateProduct(Product product) throws DBException {

		String sql = "update products set price = ? where id = ?";// Good Practice
		System.out.println(sql);

		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, product.price);// 1st ?
			pst.setInt(2, product.id);

			int rows = pst.executeUpdate();
			System.out.println("No of rows update :" + rows);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Unable to update products");
		}
		return false;
	}

	public ArrayList<Product> findAll() throws DBException {

		// 4. Iterate results and get row and column values
		ArrayList<Product> productList;
		try {
			// 1. Get DB connection
			Connection connection = ConnectionUtil.getConnection();

			String sql = "select id,name,price from products";

			// 2. Prepare Query
			PreparedStatement pst = connection.prepareStatement(sql);

			// 3. Execute Query and get results
			ResultSet rs = pst.executeQuery();

			productList = new ArrayList<Product>();
			while (rs.next()) {
				// Get Column values
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");

				Product product = new Product(id, name, price);

				// System.out.println(id + "-" + name + "-" + price);
				System.out.println(product);

				productList.add(product);

			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Unable to fetch product details");
		}

		return productList;

	}

	public Product findOne(int productId) throws DBException {

		// 4. Iterate results and get row and column values
		Product product;
		try {
			// 1. Get DB connection
			Connection connection = ConnectionUtil.getConnection();

			String sql = "select id,name,price from products where id = ?";

			// 2. Prepare Query
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, productId);

			// 3. Execute Query and get results
			ResultSet rs = pst.executeQuery();

			product = null;
			if (rs.next()) {
				// Get Column values
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");

				product = new Product(id, name, price);

				// System.out.println(id + "-" + name + "-" + price);
				System.out.println(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Unable to find product details");
		}

		return product;

	}

}
