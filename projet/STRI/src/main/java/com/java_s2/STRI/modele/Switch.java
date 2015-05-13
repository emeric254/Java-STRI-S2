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
    public Switch (int idAppareil, String nomAppareil ,String marqueAppareil, String modeleAppareil, Boolean etatAppareil, SystemeExploitation os, InterfaceReseau interfaceReseau) 
    { 
    	super(idAppareil,nomAppareil ,marqueAppareil,modeleAppareil,etatAppareil,os, interfaceReseau);
    	this.equipements= new ArrayList<Appareil>();
    }
	
    //
    // Methods
    //


    //
    // Accessor methods
    //
    public ArrayList<Appareil> getEquipementsAppareil()
    {
    	return this.equipements;
    }
    
    //
    // Other methods
    //
    public ArrayList<Appareil> connecter(Appareil appareil) throws Exception 
	{
		for (Appareil var : this.equipements)
		{
			if (var.getIdAppareil()== appareil.getIdAppareil() || var.getInterfaceReseau().getAdresseMAC()==appareil.getInterfaceReseau().getAdresseMAC())
			{
				throw new Exception ("L'appareil est déja dans le switch !");
			}
		}
		
		this.equipements.add(appareil);
		return equipements;
	}
    
    public ArrayList<Appareil> dependences()
    {
    	ArrayList<Appareil> dependances= (ArrayList<Appareil>) this.equipements.clone();
    	return dependances;
    }
}