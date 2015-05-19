package com.java_s2.STRI.utils;
import java.sql.*;

/*
 * doc > http://www.postgresql.org/docs/7.2/static/jdbc.html
 */


public abstract class PostgreSQL {
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

	public static Connection connexion ()
	{
		String url="jdbc:postgresql://boulic.fr:5432/java";
		String username="java";
		String password="java486stri";
		Connection db=null;
		try 
		{
			db = DriverManager.getConnection(url, username, password);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return db;
		
	}
	
	public static boolean importBase()
	{
//		try 
//		{
//			Connection db= connexion();
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		
		return false;
	}

	public static boolean exportBase()
	{
		
//		try 
//		{
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		return false;
	}
}
