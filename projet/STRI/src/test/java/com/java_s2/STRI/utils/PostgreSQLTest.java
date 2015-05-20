package com.java_s2.STRI.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.modele.SystemeExploitation;

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
    
    public void testSaveBD()
    {
    	HashMap<Integer, Local> locaux = new HashMap<Integer, Local> ();
    	locaux.put(0, new Local(0, "local1", "BREST"));
    	locaux.put(1, new Local(1, "local2", "toulouse"));
    	locaux.put(2, new Local(2, "local3", "paris"));
    	locaux.put(3, new Local(3, "local4", "bordeaux"));

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
    	locaux.get(3).getSallesLocal().add(new Salle(15, "salle4-4"));
    	
    	SystemeExploitation blblOS = new SystemeExploitation(3, "Cisco IOS", "1.0.0");
    	Firmware blblFW = new Firmware(3, "4.0.0", "V4 OP version");
    	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Appareil(0, "apareil1-1", "blbl", "blbl", true, blblOS , new InterfaceReseau(0, "blbl", blblFW)));
    	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Appareil(1, "apareil1-2", "blbl", "blbl", true, blblOS, new InterfaceReseau(1, "blbl", blblFW)));
    	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Appareil(2, "apareil1-3", "blbl", "blbl", true, blblOS, new InterfaceReseau(2, "blbl", blblFW)));
    	locaux.get(0).getSallesLocal().get(1).getAppareils().add(new Appareil(3, "apareil2-1", "blbl", "blbl", true, blblOS, new InterfaceReseau(3, "blbl", blblFW)));
    	locaux.get(0).getSallesLocal().get(1).getAppareils().add(new Appareil(4, "apareil2-2", "blbl", "blbl", true, blblOS, new InterfaceReseau(4, "blbl", blblFW)));
    	locaux.get(0).getSallesLocal().get(1).getAppareils().add(new Appareil(5, "apareil2-3", "blbl", "blbl", true, blblOS, new InterfaceReseau(5, "blbl", blblFW)));
    }
}
