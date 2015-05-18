package com.java_s2.STRI.modele;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SalleTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SalleTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SalleTest.class );
    }

   
    Firmware firmware = new Firmware(0, "version", "nom");
    InterfaceReseau carteR= new InterfaceReseau(0, "nom", firmware);
    InterfaceReseau carteR2= new InterfaceReseau(1, "nom", firmware);
    SystemeExploitation os = new SystemeExploitation(0, "nom", "version");

    /**
     * Test
    */
    
    public void testId ()
    {
    	Salle salle= new Salle(0, "nom");
    	assertEquals(0, salle.getIdSalle());
    }
    
    public void testNom()
    {
    	Salle salle= new Salle(0, "nom");
    	assertEquals("nom", salle.getNomSalle());
    }
    
    public void testListeVide()
    {
    	Salle salle= new Salle(0, "nom");
    	assertEquals(0, salle.getAppareils().size());
    }
    
    public void testAjoutAppareil()
    {
    	/*Switch switch0 = */new Switch (0, "nom", "marque", "modele", true, os, carteR);
        Terminal terminal = new Terminal (0, "nom", "marque", "modele", true, os, carteR, Type.TABLETTE);
        Salle salle= new Salle(0, "nom");
        
        try
        {
        	salle.ajouterAppareil(terminal);
        }
        catch (Exception e)
        {
        	System.err.println(e.getMessage());
        	assertTrue(false);
        }
        
        assertTrue(true);
    }
    
    public void testAjoutAppareilNb()
    {
    	/*Switch switch0 = */new Switch (0, "nom", "marque", "modele", true, os, carteR);
        Terminal terminal = new Terminal (0, "nom", "marque", "modele", true, os, carteR, Type.TABLETTE);
        Salle salle= new Salle(0, "nom");
        
        try
        {
        	salle.ajouterAppareil(terminal);
        }
        catch (Exception e)
        {
        	System.err.println(e.getMessage());
        	assertTrue(false);
        }
        
        assertEquals(1, salle.getAppareils().size());
    }
    
    public void testDoubleInsert()
    {
    	Switch switch0 = new Switch (0, "switch", "marque", "modele", true, os, carteR);
        Terminal terminal = new Terminal (1, "terminal", "marque", "modele", true, os, carteR2, Type.TABLETTE);
        Salle salle= new Salle(0, "nom");
        
        try
        {
        	salle.ajouterAppareil(terminal);
        	salle.ajouterAppareil(switch0);
        }
        catch (Exception e)
        {
        	System.err.println(e.getMessage());
        	assertTrue(false);
        }
        
        assertEquals(2, salle.getAppareils().size());
    }
    
    public void testDoublon()
    {
    	Boolean retour= false;
        Terminal terminal = new Terminal (0, "nom", "marque", "modele", true, os, carteR, Type.TABLETTE);
        Salle salle= new Salle(0, "nom");
        
        try
        {
        	salle.ajouterAppareil(terminal);
        	salle.ajouterAppareil(terminal);
        }
        catch (Exception e)
        {
        	System.err.println("TestDoublon: "+e.getMessage());
        	retour=true;
        }
        
        assertTrue(retour);
    }
}
