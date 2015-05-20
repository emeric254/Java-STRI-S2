/**
 * Procure les classes du modèle
 */
package com.java_s2.STRI.modele;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Classe de gestion d'un appareil
 * 
 * @version 1.0
 */
public class Appareil implements Serializable{

    //
    // Fields
    //
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5552327271482487504L;
	/**
	 * Entier correspondant à dentifiant d'un appareil
	 */
	private int idAppareil;
	
	/**
	 * Chaine de caractère correspondant au nom de l'appareil
	 */
	private String nomAppareil;
	
	/**
	 * Chaine de caractère correspondant au nom de l'appareil
	 */
	private String marqueAppareil;
	
	/**
	 * Chaine de caractère correspondant au modèle de l'appareil
	 */
	private String modeleAppareil;
	
	/**
	 * Booléen indiquant si l'appareil est actif ou inactif
	 */
	private boolean etatAppareil;
	
	/**
	 * Type de système d'exploitation sur l'appareil
	 */
	private SystemeExploitation os;
	
	/**
	 * Type d'interface réseau utilisé
	 */
	private InterfaceReseau interfaceReseau;
  
    //
    // Constructors
    //
	
	/**
	 * Constructeur d'un appareil
	 * 
	 *  
	 * @param idAppareil 
	 * @param nomAppareil
	 * @param marqueAppareil
	 * @param modeleAppareil
	 * @param etatAppareil
	 * @param os
	 * @param interfaceReseau
	 */
    public Appareil (int idAppareil, String nomAppareil ,String marqueAppareil, String modeleAppareil, Boolean etatAppareil, SystemeExploitation os, InterfaceReseau interfaceReseau)
    {
    	this.idAppareil= idAppareil;
    	this.nomAppareil= new String (nomAppareil);
    	this.marqueAppareil= new String (marqueAppareil);
    	this.modeleAppareil= new String (modeleAppareil);
    	this.etatAppareil= etatAppareil;
    	this.os= os;
    	this.setInterfaceReseau(interfaceReseau);
    };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //


    /**
     * Get the value of idAppareil
     * @return the value of idAppareil
     */
    public int getIdAppareil () {
    	return idAppareil;
    }
    
    public void setIdAppareil(int id) {
    	idAppareil = id;
    }

    /**
     * Set the value of nomAppareil
     * @param newVar the new value of nomAppareil
     */
    public void setNomAppareil (String newVar) {
    	nomAppareil = newVar;
    }

    /**
     * Get the value of nomAppareil
     * @return the value of nomAppareil
     */
    public String getNomAppareil () {
    	return nomAppareil;
    }

    /**
     * Get the value of marqueAppareil
     * @return the value of marqueAppareil
     */
    public String getMarqueAppareil () {
    	return marqueAppareil;
    }

    public void setMarqueAppareil (String marque) {
    	marqueAppareil = marque;
    }

    /**
     * Get the value of modeleAppareil
     * @return the value of modeleAppareil
     */
    public String getModeleAppareil () {
    	return modeleAppareil;
    }

    public void setModeleAppareil (String modele) {
    	modeleAppareil = modele;
    }

    /**
     * Get the value of etatAppareil
     * @return the value of etatAppareil
     */
    public boolean getEtatAppareil () {
    	return etatAppareil;
    }
	
	/**
	 * 
	 * @return
	 */
	public Boolean activer()
	{
		/*
		if (this.etatAppareil)
		{
			System.err.println(this.idAppareil+" est deja active !");
		}
		*/
		this.etatAppareil=true;
		return this.etatAppareil;
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean desactiver()
	{
		/*
		if (!this.etatAppareil)
		{
			System.err.println(this.idAppareil+" est deja desactive !");
		}
		*/
		this.etatAppareil=false;
		return this.etatAppareil;
	}

    /**
     * Get the value of os
     * @return the value of os
     */
	public SystemeExploitation getOs() {
		return os;
	}
    public void setOs (SystemeExploitation pOs) {
    	os = pOs;
    }

	/**
	 * Get the value of interfaceReseau
	 * @return the value of interfaceReseau
	 */
	public InterfaceReseau getInterfaceReseau() {
		return interfaceReseau;
	}

	/**
	 * Set the value of interfaceReseau
	 * @param interfaceReseau the new value of interfaceReseau
	 */
	private void setInterfaceReseau(InterfaceReseau interfaceReseau) {
		this.interfaceReseau = interfaceReseau;
	}


    //
    // Other methods
    //

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Appareil> dependances() throws Exception
	{
		if (!(this instanceof Switch))
		{
			throw new Exception ("Appareil "+this.idAppareil+" n'est pas un switch, pas de dépendances !");
		}
		return null;
	}
}