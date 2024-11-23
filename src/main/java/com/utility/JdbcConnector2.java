package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnector2 {
	public static String getParticularData() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/employees";
		String username = "root";
		String password = "Kumanan@123";
		String query = "SELECT * FROM employees";
		
		        //connection establish
				Connection connection=DriverManager.getConnection(url, username, password);
				
				//create a statement
				Statement statement=connection.createStatement();
				
				//execute query
				ResultSet result = statement.executeQuery (query);
				
				result.next();
				
				String firstname = result.getString(3);
				return firstname;
	}
	public static void getalldata() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/employees";
		String username = "root";
		String password = "Kumanan@123";
		String query = "SELECT * FROM employees limit 5";
		
		//connection establish
		Connection connection=DriverManager.getConnection(url, username, password);
		
		//create a statement
		Statement statement=connection.createStatement();
		
		//execute query
		ResultSet result = statement.executeQuery (query);
		
	}
	}


