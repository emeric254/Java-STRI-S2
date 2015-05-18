package com.java_s2.STRI.vue;

import java.awt.*;

import javax.swing.*;

public class CreateLocalWindow extends CreateWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nom;
	private JTextField lieu;
	
	
	public CreateLocalWindow()
	{
		super("Création de «Local»");
		buildContentPane();
		pack();
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void buildContentPane()
	{	
		//creation boutons
		nom = new JTextField(20);
		lieu = new JTextField(20);
		
		// definition contriantes du layout
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
		getContenuPanel().add(new JLabel("lieu"), c);
		c.gridx = 1;
		getContenuPanel().add(lieu, c);
	}

	public JTextField getNomField() {
		return nom;
	}

	public JTextField getLieuField() {
		return lieu;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
