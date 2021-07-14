package com.naresh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naresh.exception.DBException;

public class ConnectionUtil {

	/**
	 * This method is used to get the database connection
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws DBException {
		String driverClassName = "oracle.jdbc.driver.OracleDriver";		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";		
		String username = "system";		
		String password = "password";
		
		Connection connection = null;
		try {
			//Step 1: Load the driver
			Class.forName(driverClassName);
			
			//Step 2: Connection			
			connection = DriverManager.getConnection(url, username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DBException(e,"Unable to load the db driver class");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e,"Unable to connect database");
		}
		
		System.out.println(connection);		

		return connection;
	}
	
	
	public static void close(PreparedStatement pst, Connection connection) {
		try {
			if(pst !=null) {
				pst.close();
			}
			if(connection !=null) {
				connection.close();
			}
		} catch (SQLException e) {
			//suppress exception
		}
	}
	
	public static void close(PreparedStatement pst, ResultSet rs, Connection connection) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pst !=null) {
				pst.close();
			}
			if(connection !=null) {
				connection.close();
			}
		} catch (SQLException e) {
			//suppress exception
		}
	}
}
