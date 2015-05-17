package com.java_s2.STRI;

import java.util.HashMap;

import com.java_s2.STRI.controller.*;
import com.java_s2.STRI.modele.Appareil;
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
    	/* ensembles d'objets (comme en bd) */
    	HashMap<Integer, Local> locaux = new HashMap<Integer, Local> ();
    	HashMap<Integer, Salle> salles = new HashMap<Integer, Salle> ();
    	HashMap<Integer, Appareil> appareils = new HashMap<Integer, Appareil> ();
    	HashMap<Integer, InterfaceReseau> cartesReseaux = new HashMap<Integer, InterfaceReseau> ();
    	
    	/*
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
    	CreateAppareilWindow fenetre = new CreateAppareilWindow();
    	CreateAppareilWindowEventListener listener = new CreateAppareilWindowEventListener(fenetre, new Appareil(0, "", "", "", false, null, null));
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
    	/**/
        //
        MainWindow fenetre = new MainWindow();
        MainWindowEventListener controller = new MainWindowEventListener(fenetre, locaux, salles, appareils, cartesReseaux);
        //*/
    }
}
