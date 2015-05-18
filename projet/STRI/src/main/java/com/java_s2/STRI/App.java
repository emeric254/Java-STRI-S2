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
    	/**/
        //
        new MainWindowEventListener(new MainWindow(), locaux, salles, appareils, cartesReseaux);
        //*/
    }
}
