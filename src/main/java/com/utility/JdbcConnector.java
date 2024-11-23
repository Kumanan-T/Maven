package com.utility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnector {
	
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
		
		int employeeNo = result.getInt("emp_no");
		System.out.println(employeeNo);
		
		Date date = result.getDate(3);
		System.out.println(date);
		
		String firstname = result.getNString(3);
		System.out.println(firstname);

}
}