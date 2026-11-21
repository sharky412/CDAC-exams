package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	
	private static final String URL = envOrDefault("DB_URL", "jdbc:mysql://localhost:3306/java");
	private static final String USERNAME = envOrDefault("DB_USER", "root");
	private static final String PASSWORD = System.getenv("DB_PASSWORD");
	
	private static String envOrDefault(String name, String fallback) {
		String value = System.getenv(name);
		return (value == null || value.isEmpty()) ? fallback : value;
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	

}

