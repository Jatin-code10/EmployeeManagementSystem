package com.Au.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	public static Connection createDBConnection() {
		try {
			// Load Driver
			String url = "jdbc:mysql://localhost:3306/employe_manage";
			String userName = "root";
			String password = "root";
			
			con = DriverManager.getConnection(url,userName,password);
			System.out.println("Connected Sucessfully");
		}
		// Con Close
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
