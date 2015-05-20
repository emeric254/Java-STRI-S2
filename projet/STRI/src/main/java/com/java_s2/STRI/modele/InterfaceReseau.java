package com.java_s2.STRI.modele;

import java.io.Serializable;



/**
 * Class Interface_réseau
 */
public class InterfaceReseau implements Serializable{

    //
    // Fields
    //

	/**
	 * 
	 */
	private static final long serialVersionUID = -1388312528274436342L;
	private int adresseMAC;
	private String nomInterface;
	private Firmware firmware;
  
    //
    // Constructors
    //
	
	/**
	 * 
	 * @param adresseMAC
	 * @param nomInterface
	 * @param firmware
	 */
    public InterfaceReseau (int adresseMAC, String nomInterface, Firmware firmware)
    {
    	this.adresseMAC= adresseMAC;
    	this.nomInterface= nomInterface;
    	this.setFirmware(firmware);
    };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of adresse_MAC
     * @param newVar the new value of adresse_MAC
     */
    public void setAdresseMAC (int newVar) {
    	this.adresseMAC = newVar;
    }

    /**
     * Get the value of adresse_MAC
     * @return the value of adresse_MAC
     */
    public int getAdresseMAC () {
    	return this.adresseMAC;
    }

    /**
     * Set the value of nomInterface
     * @param newVar the new value of nomInterface
     */
    public void setNomInterface (String newVar) {
    	nomInterface = newVar;
    }

    /**
     * Get the value of nomInterface
     * @return the value of nomInterface
     */
    public String getNomInterface () {
    	return nomInterface;
    }

    /**
     * Get the value of firmware
     * @return the value of firmware
     */
	public Firmware getFirmware() {
		return firmware;
	}

	/**
	 * Set the value of firmware
	 * @param firmware the new value of firmware 
	 */
	public void setFirmware(Firmware firmware) {
		this.firmware = firmware;
	}

    //
    // Other methods
    //

}