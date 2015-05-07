package com.java_s2.STRI.utils;
import java.sql.*;

public class postgreSQL {
	
	public postgreSQL() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean importBase(){
		
		try {
			Connection db = DriverManager.getConnection("url", "username", "password");

			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean exportBase(){
		
		try {
			Connection db = DriverManager.getConnection("url", "username", "password");

			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
