package com.java_s2.STRI.modele;



/**
 * Class Local
 */
public class Local {

    //
    // Fields
    //

  private int idLocal;
  private String nomLocal;
  private String lieuLocal;
  
    //
    // Constructors
    //
    public Local () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of idLocal
     * @param newVar the new value of idLocal
     */
    public void setIdLocal (int newVar) {
      idLocal = newVar;
  }

    /**
     * Get the value of idLocal
     * @return the value of idLocal
     */
  public int getIdLocal () {
      return idLocal;
  }

    /**
     * Set the value of nomLocal
     * @param newVar the new value of nomLocal
     */
  public void setNomLocal (String newVar) {
      nomLocal = newVar;
  }

    /**
     * Get the value of nomLocal
     * @return the value of nomLocal
     */
  public String getNomLocal () {
      return nomLocal;
  }

    /**
     * Set the value of lieuLocal
     * @param newVar the new value of lieuLocal
     */
  public void setLieuLocal (String newVar) {
      lieuLocal = newVar;
  }

    /**
     * Get the value of lieuLocal
     * @return the value of lieuLocal
     */
  public String getLieuLocal () {
      return lieuLocal;
  }

    //
    // Other methods
    //

}