package com.java_s2.STRI.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import com.java_s2.STRI.modele.Local;

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
    	locaux.put(0, new Local(0, "blblblb", "blblbl"));
    	locaux.put(1, new Local(1, "local2", "toulouse"));
    	locaux.put(2, new Local(2, "local3", "paris"));
    	locaux.put(3, new Local(3, "local4", "bordeaux"));
    	
    }
}
