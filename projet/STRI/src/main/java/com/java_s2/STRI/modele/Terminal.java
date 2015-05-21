package com.java_s2.STRI.modele;

import java.io.Serializable;


/**
 * Class Terminal
 */
public class Terminal extends Appareil implements  Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4823624335073421119L;
	//
    // Fields
    //
	private Type type;
    
	//
    // Constructors
    //
    /**
     * 
     * @param idAppareil
     * @param nomAppareil
     * @param marqueAppareil
     * @param modeleAppareil
     * @param etatAppareil
     * @param os
     * @param interfaceReseau
     * @param object
     */
	public Terminal (int idAppareil, String nomAppareil ,String marqueAppareil, String modeleAppareil, Boolean etatAppareil, SystemeExploitation os, InterfaceReseau interfaceReseau, Type object)
    {
    	super(idAppareil,nomAppareil ,marqueAppareil,modeleAppareil,etatAppareil,os, interfaceReseau);
    	this.setType(object);
    }

  
    //
    // Methods
    //


    //
    // Accessor methods
    //
    
    /**
     * Get the value of type
     * @return the value of type
     */
	public Type getType() {
		return type;
	}
	
	/**
	 * Set the value of type
	 * @param type the new value of type
	 */
	public void setType(Type type) {
		this.type = type;
	};
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Terminal-"+this.type.toString()+": "+super.toString());
	}

    //
    // Other methods
    //

}