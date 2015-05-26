package com.java_s2.STRI.modele;

import java.io.Serializable;
import java.util.ArrayList;



/**
 * Class Switch
 */
public class Switch extends Appareil implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4070392465341409181L;
	//
    // Fields
    //
	private ArrayList<Appareil> equipements;
  
    //
    // Constructors
    //
	/**
	 * Constructeur de la classe switch 
	 * 
	 * @param idAppareil
	 * @param nomAppareil
	 * @param marqueAppareil
	 * @param modeleAppareil
	 * @param etatAppareil
	 * @param os
	 * @param interfaceReseau
	 */
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
    
    /**
     * Retourne la liste des appareils connectés à ce switch
     * @return
     */
    public ArrayList<Appareil> getEquipementsAppareil()
    {
    	return this.equipements;
    }
    
    //
    // Other methods
    //
    
    /**
     * Retourne la liste des appareils connectes au switch
     * @param appareil
     * @return
     * @throws Exception
     */
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
    
    /**
     * Retourne la liste des appareils qui sont dependants du switch (fork de la vraie liste)
     * @return
     */
    public ArrayList<Appareil> dependences()
    {
		@SuppressWarnings("unchecked")
		ArrayList<Appareil> dependances= (ArrayList<Appareil>) (this.equipements.clone());
    	return dependances;
    }
    
    /* (non-Javadoc)
     * @see com.java_s2.STRI.modele.Appareil#toString()
     */
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return ("Switch:"+super.toString());
    }
}