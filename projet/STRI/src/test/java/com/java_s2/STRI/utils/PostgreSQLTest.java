package com.java_s2.STRI.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.modele.Terminal;
import com.java_s2.STRI.modele.Type;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PostgreSQLTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PostgreSQLTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PostgreSQLTest.class );
    }
    
    /**
     * Tests :-)
     */
    
    public void testConnexion ()
    {
    	try
    	{
    		Connection db = PostgreSQL.connexion();
        	assertTrue((db!=null));
        	db.close();
        	db=null;
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    		assertTrue(false);
    	}
    	
    }
    
    public void testCreerBase()
    {
    	assertTrue(PostgreSQL.creerBase());
    }
    
    public void testDetruireBase()
    {
    	assertTrue(PostgreSQL.detruireBase());
    }
    
    public void testInsertLocal()
    {
    	HashMap<Integer, Local> locaux = new HashMap<Integer, Local> ();
    	locaux.put(0, new Local(0, "local1", "BREST"));

    	try
    	{
    		PostgreSQL.creerBase();
    		Connection db= PostgreSQL.connexion();
    		PostgreSQL.ecrireLocal(db, locaux.get(0));
    		db.close();
    		assertTrue(true);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertTrue(false);
    	}
    }
    
    public void testInsertHashLocaux()
    {
    	HashMap<Integer, Local> locaux = new HashMap<Integer, Local> ();
    	locaux.put(0, new Local(0, "local1", "BREST"));
    	locaux.put(1, new Local(1, "local2", "toulouse"));
    	locaux.put(2, new Local(2, "local3", "paris"));
    	locaux.put(3, new Local(3, "local4", "bordeaux"));
    	
    	try
    	{
    		PostgreSQL.creerBase();
    		Connection db= PostgreSQL.connexion();
    		PostgreSQL.ecrireHashLocal(db, locaux);
    		db.close();
    		assertTrue(true);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertTrue(false);
    	}
    }
    
    public void testInsertOs()
    {
    	SystemeExploitation blblOS = new SystemeExploitation(3, "Cisco IOS", "1.0.0");
    	try
    	{
    		Connection db= PostgreSQL.connexion();
    		PostgreSQL.ecrireOs(db, blblOS);
    		db.close();
    		assertTrue(true);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertTrue(false);
    	}
    }
    
    public void testInsertFirmware()
    {
    	Firmware blblFW = new Firmware(3, "4.0.0", "V4 OP version");
    	try
    	{
    		Connection db= PostgreSQL.connexion();
    		PostgreSQL.ecrireFirmware(db, blblFW);
    		db.close();
    		assertTrue(true);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertTrue(false);
    	}
    }
    
    public void testInsertInterface()
    {
    	Firmware blblFW = new Firmware(3, "4.0.0", "V4 OP version");
    	InterfaceReseau i = new InterfaceReseau(0, "blbl", blblFW);
    	try
    	{
    		Connection db= PostgreSQL.connexion();
    		PostgreSQL.ecrireInterface(db, i);
    		db.close();
    		assertTrue(true);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertTrue(false);
    	}
    }
    
    public void testInsertSalle()
    {
    	Salle salle= new Salle(0, "salle1-1");
    	try
    	{
    		Connection db= PostgreSQL.connexion();
    		PostgreSQL.ecrireSalle(db, salle, 0);
    		db.close();
    		assertTrue(true);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertTrue(false);
    	}
    }
    
    public void testInsertAppareil()
    {
    	Firmware blblFW = new Firmware(3, "4.0.0", "V4 OP version");
    	SystemeExploitation blblOS = new SystemeExploitation(3, "Cisco IOS", "1.0.0");
    	HashMap<Integer, Local> locaux = new HashMap<Integer, Local> ();
    	locaux.put(0, new Local(0, "local1", "BREST"));
    	locaux.get(0).getSallesLocal().add(new Salle(0, "salle1-1"));
	   	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Terminal(0, "apareil1-1", "blbl", "blbl", true, blblOS, new InterfaceReseau(0, "blbl", blblFW), Type.TABLETTE));

	    
	   	try
    	{
    		Connection db= PostgreSQL.connexion();
    		PostgreSQL.ecrireAppareil(db,locaux.get(0).getSallesLocal().get(0).getAppareils().get(0),locaux.get(0).getSallesLocal().get(0));
    		db.close();
    		assertTrue(true);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertTrue(false);
    	}
    }
    
    public void testExportBDD()
    {
    	PostgreSQL.creerBase();
    	HashMap<Integer, Local> locaux = new HashMap<Integer, Local> ();
    	HashMap<Integer, Salle> salles = new HashMap<Integer, Salle> ();
    	HashMap<Integer, Appareil> appareils = new HashMap<Integer, Appareil> ();
    	HashMap<Integer, InterfaceReseau> cartesReseaux = new HashMap<Integer, InterfaceReseau> ();
    	HashMap<Integer, Firmware> firmwares = new HashMap<Integer, Firmware>();
    	HashMap <Integer, SystemeExploitation> OS= new HashMap<Integer, SystemeExploitation>();
    	

    	//OS
    	OS.put(3, new SystemeExploitation(3, "Cisco IOS", "1.0.0"));
    	
    	//Firmware
    	firmwares.put(3, new Firmware(3, "4.0.0", "V4 OP version"));
    	
    	//Interfaces
    	cartesReseaux.put(0, new InterfaceReseau(0, "iA", firmwares.get(3)));
    	cartesReseaux.put(1, new InterfaceReseau(1, "iB", firmwares.get(3)));
    	cartesReseaux.put(2, new InterfaceReseau(2, "iC", firmwares.get(3)));

    	//Locaux
    	locaux.put(0, new Local(0, "local1", "BREST"));
    	locaux.put(1, new Local(1, "local2", "toulouse"));
    	locaux.put(2, new Local(2, "local3", "paris"));
    	locaux.put(3, new Local(3, "local4", "bordeaux"));
    	
    	//Salles
    	locaux.get(0).getSallesLocal().add(new Salle(0, "salle1-1"));
    	locaux.get(0).getSallesLocal().add(new Salle(1, "salle1-2"));
    	locaux.get(0).getSallesLocal().add(new Salle(2, "salle1-3"));
    	locaux.get(0).getSallesLocal().add(new Salle(3, "salle1-4"));
    	locaux.get(1).getSallesLocal().add(new Salle(4, "salle2-1"));
    	locaux.get(1).getSallesLocal().add(new Salle(5, "salle2-2"));
    	locaux.get(1).getSallesLocal().add(new Salle(6, "salle2-3"));
    	locaux.get(1).getSallesLocal().add(new Salle(7, "salle2-4"));
    	locaux.get(2).getSallesLocal().add(new Salle(8, "salle3-1"));
    	locaux.get(2).getSallesLocal().add(new Salle(9, "salle3-2"));
    	locaux.get(2).getSallesLocal().add(new Salle(10, "salle3-3"));
    	locaux.get(2).getSallesLocal().add(new Salle(11, "salle3-4"));
    	locaux.get(3).getSallesLocal().add(new Salle(12, "salle4-1"));
    	locaux.get(3).getSallesLocal().add(new Salle(13, "salle4-2"));
    	locaux.get(3).getSallesLocal().add(new Salle(14, "salle4-3"));
    	
    	for (Local l: locaux.values())
    	{
    		for (Salle s : l.getSallesLocal())
    		{
    			salles.put(s.getIdSalle(), s);
    		}
    	}
    	
    	//Appareils
	   	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Terminal(0, "apareil1-1", "blbl", "blbl", true, OS.get(3), cartesReseaux.get(0), Type.TABLETTE));
	   	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Terminal(1, "apareil1-2", "blbl", "blbl", true, OS.get(3), cartesReseaux.get(1), Type.TABLETTE));
	   	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Terminal(2, "apareil1-3", "blbl", "blbl", true, OS.get(3), cartesReseaux.get(2), Type.TABLETTE));
	   	
    	assertTrue(PostgreSQL.exportBase(locaux, salles, appareils, cartesReseaux, firmwares, OS));
    }
    
    
    
