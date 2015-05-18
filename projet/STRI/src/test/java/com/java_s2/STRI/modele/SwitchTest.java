package com.java_s2.STRI.modele;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SwitchTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SwitchTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SwitchTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    Firmware firmware = new Firmware(0, "version", "nom");
    InterfaceReseau carteR= new InterfaceReseau(0, "nom", firmware);
    SystemeExploitation os = new SystemeExploitation(0, "nom", "version");

    
    public void testNbOrdis()
    {
        Switch switch0 = new Switch (0, "nom", "marque", "modele", true, os, carteR);
    	assertEquals(0, switch0.getEquipementsAppareil().size());
    }
    
    public void testAjout()
    {	
        Switch switch0 = new Switch (0, "nom", "marque", "modele", true, os, carteR);
        Terminal terminal = new Terminal (0, "nom", "marque", "modele", true, os, carteR, Type.TABLETTE);
    	try
    	{
    		switch0.connecter(terminal);
    	}
    	catch (Exception e)
    	{
    		assertTrue(false);
    	}
    	assertEquals(1, switch0.getEquipementsAppareil().size());
	}
    
    public void testDoulon()
    {
        Switch switch0 = new Switch (0, "nom", "marque", "modele", true, os, carteR);
        Terminal terminal = new Terminal (0, "nom", "marque", "modele", true, os, carteR, Type.TABLETTE);
    	Boolean retour=false;
    	try
    	{
    		switch0.connecter(terminal);
    		switch0.connecter(terminal);
    	}
    	catch (Exception e)
    	{
    		System.err.println(e.getMessage());
    		retour=true;
    	}
    	assertTrue(retour);
    }

    public void testDependances()
    {
    	Switch switch0 = new Switch (0, "nom", "marque", "modele", true, os, carteR);
        Terminal terminal = new Terminal (0, "nom", "marque", "modele", true, os, carteR, Type.ORDINATEUR);
    	/*Boolean retour=false;*/
    	try
    	{
    		switch0.connecter(terminal);
    	}
    	catch (Exception e)
    	{
    		System.err.println(e.getMessage());
    		assertTrue(false);
    	}
    	
    	ArrayList<Appareil> dependances= switch0.dependences();
    	assertEquals(1, dependances.size());
    }
}
