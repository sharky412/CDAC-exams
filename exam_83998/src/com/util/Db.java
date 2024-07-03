package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	
	private static final String URL = "jdbc:mysql://localhost:3306/java";
	private static final String USERNAME = "root";
	private static final String password = "manager";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USERNAME, password);
	}
	

}

