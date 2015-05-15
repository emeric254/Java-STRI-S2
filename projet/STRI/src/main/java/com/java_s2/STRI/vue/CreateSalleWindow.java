package com.java_s2.STRI.vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;

public class CreateSalleWindow extends CreateWindow {

	private JTextField nom;
	
	
	public CreateSalleWindow()
	{
		super("Création de «Salle»");
		buildContentPane();
		pack();
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void buildContentPane()
	{
		nom = new JTextField(20);
		
		// definition contriantes du layout
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,15,10,15);
		c.gridx = 0;
		c.gridy = 0;
		getContenuPanel().add(new JLabel("nom"), c);
		c.gridx = 1;
		getContenuPanel().add(nom, c);
	}

	public JTextField getNomField() {
		return nom;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
