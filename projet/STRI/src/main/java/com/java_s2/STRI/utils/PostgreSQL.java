package com.java_s2.STRI.utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.postgresql.jdbc2.ResultWrapper;

import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.modele.Switch;
import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.modele.Terminal;
import com.java_s2.STRI.modele.Type;

/*
 * doc > http://www.postgresql.org/docs/7.2/static/jdbc.html
 */


/**
 * @author robin
 *
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

	/**
	 * Retourne une connexion à la base de donnees;
	 * Les id de connexion sont a faire dans la fonction
	 * 
	 * @return Connection
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

	
	/**
	 *Cree une base de donnees 
	 *
	 * @return
	 */
	public static boolean creerBase()
	{
		try
		{
			//			Connection db = connexion();
			//			Statement statement = db.createStatement();
			//			PreparedStatement preparedStatement = db.prepareStatement( "CREATE TABLE local (	serialized_id serial PRIMARY KEY, object_name varchar(1024) default NULL,serialized_object bytea);");
			//			preparedStatement.executeQuery();

			Connection db = connexion();
			db.createStatement().execute("DROP TABLE IF EXISTS appareil; DROP TABLE IF EXISTS interface; DROP TABLE IF EXISTS firmware; DROP TABLE IF EXISTS os; DROP TABLE IF EXISTS salle; DROP TABLE IF EXISTS local; CREATE table local (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, lieuLocal varchar(1024) NOT NULL ); CREATE TABLE salle (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, idLocal integer NOT NULL, CONSTRAINT FK_SA_LO FOREIGN KEY (idLocal) REFERENCES local(id) ); CREATE TABLE os (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, version varchar(1024) NOT NULL ); CREATE TABLE firmware (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, version varchar(1024) NOT NULL ); CREATE TABLE interface (id integer NOT NULL PRIMARY KEY, adresseMAC integer NOT NULL, nom varchar(1024) NOT NULL, idFirmware integer NOT NULL, CONSTRAINT FK_INT_FIR FOREIGN KEY (idFirmware) REFERENCES firmware(id) ); CREATE TABLE appareil (id integer NOT NULL PRIMARY KEY, nom varchar(1024) NOT NULL, marque varchar(1024) NOT NULL, etat boolean NOT NULL, type varchar(1024) DEFAULT NULL, idSalle integer NOT NULL, idOs integer NOT NULL, idInterface integer NOT NULL, idSwitch integer DEFAULT NULL, modele varchar(1024) NOT NULL, CONSTRAINT FK_TER_SA FOREIGN KEY (idSalle) REFERENCES salle(id), CONSTRAINT FK_TER_OS FOREIGN KEY (idOs) REFERENCES os(id), CONSTRAINT FK_TER_IN FOREIGN KEY (idInterface) REFERENCES interface(id), CONSTRAINT FK_TER_SW FOREIGN KEY (idSwitch) REFERENCES appareil(id) );");
			db.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}


		return true;
	}

	/**
	 * Detruit la base de donnees
	 * @return
	 */
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
	
	/**
	 * Ecrit le local passe en parametre dans la base bd
	 * 
	 * @param db
	 * @param local
	 */
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
	
	/**
	 * Ecrit une la hash de locaux passee a parametres dans la base db
	 * 
	 * @param db
	 * @param locaux
	 */
	public static void ecrireHashLocal (Connection db, HashMap<Integer, Local> locaux)
	{
		for (Integer i : locaux.keySet())
		{
			ecrireLocal(db, locaux.get(i));
		}
	}
	
	/**
	 * Ecrit la salle passee en parametre dans la base db
	 * 
	 * @param db
	 * @param salle
	 * @param idLocal
	 */
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
	
	/**
	 * Ecrit l'os passe en parametre dans la base db
	 * 
	 * @param db
	 * @param os
	 */
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
	
	
	
	/**
	 * Ecrit le firmware f dans la base db
	 * 
	 * @param db
	 * @param f
	 */
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
	
	/**
	 * Ecrit l'interface reseeau i dans la base db
	 * 
	 * @param db
	 * @param i
	 */
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
	
	/**
	 * Ecrit l'appareil a dans la base db
	 * 
	 * @param db
	 * @param a
	 * @param salle
	 */
	public static void ecrireAppareil(Connection db, Appareil a, Salle salle)
	{
		try
		{	
			int idSwitch;
			String type;

			PreparedStatement pstmt = db.prepareStatement("INSERT INTO appareil (id, nom, marque, etat, type, idSalle, idOs, idSwitch, idInterface, modele) VALUES (?,?,?,?,?,?,?,?,?,?);");
			pstmt.setInt(1, a.getIdAppareil());
			pstmt.setString(2, a.getNomAppareil());
			pstmt.setString(3, a.getMarqueAppareil());
			pstmt.setBoolean(4, a.getEtatAppareil());
			pstmt.setInt(6, salle.getIdSalle());
			pstmt.setInt(7, a.getOs().getIdOS());
			pstmt.setInt(9, a.getInterfaceReseau().getAdresseMAC());
			pstmt.setString(10, a.getModeleAppareil());
			
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


//	public static boolean importBase()
//	{
//		Connection db= connexion();
//		return true;
//	}

	/**
	 * Exporte les hashMap du programme (locaux, salles, appareils, os, firmware, carte reseaux ) dans la base de donnees
	 * @param locaux
	 * @param salles
	 * @param appareils
	 * @param cartesReseaux
	 * @param firmwares
	 * @param OS
	 * @return
	 */
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
	
	/**
	 * Cree une hashMap locaux correspondant a la table locaux
	 * 
	 * @return
	 */
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
	
	/**
	 * Cree une hashMap os correspondant a la table os
	 * 
	 * @return
	 */
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
	
	/**
	 * Cree une hashMap firmware correspondant a la table firmware de la base
	 * 
	 * @return
	 */
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
	
	/**
	 * Cree une hashMap interfacesReseau correspondant a la table interfaces de la base
	 * @param firmwares
	 * @return
	 */
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
	
	
	/**
	 * Cree une hashMap salles correspondant à la table salle de la base
	 * 
	 * @param locaux
	 * @return
	 */
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
	
	public static HashMap<Integer, Appareil> lireAppareils(HashMap<Integer, Salle> salles, HashMap<Integer, SystemeExploitation> os, HashMap<Integer, InterfaceReseau> cr)
	{
		
		HashMap<Integer, Appareil> appareils= new HashMap<Integer, Appareil>();
		HashMap<Integer, Integer> relations= new HashMap<Integer, Integer>();
		try
		{
			Connection db= connexion();
			Statement s = null;
		    ResultSet r = null; 
			/* Création de l'objet gérant les requêtes */
	        s = db.createStatement();
	        /* Exécution d'une requête de lecture */
	        r = s.executeQuery( "SELECT * FROM appareil;");
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( r.next() ) 
	        {
	        	//Vérif cles etrangeres
	        	if (!os.containsKey(r.getInt("idOs")))
	        	{
	        		throw new Exception("id os "+r.getInt("idOs")+" n existe pas dans la base");
	        	}
	        	
	        	if (!cr.containsKey(r.getInt("idInterface")))
	        	{
	        		throw new Exception("id interface "+r.getInt("idInterface")+" n existe pas dans la base");
	        	}
	        	
	        	if (!salles.containsKey(r.getInt("idSalle")))
	        	{
	        		throw new Exception("idSalle "+r.getInt("idSalle")+" n existe pas dans la base");
	        	}
	        	
	        	Appareil a;
	        	//Ajout appareil dans HashAppareil
	        	if(r.getString("type")==null)
	        	//Switch
	        	{
	        		a= new Switch(r.getInt("id"), r.getString("nom"), r.getString("marque"), r.getString("modele"), r.getBoolean("etat"), os.get(r.getInt("idOs")), cr.get(r.getInt("idInterface")));
	        	}
	        	else
	        	//Terminal
	        	{
	        		a= new Terminal(r.getInt("id"), r.getString("nom"), r.getString("marque"), r.getString("modele"), r.getBoolean("etat"), os.get(r.getInt("idOs")), cr.get(r.getInt("idInterface")), (r.getString("type").equalsIgnoreCase(r.getString("type")))? Type.TABLETTE : Type.ORDINATEUR);
	        	}

	        	appareils.put(a.getIdAppareil(), a);
	        	//Ajout appareil dans HashSalles
	        	salles.get(r.getInt("idSalle")).getAppareils().add(a);
	        	relations.put(r.getInt("id"), r.getInt("idSwitch"));
	        }
	        
	        //Integres les appareils dans les switch
	        for (Integer idAppareil : relations.keySet())
	        {
	        	//Est un switch
	        	Integer idSwitch=relations.get(idAppareil);
	        	if (idSwitch!=null)
	        	{
	        		Appareil sw= appareils.get(idSwitch);
	        		if (sw instanceof Switch)
	        		{
	        			((Switch) sw).getEquipementsAppareil().add(appareils.get(idAppareil));
	        		}
	        	}
	        }
	        	
	        r.close();
	        s.close();
	        db.close();
	        
	        
		}
		catch (Exception eSQL)
		{
			eSQL.printStackTrace();
		}
		return appareils;
	}
	
	/**
	 * Lit la totalite de la base et importe dans les hashMap locaux, salles, appareils, os, interfacesReseau, firmware
	 * @param locaux
	 * @param salles
	 * @param os
	 * @param cr
	 * @param appareils
	 * @param firmwares
	 */
	public static void importBase(HashMap<Integer, Local> locaux, HashMap<Integer, Salle> salles, HashMap<Integer, SystemeExploitation> os, HashMap<Integer, InterfaceReseau> cr, HashMap<Integer, Appareil> appareils, HashMap<Integer, Firmware> firmwares)
	{
		locaux.clear();
		salles.clear();
		os.clear();
		cr.clear();
		appareils.clear();
		firmwares.clear();
		
		for(Local l: lireLocaux().values())
			locaux.put(l.getIdLocal(), l);

		for (SystemeExploitation osL : lireOs().values())
			os.put(osL.getIdOS(), osL);
		
		for (Firmware f : lireFirmwares().values())
			firmwares.put(f.getIdFirmware(), f);
		
		for(InterfaceReseau i: lireInterfaces(firmwares).values())
			cr.put(i.getAdresseMAC(), i);
		
    	for (Salle s: PostgreSQL.lireSalles(locaux).values())
    		salles.put(s.getIdSalle(), s);
    	
    	for(Appareil a : lireAppareils(salles, os, cr).values())
    		appareils.put(a.getIdAppareil(), a);
	}
}
