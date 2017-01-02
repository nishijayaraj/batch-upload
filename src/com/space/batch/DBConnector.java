package com.space.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	private static final String DB_DRIVER = "com.mysql.jdbc.DRIVER";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	private static Connection conn;
	private static PreparedStatement ps;
	
	public static void createConnection() {
		
		// conn = null;
		System.out.println("asdasdfafds");

		try {

			Class.forName(DB_DRIVER);
		

		} catch(ClassNotFoundException cnf){
			 System.out.println("Driver could not be loaded: " + cnf);
		} 
		
		try{
			conn = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			String query = "INSERT INTO batch"
					+ "(userID, username, address) VALUES"
					+ "(?,?,?)";
			    
			ps = conn.prepareStatement(query);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Connection getDBConnection() {
		
		return conn;
		
		}
	
	public static PreparedStatement getPSInstance() {
		return ps;
		
	}

	
}
