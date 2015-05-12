package com.java_s2.STRI.modele;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TerminalTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TerminalTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TerminalTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    Firmware firmware = new Firmware(0, "version", "nom");
    InterfaceReseau carteR= new InterfaceReseau(0, "nom", firmware);
    SystemeExploitation os = new SystemeExploitation(0, "nom", "version");
    Terminal terminal = new Terminal (0, "nom", "marque", "modele", true, os, carteR, Type.TABLETTE);
    
    
    public void testType ()
    {
    	assertEquals(Type.TABLETTE, terminal.getType());
    }
}
