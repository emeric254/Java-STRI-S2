package com.java_s2.STRI.modele;



/**
 * Class Salle
 */
public class Salle {

    //
    // Fields
    //

	private int idSalle;
	private String nomSalle;
  
    //
    // Constructors
    //
    public Salle () { };
  
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

    //
    // Other methods
    //

}