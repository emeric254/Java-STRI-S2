package com.java_s2.STRI.modele;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class InterfaceReseauTest extends TestCase 
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InterfaceReseauTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( InterfaceReseauTest.class );
    }


    /**
     * Test
    */
    Firmware firmware = new Firmware(0, "version", "nom");
    InterfaceReseau carteR= new InterfaceReseau(0, "nom", firmware);
    
    public void testAddMAC ()
    {
    	assertEquals("00:00:00:00:00:00", carteR.getAdresseMAC());
    }
    
    public void testNom ()
    {
    	assertEquals("nom", carteR.getNomInterface());
    }
    
    public void testIdFirmware()
    {
    	assertEquals(0, carteR.getFirmware().getIdFirmware());
    }
    
    public void testVersionFirmware()
    {
        assertEquals("version", carteR.getFirmware().getVersionFirmware());
    }
    
    public void testNomFirmware()
    {
    	assertEquals("nom", carteR.getFirmware().getNomFirmware());
    }
    
    
}
