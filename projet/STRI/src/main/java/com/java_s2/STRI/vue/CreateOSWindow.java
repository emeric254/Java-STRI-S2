package com.java_s2.STRI.vue;

import java.awt.*;

import javax.swing.*;

public class CreateOSWindow extends CreateWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nom;
	private JTextField version;
	
	
	public CreateOSWindow()
	{
		super("Création de «O/S»");
		buildContentPane();
		pack();
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void buildContentPane()
	{	
		//creation boutons
		nom = new JTextField(20);
		version = new JTextField(20);
		
		// definition contraintes du layout
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,15,10,15);
		c.gridx = 0;
		c.gridy = 0;
		getContenuPanel().add(new JLabel("nom"), c);
		c.gridx = 1;
		getContenuPanel().add(nom, c);
		
		c.gridx = 0;
		c.gridy = 1;
		getContenuPanel().add(new JLabel("version"), c);
		c.gridx = 1;
		getContenuPanel().add(version, c);
	}

	public JTextField getNomField() {
		return nom;
	}

	public JTextField getVersionField() {
		return version;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
