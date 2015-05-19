package com.java_s2.STRI.utils;

import com.java_s2.STRI.modele.AppareilTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PostgreSQLTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PostgreSQLTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PostgreSQLTest.class );
    }

}
