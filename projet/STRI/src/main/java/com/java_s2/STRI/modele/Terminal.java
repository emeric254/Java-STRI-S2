package com.java_s2.STRI.modele;


/**
 * Class Terminal
 */
public class Terminal extends Appareil {

    //
    // Fields
    //
	private Type type;
    //
    // Constructors
    //
    public Terminal (int idAppareil, String nomAppareil ,String marqueAppareil, String modeleAppareil, Boolean etatAppareil, SystemeExploitation os, InterfaceReseau interfaceReseau, Type type)
    {
    	super(idAppareil,nomAppareil ,marqueAppareil,modeleAppareil,etatAppareil,os, interfaceReseau);
    	this.setType(type);
    }

  
    //
    // Methods
    //


    //
    // Accessor methods
    //
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	};

    //
    // Other methods
    //

}