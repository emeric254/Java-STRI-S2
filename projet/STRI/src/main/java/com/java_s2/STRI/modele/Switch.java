package com.java_s2.STRI.modele;

import java.util.ArrayList;



/**
 * Class Switch
 */
public class Switch extends Appareil {

    //
    // Fields
    //
	private ArrayList<Appareil> equipements;
  
    //
    // Constructors
    //
    public Switch (int idAppareil, String nomAppareil ,String marqueAppareil, String modeleAppareil, Boolean etatAppareil, SystemeExploitation os, Type type, InterfaceReseau interfaceReseau) 
    { 
    	super(idAppareil,nomAppareil ,marqueAppareil,modeleAppareil,etatAppareil,os, interfaceReseau);
    	this.equipements= new ArrayList<Appareil>();
    }

	public ArrayList<Appareil> getEquipements() {
		return equipements;
	}
	
    //
    // Methods
    //


    //
    // Accessor methods
    //

    //
    // Other methods
    //

}