//    public void testSaveBD()
//    {
//    	HashMap<Integer, Local> locaux = new HashMap<Integer, Local> ();
//    	locaux.put(0, new Local(0, "local1", "BREST"));
//    	locaux.put(1, new Local(1, "local2", "toulouse"));
//    	locaux.put(2, new Local(2, "local3", "paris"));
//    	locaux.put(3, new Local(3, "local4", "bordeaux"));
//
//    	locaux.get(0).getSallesLocal().add(new Salle(0, "salle1-1"));
//    	locaux.get(0).getSallesLocal().add(new Salle(1, "salle1-2"));
//    	locaux.get(0).getSallesLocal().add(new Salle(2, "salle1-3"));
//    	locaux.get(0).getSallesLocal().add(new Salle(3, "salle1-4"));
//    	locaux.get(1).getSallesLocal().add(new Salle(4, "salle2-1"));
//    	locaux.get(1).getSallesLocal().add(new Salle(5, "salle2-2"));
//    	locaux.get(1).getSallesLocal().add(new Salle(6, "salle2-3"));
//    	locaux.get(1).getSallesLocal().add(new Salle(7, "salle2-4"));
//    	locaux.get(2).getSallesLocal().add(new Salle(8, "salle3-1"));
//    	locaux.get(2).getSallesLocal().add(new Salle(9, "salle3-2"));
//    	locaux.get(2).getSallesLocal().add(new Salle(10, "salle3-3"));
//    	locaux.get(2).getSallesLocal().add(new Salle(11, "salle3-4"));
//    	locaux.get(3).getSallesLocal().add(new Salle(12, "salle4-1"));
//    	locaux.get(3).getSallesLocal().add(new Salle(13, "salle4-2"));
//    	locaux.get(3).getSallesLocal().add(new Salle(14, "salle4-3"));
//    	locaux.get(3).getSallesLocal().add(new Salle(15, "salle4-4"));
//    	
//    	SystemeExploitation blblOS = new SystemeExploitation(3, "Cisco IOS", "1.0.0");
//    	Firmware blblFW = new Firmware(3, "4.0.0", "V4 OP version");
//    	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Appareil(0, "apareil1-1", "blbl", "blbl", true, blblOS , new InterfaceReseau(0, "blbl", blblFW)));
//    	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Appareil(1, "apareil1-2", "blbl", "blbl", true, blblOS, new InterfaceReseau(1, "blbl", blblFW)));
//    	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Appareil(2, "apareil1-3", "blbl", "blbl", true, blblOS, new InterfaceReseau(2, "blbl", blblFW)));
//    	locaux.get(0).getSallesLocal().get(1).getAppareils().add(new Appareil(3, "apareil2-1", "blbl", "blbl", true, blblOS, new InterfaceReseau(3, "blbl", blblFW)));
//    	locaux.get(0).getSallesLocal().get(1).getAppareils().add(new Appareil(4, "apareil2-2", "blbl", "blbl", true, blblOS, new InterfaceReseau(4, "blbl", blblFW)));
//    	locaux.get(0).getSallesLocal().get(1).getAppareils().add(new Appareil(5, "apareil2-3", "blbl", "blbl", true, blblOS, new InterfaceReseau(5, "blbl", blblFW)));
//    	
//    	
//    	try
//    	{
//    		PostgreSQL.creerBase();
//        	Connection db= PostgreSQL.connexion();
//        	Integer lol= new Integer(3);
//        	long idObjet= PostgreSQL.writeJavaObject(db,  locaux);
//        	System.out.println(idObjet);
//        	db.close();
//    	}
//    	catch (Exception e)
//    	{
//    		e.printStackTrace();
//    	}  	
//    	
//       	assertTrue( true);
//    }
//    
//    public void testLireBase()
//    {
//    	try
//    	{
//    		Connection db= PostgreSQL.connexion();
//        	HashMap<Integer, Local> locaux= (HashMap<Integer, Local>) PostgreSQL.readJavaObject(db, 1);
//        	System.out.println("HASH MAP DUMP: " + locaux.toString());
//        	
//        	db.close();
//    	}
//    	catch (Exception e)
//    	{
//    		e.printStackTrace();
//    		assertTrue(false);
//    	}  	
//    	
//       	assertTrue( true);
//    }
// 
////    public void testNettoyerBase() 
////    {
////    	assertTrue(PostgreSQL.detruireBase());
////	}
////   
}
