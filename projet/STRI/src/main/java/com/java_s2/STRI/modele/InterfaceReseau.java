package com.java_s2.STRI.modele;



/**
 * Class Interface_réseau
 */
public class InterfaceReseau {

    //
    // Fields
    //

	private String adresse_MAC;
	private String nomInterface;
	private Firmware firmware;
  
    //
    // Constructors
    //
    public InterfaceReseau (String adresse_MAC, String nomInterface, Firmware firmware)
    {
    	this.adresse_MAC= adresse_MAC;
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
    public void setAdresse_MAC (String newVar) {
    	adresse_MAC = newVar;
    }

    /**
     * Get the value of adresse_MAC
     * @return the value of adresse_MAC
     */
    public String getAdresse_MAC () {
    	return adresse_MAC;
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