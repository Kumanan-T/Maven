package com.utitlity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connector {
public static String getParticularData() throws SQLException {

	String url ="jdbc:mysql://localhost:3306/employees";
	
	String username="root";
	String password="admin";
	String query="SELECT  * from employees";
	
	//CONNECTION ESTABLISH
	Connection connection = DriverManager.getConnection(url,username,password);
	
	//Create a statement
	Statement statement = connection.createStatement();
	
	//Execute query
	ResultSet result = statement.executeQuery(query);
	
	result.next();
	
	String firstname = result.getString(3);
	return firstname;

}

public static void getalldata() throws SQLException {
	String url ="jdbc:mysql://localhost:3306/employees";
	
	String username="root";
	String password="admin";
	String query ="SELECT * FROM employees limit 5";
	
	Connection connection = DriverManager.getConnection(url,username,password);
	Statement statement = connection.createStatement();
	ResultSet result = statement.executeQuery(query);
	
	
}
	
}
