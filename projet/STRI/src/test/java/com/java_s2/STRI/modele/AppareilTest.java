package com.java_s2.STRI.modele;

import java.util.ArrayList;

import com.java_s2.STRI.AppTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppareilTest extends TestCase 
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppareilTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppareilTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    Firmware firmware = new Firmware(0, "version", "nom");
    InterfaceReseau carteR= new InterfaceReseau(0, "nom", firmware);
    SystemeExploitation os = new SystemeExploitation(0, "nom", "version");
    Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
    
    public void testId()
    {
        assertEquals(0, appareil.getIdAppareil());;
    }
    
    public void testNom ()
    {
    	assertEquals("nom", appareil.getNomAppareil());
    }
    
    public void testMarque ()
    {
    	assertEquals("marque", appareil.getMarqueAppareil());
    }
    
    public void testModele ()
    {
    	assertEquals("modele", appareil.getModeleAppareil());
    }
    
    public void testEtat ()
    {
    	assertTrue(appareil.getEtatAppareil());
    }
    
    public void testOs ()
    {
    	assertEquals (os, appareil.getOs());
    }
    
    public void testCarteR ()
    {
    	assertEquals(carteR, appareil.getInterfaceReseau());
    }
    
    public void testDescativation()
    {
    	assertFalse(appareil.desactiver());
    }
    
    public void testActivation()
    {
    	assertTrue(appareil.activer());
    }
    
   
}
