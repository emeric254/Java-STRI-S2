package com.java_s2.STRI.utils;
import java.sql.*;

/*
 * doc > http://www.postgresql.org/docs/7.2/static/jdbc.html
 */


public class postgreSQL {
	
	public postgreSQL() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*
		int foovalue = 500; // var
		
		// ecriture requete avec une var
		PreparedStatement st = db.prepareStatement("SELECT * FROM mytable where columnfoo = ?");
		
		//application de la var
		st.setInt(1, foovalue);
		
		// ecup resluts par exec de la requete
		ResultSet rs = st.executeQuery();
		
		//parcours results
		while(rs.next())
		{
		    System.out.print("Column 1 returned ");
		    System.out.println(rs.getString(1));
		}
		
		rs.close(); // fermer les resultats
		st.close(); // fermer la requete
	 */

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
