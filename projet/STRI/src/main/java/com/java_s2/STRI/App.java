package com.java_s2.STRI;

import java.util.*;

import com.java_s2.STRI.controller.*;
import com.java_s2.STRI.modele.*;
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
    	
    	HashMap<Integer, Firmware> firmwares = new HashMap<Integer, Firmware>();
    	firmwares.put(0, new Firmware(0, "1.0.0", "origin"));
    	firmwares.put(1, new Firmware(1, "1.9.9", "beta 2"));
    	firmwares.put(2, new Firmware(2, "3.0.0", "v3 car 2 gros echec"));
    	firmwares.put(3, new Firmware(3, "4.0.0", "full la fete, ca tue"));
    	
    	
    	HashMap <Integer, SystemeExploitation> OS= new HashMap<Integer, SystemeExploitation>();
    	OS.put(0, new SystemeExploitation(0, "Microsoft Windows", "XP"));
    	OS.put(1, new SystemeExploitation(1, "Microsoft Windows", "7"));
    	OS.put(2, new SystemeExploitation(2, "Microsoft Windows", "8"));
    	OS.put(3, new SystemeExploitation(3, "Cisco IOS", "1.0.0"));
    	OS.put(4, new SystemeExploitation(4, "Debian Weezie", "7.8.0"));
    	OS.put(5, new SystemeExploitation(5, "Debian Jessie", "8.0.0"));
    	/**/
        //
        new MainWindowEventListener(new MainWindow(), locaux, salles, appareils, cartesReseaux);
        //*/
    }
}
