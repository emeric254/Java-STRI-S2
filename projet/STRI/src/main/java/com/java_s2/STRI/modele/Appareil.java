
package com.java_s2.STRI.modele;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;


/**
 * Class Appareil
 * 
 * @version 1.0
 */
public class Appareil {

    //
    // Fields
    //
	
	private int idAppareil;
	private String nomAppareil;
	private String marqueAppareil;
	private String modeleAppareil;
	private boolean etatAppareil;
	private SystemeExploitation os;
	private InterfaceReseau interfaceReseau;
  
    //
    // Constructors
    //
	
	/**
	 * Constructor Appareil
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