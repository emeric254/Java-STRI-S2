package com.java_s2.STRI.modele;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FirmwareTest extends TestCase 
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FirmwareTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FirmwareTest.class );
    }

    /**
     * Test
     */
    Firmware firmware = new Firmware(0, "version", "nom");
    
    public void testId()
    {
    	assertEquals(0, firmware.getIdFirmware());
    }
    
    public void testVersion()
    {
        assertEquals("version", firmware.getVersionFirmware());
    }
    
    public void testNom()
    {
    	assertEquals("nom", firmware.getNomFirmware());
    }
}
