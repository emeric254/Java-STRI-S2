package com.java_s2.STRI.modele;

import java.util.ArrayList;



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
	private ArrayList<Salle> salles;
  
    //
    // Constructors
    //
	
	/**
	 * 
	 * @param idLocal
	 * @param nomLocal
	 * @param lieuLocal
	 */
    public Local(int idLocal, String nomLocal, String lieuLocal)
    {
    	this.idLocal= idLocal;
    	this.nomLocal= new String (nomLocal);
    	this.lieuLocal= new String (lieuLocal);
    };
  
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
    public void setSallesLocal (ArrayList<Salle> newVar) {
    	salles = newVar;
    }

    /**
     * Get the value of idLocal
     * @return the value of idLocal
     */
    public ArrayList<Salle> getSallesLocal () {
    	return salles;
    }

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
    
    /**
     * 
     * @return
     */
    private int newIdSalle()
    {
    	int id=1;
    	for (Salle salle : this.salles)
    	{
    		if (salle.getIdSalle()>=id)
    		{
    			id= salle.getIdSalle();
    		}
    	}
    	return (++id);
    }
    
    /**
     * 
     * @param salle2
     * @return
     */
    public Boolean ajouterSalle (Salle salle) 
    {
    	return this.salles.add(salle);
    }

}