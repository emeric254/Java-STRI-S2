package com.java_s2.STRI.utils;

import java.util.HashMap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class GestionMACTest extends TestCase
{
		private HashMap<Integer, Object> ensemble;
		
	    public GestionMACTest() {
	        super();
	        ensemble = new HashMap<Integer, Object>();
	    }

	    public static Test suite() {
	        return new TestSuite( GestionMACTest.class );
	    }

	    
	    public void testVide()
	    {
	    	assert(GestionMAC.verifExistenceMAC(ensemble, 0));
	    }
	    
	    public void testRemplitUnElement ()
	    {
	        ensemble.put(0, "test");
	    	assert(GestionMAC.verifExistenceMAC(ensemble, 0));
	    	assertEquals("000000000000", GestionMAC.addrMACString(0));
	    	assertEquals(1, GestionMAC.prochainMAC(ensemble));
	    }
	    
	    public void testRemplitElements ()
	    {
	        ensemble.put(0, "test");
	        ensemble.put(2, "test");
	        ensemble.put(3, "test");
	        ensemble.put(4, "test");
	        ensemble.put(5, "test");
	        ensemble.put(10, "test");
	        ensemble.put(0x2890, "test");
	    	
	        assert(GestionMAC.verifExistenceMAC(ensemble, 0x2890));
	    	
	    	assertEquals("000000002890", GestionMAC.addrMACString(0x2890));
	    	
	    	// car trou de serial entre 0 et le suivant
	    	assertEquals(1, GestionMAC.prochainMAC(ensemble));
	    	
	        ensemble.put(1, "test");
	        
	    	assertEquals(6, GestionMAC.prochainMAC(ensemble));
	    }
}
