package com.java_s2.STRI.modele;

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
    
    
    public void testId()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
        assertEquals(0, appareil.getIdAppareil());;
    }
    
    public void testNom ()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
    	assertEquals("nom", appareil.getNomAppareil());
    }
    
    public void testMarque ()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
    	assertEquals("marque", appareil.getMarqueAppareil());
    }
    
    public void testModele ()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
    	assertEquals("modele", appareil.getModeleAppareil());
    }
    
    public void testEtat ()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
    	assertTrue(appareil.getEtatAppareil());
    }
    
    public void testOs ()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
    	assertEquals (os, appareil.getOs());
    }
    
    public void testCarteR ()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
    	assertEquals(carteR, appareil.getInterfaceReseau());
    }
    
    public void testDescativation()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
    	assertFalse(appareil.desactiver());
    }
    
    public void testReDescativation()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", false, os, carteR);
    	assertFalse(appareil.desactiver());
    }
    
    public void testActivation()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", false, os, carteR);
    	assertTrue(appareil.activer());
    }
    
    public void testReActivation()
    {
    	Appareil appareil = new Appareil (0, "nom", "marque", "modele", true, os, carteR);
    	assertTrue(appareil.activer());
    }
   
    
}
