package com.java_s2.STRI.modele;


/**
 * Class Appareil
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


    /**
     * Get the value of modeleAppareil
     * @return the value of modeleAppareil
     */
    public String getModeleAppareil () {
    	return modeleAppareil;
    }


    /**
     * Get the value of etatAppareil
     * @return the value of etatAppareil
     */
    public boolean getEtatAppareil () {
    	return etatAppareil;
    }

	public SystemeExploitation getOs() {
		return os;
	}

	public InterfaceReseau getInterfaceReseau() {
		return interfaceReseau;
	}

	private void setInterfaceReseau(InterfaceReseau interfaceReseau) {
		this.interfaceReseau = interfaceReseau;
	}


    //
    // Other methods
    //
	
	public Boolean activer()
	{
		if (this.etatAppareil)
		{
			System.err.println(this.idAppareil+" est deja active !");
		}
		this.etatAppareil=true;
		return this.etatAppareil;
	}
	
	public Boolean desactiver()
	{
		if (!this.etatAppareil)
		{
			System.err.println(this.idAppareil+" est deja desactive !");
		}
		
		this.etatAppareil=false;
		return this.etatAppareil;
	}

}