package com.java_s2.STRI.modele;

import java.io.Serializable;
import java.util.ArrayList;



/**
 * Class Salle
 */
public class Salle implements Serializable{

    //
    // Fields
    //

	/**
	 * 
	 */
	private static final long serialVersionUID = 4330676516910901321L;
	private int idSalle;
	private String nomSalle;
	private ArrayList<Appareil> appareils;
  
    //
    // Constructors
    //
	
	/**
	 * 
	 * @param idSalle
	 * @param nomSalle
	 */
    public Salle (int idSalle, String nomSalle)
    {
    	this.idSalle= idSalle;
    	this.nomSalle= new String (nomSalle);
    	this.setAppareils(new ArrayList<Appareil>());
    };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of idSalle
     * @param newVar the new value of idSalle
     */
    public void setIdSalle (int newVar) {
    	idSalle = newVar;
    }

    /**
     * Get the value of idSalle
     * @return the value of idSalle
     */
    public int getIdSalle () {
    	return idSalle;
    }

    /**
     * Set the value of nomSalle
     * @param newVar the new value of nomSalle
     */
    public void setNomSalle (String newVar) {
    	nomSalle = newVar;
    }

    /**
     * Get the value of nomSalle
     * @return the value of nomSalle
     */
    public String getNomSalle () {
    	return nomSalle;
    }

    /**
     * 
     * @return
     */
	public ArrayList<Appareil> getAppareils() {
		return appareils;
	}

	/**
	 * 
	 * @param appareils
	 */
	public void setAppareils(ArrayList<Appareil> appareils) {
		this.appareils = appareils;
	}

    //
    // Other methods
    //
	
	/**
	 * 
	 * @param appareil
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Appareil> ajouterAppareil (Appareil appareil) throws Exception
	{
		for (Appareil var : this.appareils)
		{
			if (var.getIdAppareil()== appareil.getIdAppareil() || var.getInterfaceReseau().getAdresseMAC()==appareil.getInterfaceReseau().getAdresseMAC())
			{
				throw new Exception ("L'appareil "+appareil.getNomAppareil()+" "+appareil.getInterfaceReseau().getAdresseMAC()+" est déja dans la salle!");
			}
		}
		
		this.appareils.add(appareil);
		return this.appareils;
	}

}