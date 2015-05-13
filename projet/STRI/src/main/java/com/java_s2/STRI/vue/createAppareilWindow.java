package com.java_s2.STRI.vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;

public class createAppareilWindow extends createWindow {

	private JTextField nom;
	private JTextField marque;
	private JTextField modele;
	private JCheckBox etat;
	private JComboBox<String> type;
	
	
	public createAppareilWindow()
	{
		super("Création de «Appareil»");
		buildContentPane();
		pack();
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void buildContentPane()
	{
		nom = new JTextField(20);
		marque = new JTextField(20);
		modele = new JTextField(20);
		
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
		getContenuPanel().add(new JLabel("marque"), c);
		c.gridx = 1;
		getContenuPanel().add(marque, c);
		
		c.gridx = 0;
		c.gridy = 2;
		getContenuPanel().add(new JLabel("modele"), c);
		c.gridx = 1;
		getContenuPanel().add(modele, c);

	}


	public JTextField getNomField() {
		return nom;
	}

	public JTextField getMarqueField() {
		return marque;
	}

	public JTextField getModeleField() {
		return modele;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
