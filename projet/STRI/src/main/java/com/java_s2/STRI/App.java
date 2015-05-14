package com.java_s2.STRI;

import com.java_s2.STRI.controller.*;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.modele.SystemeExploitation;
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
    	createFirmwareWindow fenetre = new createFirmwareWindow();
    	createFirmwareWindowEventListener listener = new createFirmwareWindowEventListener(fenetre, new Firmware(0, "", ""));
    	//*/
    	/*
    	//
    	createOSWindow fenetre = new createOSWindow();
    	createOSWindowEventListener listener = new createOSWindowEventListener(fenetre, new SystemeExploitation(0, "", ""));
    	//*/
    	/*
    	//
    	createInterfaceWindow fenetre = new createInterfaceWindow();
    	createInterfaceWindowEventListener listener = new createInterfaceWindowEventListener(fenetre, new InterfaceReseau(0, "", null));
    	//*/
    	/*
    	//
    	createAppareilWindow fenetre = new createAppareilWindow();
    	createAppareilWindowEventListener listener = new createAppareilWindowEventListener(fenetre);
    	//*/
    	/*
    	//
    	createSalleWindow fenetre = new createSalleWindow();
    	createSalleWindowEventListener listener = new createSalleWindowEventListener(fenetre, new Salle(0, ""));
    	//*/
    	/*
    	//
    	createLocalWindow fenetre = new createLocalWindow();
    	createLocalWindowEventListener listener = new createLocalWindowEventListener(fenetre, new Local(0, "", ""));
    	//*/
    	/*
        //
        mainWindow fenetre = new mainWindow();
        mainWindowEventListener controller = new mainWindowEventListener(fenetre);
        //*/
    }
}
