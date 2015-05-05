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
  
    //
    // Constructors
    //
    public Appareil () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of idAppareil
     * @param newVar the new value of idAppareil
     */
    public void setIdAppareil (int newVar) {
      idAppareil = newVar;
  }

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
     * Set the value of marqueAppareil
     * @param newVar the new value of marqueAppareil
     */
    public void setMarqueAppareil (String newVar) {
      marqueAppareil = newVar;
  }

    /**
     * Get the value of marqueAppareil
     * @return the value of marqueAppareil
     */
    public String getMarqueAppareil () {
	  return marqueAppareil;
  }

    /**
     * Set the value of modeleAppareil
     * @param newVar the new value of modeleAppareil
     */
    public void setModeleAppareil (String newVar) {
      modeleAppareil = newVar;
  }

    /**
     * Get the value of modeleAppareil
     * @return the value of modeleAppareil
     */
    public String getModeleAppareil () {
      return modeleAppareil;
  }

    /**
     * Set the value of etatAppareil
     * @param newVar the new value of etatAppareil
     */
    public void setEtatAppareil (boolean newVar) {
      etatAppareil = newVar;
  }

    /**
     * Get the value of etatAppareil
     * @return the value of etatAppareil
     */
    public boolean getEtatAppareil () {
      return etatAppareil;
  }

    //
    // Other methods
    //

}