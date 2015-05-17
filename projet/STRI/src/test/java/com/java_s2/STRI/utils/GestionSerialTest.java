package com.java_s2.STRI.utils;

import java.util.HashMap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class GestionSerialTest extends TestCase
{
		private HashMap<Integer, Object> ensemble;
		
	    public GestionSerialTest() {
	        super();
	        ensemble = new HashMap<Integer, Object>();
	    }

	    public static Test suite() {
	        return new TestSuite( GestionSerialTest.class );
	    }

	    
	    public void testVide()
	    {
	    	assert(GestionSerial.verifExistenceSerial(ensemble.keySet(), 0));
	    }
	    
	    public void testRemplitUnElement ()
	    {
	        ensemble.put(0, "test");
	    	assert(GestionSerial.verifExistenceSerial(ensemble.keySet(), 0));
	    	assertEquals(1, GestionSerial.prochainSerial(ensemble.keySet()));
	    }
	    
	    public void testRemplitElements ()
	    {
	        ensemble.put(0, "test");
	        ensemble.put(2, "test");
	        ensemble.put(3, "test");
	        ensemble.put(4, "test");
	        ensemble.put(5, "test");
	    	
	        assert(GestionSerial.verifExistenceSerial(ensemble.keySet(), 0x2890));
	    	
	    	// car trou de serial entre 0 et le suivant
	    	assertEquals(1, GestionSerial.prochainSerial(ensemble.keySet()));
	    	
	        ensemble.put(1, "test");
	        
	    	assertEquals(6, GestionSerial.prochainSerial(ensemble.keySet()));
	    }
}
