package com.java_s2.STRI.modele;



/**
 * Class Interface_réseau
 */
public class InterfaceReseau {

    //
    // Fields
    //

	private int adresseMAC;
	private String nomInterface;
	private Firmware firmware;
  
    //
    // Constructors
    //
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
    public void setAdresse_MAC (int newVar) {
    	this.adresseMAC = newVar;
    }

    /**
     * Get the value of adresse_MAC
     * @return the value of adresse_MAC
     */
    public int getAdresse_MAC () {
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

	public Firmware getFirmware() {
		return firmware;
	}

	public void setFirmware(Firmware firmware) {
		this.firmware = firmware;
	}

    //
    // Other methods
    //

}