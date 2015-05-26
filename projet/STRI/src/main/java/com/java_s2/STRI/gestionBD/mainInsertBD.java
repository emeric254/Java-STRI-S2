/**
 * 
 */
package com.java_s2.STRI.gestionBD;

import java.util.HashMap;

import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.modele.Terminal;
import com.java_s2.STRI.modele.Type;
import com.java_s2.STRI.utils.PostgreSQL;

/**
 * @author robin
 *
 */
public class mainInsertBD {

	/**
	 * Insere le jeu de données dans la base de donnees
	 * @param args
	 */
	public static void main(String[] args) 
	{
		PostgreSQL.creerBase();
    	HashMap<Integer, Local> locaux = new HashMap<Integer, Local> ();
    	HashMap<Integer, Salle> salles = new HashMap<Integer, Salle> ();
    	HashMap<Integer, Appareil> appareils = new HashMap<Integer, Appareil> ();
    	HashMap<Integer, InterfaceReseau> cartesReseaux = new HashMap<Integer, InterfaceReseau> ();
    	HashMap<Integer, Firmware> firmwares = new HashMap<Integer, Firmware>();
    	HashMap <Integer, SystemeExploitation> OS= new HashMap<Integer, SystemeExploitation>();
    	

    	//OS
    	OS.put(0, new SystemeExploitation(0, "Windows", "7"));
    	OS.put(1, new SystemeExploitation(1, "Windows", "8"));
    	OS.put(2, new SystemeExploitation(2, "Android", "11 Lolipop"));
    	OS.put(3, new SystemeExploitation(3, "Cisco IOS", "1.0.0"));
    	
    	//Firmware
    	firmwares.put(0, new Firmware(0, "4.0.0", "V4 OP version"));
    	
    	//Interfaces
    	cartesReseaux.put(0, new InterfaceReseau(0, "iA", firmwares.get(0)));
    	cartesReseaux.put(1, new InterfaceReseau(1, "iB", firmwares.get(0)));
    	cartesReseaux.put(2, new InterfaceReseau(2, "iC", firmwares.get(0)));

    	//Locaux
    	locaux.put(0, new Local(0, "local1", "BREST"));
    	locaux.put(1, new Local(1, "local2", "toulouse"));
    	locaux.put(2, new Local(2, "local3", "paris"));
    	locaux.put(3, new Local(3, "local4", "bordeaux"));
    	
    	//Salles
    	locaux.get(0).getSallesLocal().add(new Salle(0, "salle1-1"));
    	locaux.get(0).getSallesLocal().add(new Salle(1, "salle1-2"));
    	locaux.get(0).getSallesLocal().add(new Salle(2, "salle1-3"));
    	locaux.get(0).getSallesLocal().add(new Salle(3, "salle1-4"));
    	locaux.get(1).getSallesLocal().add(new Salle(4, "salle2-1"));
    	locaux.get(1).getSallesLocal().add(new Salle(5, "salle2-2"));
    	locaux.get(1).getSallesLocal().add(new Salle(6, "salle2-3"));
    	locaux.get(1).getSallesLocal().add(new Salle(7, "salle2-4"));
    	locaux.get(2).getSallesLocal().add(new Salle(8, "salle3-1"));
    	locaux.get(2).getSallesLocal().add(new Salle(9, "salle3-2"));
    	locaux.get(2).getSallesLocal().add(new Salle(10, "salle3-3"));
    	locaux.get(2).getSallesLocal().add(new Salle(11, "salle3-4"));
    	locaux.get(3).getSallesLocal().add(new Salle(12, "salle4-1"));
    	locaux.get(3).getSallesLocal().add(new Salle(13, "salle4-2"));
    	locaux.get(3).getSallesLocal().add(new Salle(14, "salle4-3"));
    	
    	for (Local l: locaux.values())
    	{
    		for (Salle s : l.getSallesLocal())
    		{
    			salles.put(s.getIdSalle(), s);
    		}
    	}
    	
    	//Appareils
	   	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Terminal(0, "Tablette Maurice", "Samsung", "Galaxy", true, OS.get(2), cartesReseaux.get(0), Type.TABLETTE));
	   	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Terminal(1, "Tour bureau 10", "Dell", "Inspiron", true, OS.get(0), cartesReseaux.get(1), Type.ORDINATEUR));
	   	locaux.get(0).getSallesLocal().get(0).getAppareils().add(new Terminal(2, "Tablette Alfred", "Asus", "Nexus", true, OS.get(1), cartesReseaux.get(2), Type.TABLETTE));
	   	
    	PostgreSQL.exportBase(locaux, salles, appareils, cartesReseaux, firmwares, OS);
	}

}
