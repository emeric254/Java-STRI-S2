package com.java_s2.STRI.modele;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LocalTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LocalTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LocalTest.class );
    }

    Local local= new Local(0, "nom", "lieu");
    Salle salle= new Salle(0, "nom");

    /**
     * Test
    */
    
    public void testId()
    {
    	assertEquals(0, local.getIdLocal());
    }
    
    public void testNom ()
    {
    	assertEquals("nom", local.getNomLocal());
    }

    public void testLieu ()
    {
    	assertEquals("lieu", local.getLieuLocal());
    }

}
