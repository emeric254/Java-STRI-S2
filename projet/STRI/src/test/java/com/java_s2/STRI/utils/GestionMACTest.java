package com.java_s2.STRI.utils;

import java.util.HashMap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class GestionMACTest extends TestCase
{
		
	    public GestionMACTest() {
	        super();
	    }

	    public static Test suite() {
	        return new TestSuite( GestionMACTest.class );
	    }

	    
	    public void testVide()
	    {
	    	assertFalse(GestionMAC.verifExistenceMAC((new HashMap<Integer, Object>()).keySet(), 0));
	    }
	    
	    public void testRemplitUnElement ()
	    {
	    	HashMap<Integer, Object> ensemble = new HashMap<Integer, Object>();
	        ensemble.put(0, "test");
	    	assertTrue(GestionMAC.verifExistenceMAC(ensemble.keySet(), 0));
	    	assertEquals("00:00:00:00:00:00", GestionMAC.addrMACString(0));
	    	assertEquals(1, GestionMAC.prochainMAC(ensemble.keySet()));
	    }
	    
	    public void testRemplitElements ()
	    {
	    	HashMap<Integer, Object> ensemble = new HashMap<Integer, Object>();
	        ensemble.put(0, "test");
	        ensemble.put(2, "test");
	        ensemble.put(3, "test");
	        ensemble.put(4, "test");
	        ensemble.put(5, "test");
	        ensemble.put(10, "test");
	        ensemble.put(0x2890, "test");
	    	
	        assertTrue(GestionMAC.verifExistenceMAC(ensemble.keySet(), 0x2890));
	    	
	    	assertEquals("00:00:00:00:28:90", GestionMAC.addrMACString(0x2890));
	    	
	    	// car trou de serial entre 0 et le suivant
	    	assertEquals(1, GestionMAC.prochainMAC(ensemble.keySet()));
	    	
	        ensemble.put(1, "test");
	        
	    	assertEquals(6, GestionMAC.prochainMAC(ensemble.keySet()));
	    }
}
