package com.java_s2.STRI.modele;



/**
 * Class Firmware
 */
public class Firmware {

    //
    // Fields
    //

	private int idFirmware;
	private String versionFirmware;
	private String nomFirmware;
  
    //
    // Constructors
    //
    public Firmware (int idFirmware, String versionFirmware, String nomFirmware)
    {
    	this.idFirmware= idFirmware;
    	this.versionFirmware= versionFirmware;
    	this.nomFirmware= nomFirmware;
    };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of idFirmware
     * @param newVar the new value of idFirmware
     */
    public void setIdFirmware (int newVar) {
    	idFirmware = newVar;
    }

    /**
     * Get the value of idFirmware
     * @return the value of idFirmware
     */
    public int getIdFirmware () {
    	return idFirmware;
    }

    /**
     * Set the value of versionFirmware
     * @param newVar the new value of versionFirmware
     */
    public void setVersionFirmware (String newVar) {
    	versionFirmware = newVar;
    }

    /**
     * Get the value of versionFirmware
     * @return the value of versionFirmware
     */
    public String getVersionFirmware () {
    	return versionFirmware;
    }

    /**
     * Set the value of nomFirmware
     * @param newVar the new value of nomFirmware
     */
    public void setNomFirmware (String newVar) {
    	nomFirmware = newVar;
    }

    /**
     * Get the value of nomFirmware
     * @return the value of nomFirmware
     */
    public String getNomFirmware () {
    	return nomFirmware;
    }

    //
    // Other methods
    //

}