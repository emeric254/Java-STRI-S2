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
	
	public static boolean creerBase()
	{
		try
		{
//			Connection db = connexion();
//			Statement statement = db.createStatement();
//			PreparedStatement preparedStatement = db.prepareStatement( "CREATE TABLE local (	serialized_id serial PRIMARY KEY, object_name varchar(1024) default NULL,serialized_object bytea);");
//			preparedStatement.executeQuery();
			
			Connection db = connexion();
			db.createStatement().execute("CREATE TABLE local (	serialized_id serial PRIMARY KEY, object_name varchar(1024) default NULL,serialized_object bytea);");
	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	public static boolean detruireBase()
	{
		try
		{
//			Connection db = connexion();
//			Statement statement = db.createStatement();
//			PreparedStatement preparedStatement = db.prepareStatement("DROP TABLE local");
//			preparedStatement.executeQuery();
//	
			Connection db = connexion();
			db.createStatement().execute("DROP TABLE local;");
	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	
	
	public static boolean importBase()
	{
		Connection db= connexion();
		return true;
	}

	public static boolean exportBase()
	{
		Connection db= connexion();
		return true;
	}
}
