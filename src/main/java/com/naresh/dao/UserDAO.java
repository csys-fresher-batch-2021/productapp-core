package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naresh.exception.DBException;
import com.naresh.model.User;
import com.naresh.util.ConnectionUtil;

public class UserDAO {

	//insert/update/delete
	private boolean runDMLQuery(String sql) throws DBException {
		System.out.println(sql);

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			int rows = pst.executeUpdate();
			
			System.out.println("No of rows inserted :" + rows);
			return rows == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Unable to execute query");
		}
		finally {
			
			ConnectionUtil.close(pst, connection);
			
		}

	}
	
	public boolean save(User user) throws DBException {
		String sql = "insert into users ( id,name,email,password) values ( id_sq.nextval, '"+ user.getName() + "','" + user.getEmail() + "','"+ user.getPassword() +"')";
		System.out.println(sql);
		boolean result = runDMLQuery(sql);
		System.out.println(result);
		return result;
	}
	
	public boolean delete(int userId) throws DBException {
		String sql = "update users set active = 0  where id = " + userId ;
		System.out.println(sql);
		boolean result = runDMLQuery(sql);
		return result;
	}
	
	public boolean changePassword(int userId, String password) throws DBException {
		String sql = "update users set password = '" + password + "'   where id = " + userId ;
		System.out.println(sql);
		boolean result = runDMLQuery(sql);
		return result;
	}
	
	public ArrayList<User> findAll() throws DBException {
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "select id,name,email,password from users";
		
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			//Step 1: Get the connection
			connection = ConnectionUtil.getConnection();
			
			// Step 2: Prepare Query
			pst = connection.prepareStatement(sql);
			
			// Step 3:Execute Query
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				User user = new User(id,name,email,password);
				userList.add(user);
				//return id;
				//return name;
				//return email;
				//return password;
				//return user; 1 row => 1 object
				//return userList;// more rows => [ ] store and return
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e, "Unable to execute query");
		}
		finally {
			// Last step: Close connection resources
			
			ConnectionUtil.close(pst, connection);
			
		}

		return userList;
	}
}
