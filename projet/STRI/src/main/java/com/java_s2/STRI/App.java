package com.java_s2.STRI;

import com.java_s2.STRI.controller.*;
import com.java_s2.STRI.vue.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/**/
    	//
    	createAppareilWindow fenetre = new createAppareilWindow();
    	createAppareilWindowEventListener listener = new createAppareilWindowEventListener(fenetre);
    	//*/
    	/*
    	//
    	createAppareilWindow fenetre = new createAppareilWindow();
    	createAppareilWindowEventListener listener = new createAppareilWindowEventListener(fenetre);
    	//*/
    	/*
    	//
    	createSalleWindow fenetre = new createSalleWindow();
    	createSalleWindowEventListener listener = new createSalleWindowEventListener(fenetre);
    	//*/
    	/*
    	//
    	createLocalWindow fenetre = new createLocalWindow();
    	createLocalWindowEventListener listener = new createLocalWindowEventListener(fenetre);
    	//*/
    	/*
        //
        mainWindow fenetre = new mainWindow();
        mainWindowEventListener controller = new mainWindowEventListener(fenetre);
        //*/
    }
}
