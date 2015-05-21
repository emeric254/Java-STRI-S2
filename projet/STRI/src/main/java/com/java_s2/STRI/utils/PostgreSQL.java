package com.java_s2.STRI.utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.modele.Switch;
import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.modele.Terminal;

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
			db.createStatement().execute("DROP TABLE IF EXISTS appareil; DROP TABLE IF EXISTS interface; DROP TABLE IF EXISTS firmware; DROP TABLE IF EXISTS os; DROP TABLE IF EXISTS salle; DROP TABLE IF EXISTS local; CREATE table local (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, lieuLocal varchar(1024) NOT NULL ); CREATE TABLE salle (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, idLocal integer NOT NULL, CONSTRAINT FK_SA_LO FOREIGN KEY (idLocal) REFERENCES local(id) ); CREATE TABLE os (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, version varchar(1024) NOT NULL ); CREATE TABLE firmware (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, version varchar(1024) NOT NULL ); CREATE TABLE interface (id integer NOT NULL PRIMARY KEY, adresseMAC integer NOT NULL, nom varchar(1024) NOT NULL, idFirmware integer NOT NULL, CONSTRAINT FK_INT_FIR FOREIGN KEY (idFirmware) REFERENCES firmware(id) ); CREATE TABLE appareil (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, marque varchar(1024) NOT NULL, etat boolean NOT NULL, type varchar(1024) DEFAULT NULL, idSalle integer NOT NULL, idOs integer NOT NULL, idInterface integer NOT NULL, idSwitch integer DEFAULT NULL, CONSTRAINT FK_TER_SA FOREIGN KEY (idSalle) REFERENCES salle(id), CONSTRAINT FK_TER_OS FOREIGN KEY (idOs) REFERENCES os(id), CONSTRAINT FK_TER_IN FOREIGN KEY (idInterface) REFERENCES interface(id), CONSTRAINT FK_TER_SW FOREIGN KEY (idSwitch) REFERENCES appareil(id) );");
			db.close();

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
			db.createStatement().execute("DROP TABLE IF EXISTS appareil; DROP TABLE IF EXISTS interface; DROP TABLE IF EXISTS firmware; DROP TABLE IF EXISTS os; DROP TABLE IF EXISTS salle; DROP TABLE IF EXISTS local;");
			db.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}


		return true;
	}
	
	public static void ecrireLocal(Connection db, Local local)
	{
		try
		{
			PreparedStatement pstmt = db.prepareStatement("INSERT INTO local (id, nom, lieulocal) VALUES (?,?,?);");

			// Parametres
			pstmt.setInt(1,local.getIdLocal());
			pstmt.setString(2, local.getNomLocal());
			pstmt.setString(3, local.getLieuLocal());
			pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void ecrireHashLocal (Connection db, HashMap<Integer, Local> locaux)
	{
		for (Integer i : locaux.keySet())
		{
			ecrireLocal(db, locaux.get(i));
		}
	}
	
	public static void ecrireSalle(Connection db, Salle salle, int idLocal )
	{
		try
		{
			PreparedStatement pstmt = db.prepareStatement("INSERT INTO salle (id, nom, idLocal) VALUES (?,?,?);");
			// Parametres
			pstmt.setInt(1,salle.getIdSalle());
			pstmt.setString(2, salle.getNomSalle());
			pstmt.setInt(3, idLocal);
			pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void ecrireOs(Connection db, SystemeExploitation os)
	{
		try
		{
			PreparedStatement pstmt = db.prepareStatement("INSERT INTO os (id, nom, version) VALUES (?,?,?);");
			// Parametres
			pstmt.setInt(1,os.getIdOS());
			pstmt.setString(2, os.getNomOS());
			pstmt.setString(3, os.getVersionOS());;
			pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void ecrireFirmware(Connection db , Firmware f)
	{
		try
		{
			PreparedStatement pstmt = db.prepareStatement("INSERT INTO firmware (id, nom, version) VALUES (?,?,?);");
			// Parametres
			pstmt.setInt(1,f.getIdFirmware());
			pstmt.setString(2, f.getNomFirmware());
			pstmt.setString(3, f.getVersionFirmware());;
			pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void ecrireInterface(Connection db , InterfaceReseau i)
	{
		try
		{
			PreparedStatement pstmt = db.prepareStatement("INSERT INTO interface (id, adresseMac, nom, idFirmware) VALUES (?,?,?,?);");
			// Parametres
			pstmt.setInt(1, i.getAdresseMAC());
			pstmt.setInt(2, i.getAdresseMAC());
			pstmt.setString(3, i.getNomInterface());
			pstmt.setInt(4, i.getFirmware().getIdFirmware());;
			pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void ecrireAppareil(Connection db, Appareil a, Salle salle)
	{
		try
		{	
			int idSwitch;
			String type;

			PreparedStatement pstmt = db.prepareStatement("INSERT INTO appareil (id, nom, marque, etat, type, idSalle, idOs, idSwitch, idInterface) VALUES (?,?,?,?,?,?,?,?,?);");
			pstmt.setInt(1, a.getIdAppareil());
			pstmt.setString(2, a.getNomAppareil());
			pstmt.setString(3, a.getMarqueAppareil());
			pstmt.setBoolean(4, a.getEtatAppareil());
			pstmt.setInt(6, salle.getIdSalle());
			pstmt.setInt(7, a.getOs().getIdOS());
			pstmt.setInt(9, a.getInterfaceReseau().getAdresseMAC());
			
			if (a instanceof Terminal)
			{
				pstmt.setString(5, ((Terminal) a).getType().toString());
				for (Appareil aL : salle.getAppareils())
				{
					if (aL instanceof Switch)
					{
						for (Appareil aLL: ((Switch) aL).getEquipementsAppareil())
						{
							if (aLL.getIdAppareil()==a.getIdAppareil())
							{
								pstmt.setInt(8, aL.getIdAppareil());
//								System.out.println("1--------------------------------------------");
							}
						}
						break;
					}
					pstmt.setNull(8, java.sql.Types.NULL);
				}
			}
			else if (a instanceof Switch)
			{
				pstmt.setNull(5, java.sql.Types.NULL);
				pstmt.setNull(8, java.sql.Types.NULL);
			}
			pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}


	public static boolean importBase()
	{
		Connection db= connexion();
		return true;
	}

	public static boolean exportBase(HashMap<Integer, Local> locaux, HashMap<Integer, Salle> salles, HashMap<Integer, Appareil> appareils, HashMap<Integer, InterfaceReseau> cartesReseaux, HashMap<Integer, Firmware> firmwares, HashMap <Integer, SystemeExploitation> OS)
	{
		Connection db= connexion();
		//Firmware
		for (Firmware f: firmwares.values())
		{
			ecrireFirmware(db, f);
		}
		
		//OS
		for(SystemeExploitation os : OS.values())
		{
			ecrireOs(db, os);
		}
		
		//Interface Reseau
		for (InterfaceReseau i : cartesReseaux.values())
		{
			ecrireInterface(db, i);
		}
		
		//Locaux, Salles, Appareils
		for (Local l: locaux.values())
		{
			ecrireLocal(db, l);
			
			for (Salle s: l.getSallesLocal())
			{
				ecrireSalle(db, s, l.getIdLocal());
				
				for (Appareil a: s.getAppareils())
				{
					ecrireAppareil(db, a, s);
				}
			}
		}
		return true;
	}
	
	public static HashMap<Integer, Local> lireLocaux()
	{
		HashMap<Integer, Local> locaux = new HashMap<Integer, Local>();
		
		try
		{
			Connection db= connexion();
			Statement s = null;
		    ResultSet r = null; 
			/* Création de l'objet gérant les requêtes */
	        s = db.createStatement();
	        /* Exécution d'une requête de lecture */
	        r = s.executeQuery( "SELECT * FROM local;");
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( r.next() ) 
	        {
	        	Local local= new Local(r.getInt("id"), r.getString("nom"), r.getString("lieuLocal"));
	        	locaux.put(local.getIdLocal(), local);
	        } 
	        r.close();
	        s.close();
	        db.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return locaux;
	}
	
	public static HashMap<Integer, SystemeExploitation> lireOs()
	{
		HashMap<Integer, SystemeExploitation> os = new HashMap<Integer, SystemeExploitation>();
		
		try
		{
			Connection db= connexion();
			Statement s = null;
		    ResultSet r = null; 
			/* Création de l'objet gérant les requêtes */
	        s = db.createStatement();
	        /* Exécution d'une requête de lecture */
	        r = s.executeQuery( "SELECT * FROM os;");
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( r.next() ) 
	        {
	        	SystemeExploitation osL= new SystemeExploitation(r.getInt("id"), r.getString("nom"), r.getString("version"));
	        	os.put(osL.getIdOS(), osL);
	        } 
	        r.close();
	        s.close();
	        db.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return os;
	}
	
	public static HashMap<Integer, Firmware> lireFirmwares()
	{
		HashMap<Integer, Firmware> firm = new HashMap<Integer, Firmware>();
		
		try
		{
			Connection db= connexion();
			Statement s = null;
		    ResultSet r = null; 
			/* Création de l'objet gérant les requêtes */
	        s = db.createStatement();
	        /* Exécution d'une requête de lecture */
	        r = s.executeQuery( "SELECT * FROM firmware;");
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( r.next() ) 
	        {
	        	Firmware f= new Firmware(r.getInt("id"), r.getString("nom"), r.getString("version"));
	        	firm.put(f.getIdFirmware(), f);
	        } 
	        r.close();
	        s.close();
	        db.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return firm;
	}
	
	public static HashMap<Integer, InterfaceReseau> lireInterfaces(HashMap<Integer, Firmware> firmwares)
	{
		
		HashMap<Integer, InterfaceReseau> interfaces= new HashMap<Integer, InterfaceReseau>();
		try
		{
			Connection db= connexion();
			Statement s = null;
		    ResultSet r = null; 
			/* Création de l'objet gérant les requêtes */
	        s = db.createStatement();
	        /* Exécution d'une requête de lecture */
	        r = s.executeQuery( "SELECT * FROM interface;");
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( r.next() ) 
	        {
	        	if (!firmwares.containsKey(r.getInt("idFirmware")))
	        	{
	        		throw new Exception("id firmware "+r.getInt("id")+" n existepas dans la base");
	        	}
	        	
	        	InterfaceReseau interfaceL= new InterfaceReseau(r.getInt("id"), r.getString("nom"), firmwares.get(r.getInt("idFirmware")));
	        	interfaces.put(interfaceL.getAdresseMAC(), interfaceL);
	        } 
	        r.close();
	        s.close();
	        db.close();
		}
		catch (Exception eSQL)
		{
			eSQL.printStackTrace();
		}
		return interfaces;
	}
	
	
	public static HashMap<Integer, Salle> lireSalles(HashMap<Integer, Local> locaux)
	{
		
		HashMap<Integer, Salle> salles= new HashMap<Integer, Salle>();
		try
		{
			Connection db= connexion();
			Statement s = null;
		    ResultSet r = null; 
			/* Création de l'objet gérant les requêtes */
	        s = db.createStatement();
	        /* Exécution d'une requête de lecture */
	        r = s.executeQuery( "SELECT * FROM salle;");
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( r.next() ) 
	        {
	        	Salle salle = new Salle(r.getInt("id"), r.getString("nom"));
	        	if (!locaux.containsKey(r.getInt("idLocal")))
	        	{
	        		throw new Exception("id local "+r.getInt("idLocal")+" n existepas dans la base");
	        	}
	        	locaux.get(r.getInt("idLocal")).getSallesLocal().add(salle);
	        	salles.put(salle.getIdSalle(), salle);
	        } 
	        r.close();
	        s.close();
	        db.close();
		}
		catch (Exception eSQL)
		{
			eSQL.printStackTrace();
		}
		return salles;
	}
	
	public static HashMap<Integer, Salle> lireAppareils(HashMap<Integer, Salle> salles, HashMap<Integer, SystemeExploitation> os, HashMap<Integer, InterfaceReseau> cr)
	{
		
//		HashMap<Integer, Appareil> appareils= new HashMap<Integer, Appareil>();
//		try
//		{
//			Connection db= connexion();
//			Statement s = null;
//		    ResultSet r = null; 
//			/* Création de l'objet gérant les requêtes */
//	        s = db.createStatement();
//	        /* Exécution d'une requête de lecture */
//	        r = s.executeQuery( "SELECT * FROM appareil;");
//	 
//	        /* Récupération des données du résultat de la requête de lecture */
//	        while ( r.next() ) 
//	        {
//	        	if (!os.containsKey(r.getInt("")))
//	        	
//	        } 
//	        r.close();
//	        s.close();
//	        db.close();
//		}
//		catch (Exception eSQL)
//		{
//			eSQL.printStackTrace();
//		}
		return salles;
	}
	
	


//	static final String WRITE_OBJECT_SQL = "INSERT INTO java(nom, object) VALUES (?, ?)";
//
//	static final String READ_OBJECT_SQL = "SELECT object FROM java WHERE id = ?";
//
//	public static long writeJavaObject(Connection conn, Object object) throws Exception {
//		String className = object.getClass().getName();
//		PreparedStatement pstmt = conn.prepareStatement(WRITE_OBJECT_SQL);
//
//		// set input parameters
//		pstmt.setString(1, className);
//		pstmt.setObject(2, object);
//		pstmt.executeUpdate();
//
//		// get the generated key for the id
//		ResultSet rs = pstmt.getGeneratedKeys();
//		int id = -1;
//		if (rs.next()) {
//			id = rs.getInt(1);
//		}
//
//		rs.close();
//		pstmt.close();
//		System.out.println("writeJavaObject: done serializing: " + className);
//		return id;
//	}
//
//	public static Object readJavaObject(Connection conn, long id) throws Exception {
//		PreparedStatement pstmt = conn.prepareStatement(READ_OBJECT_SQL);
//		pstmt.setLong(1, id);
//		ResultSet rs = pstmt.executeQuery();
//		rs.next();
//		Object object = rs.getObject(1);
//		String className = object.getClass().getName();
//
//		rs.close();
//		pstmt.close();
//		System.out.println("readJavaObject: done de-serializing: " + className);
//		return object;
//	}
//	
}
