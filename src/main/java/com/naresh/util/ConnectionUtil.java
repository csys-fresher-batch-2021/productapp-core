package com.naresh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	/**
	 * This method is used to get the database connection
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
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
			throw new Exception("Unable to load the db driver class");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to connect database");
		}
		
		System.out.println(connection);		

		return connection;
	}
}
