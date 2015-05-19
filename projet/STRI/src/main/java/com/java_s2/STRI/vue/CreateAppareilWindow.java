package com.java_s2.STRI.vue;

import java.awt.*;

import javax.swing.*;

public class CreateAppareilWindow extends CreateWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nom;
	private JTextField marque;
	private JTextField modele;
	private JCheckBox etat;
	private JComboBox<String> type;
	private JComboBox<String> os;
	private JComboBox<String> firmware;
	
	
	public CreateAppareilWindow()
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
		etat = new JCheckBox();
		DefaultComboBoxModel<String> choix = new DefaultComboBoxModel<String>();
		
		// TODO externaliser ca
		choix.addElement("Ordinateur");
		choix.addElement("Tablette");
		choix.addElement("Switch");
		
		type = new JComboBox<String>(choix);

		os = new JComboBox<String>();
		firmware = new JComboBox<String>();
		
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

		c.gridx = 0;
		c.gridy = 3;
		getContenuPanel().add(new JLabel("actif ?"), c);
		c.gridx = 1;
		getContenuPanel().add(etat, c);

		c.gridx = 0;
		c.gridy = 4;
		getContenuPanel().add(new JLabel("type"), c);
		c.gridx = 1;
		getContenuPanel().add(type, c);

		c.gridx = 0;
		c.gridy = 5;
		getContenuPanel().add(new JLabel("O/S"), c);
		c.gridx = 1;
		getContenuPanel().add(os, c);
		

		// TODO firmwares
/*
		c.gridx = 0;
		c.gridy = 6;
		getContenuPanel().add(new JLabel("firmware"), c);
		c.gridx = 1;
		getContenuPanel().add(firmware, c);
*/

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
	
	public JCheckBox getEtatCheck() {
		return etat;
	}
	
	public JComboBox<String> getFirmAppareil(){
		return firmware;
	}
	
	public JComboBox<String> getOSAppareil(){
		return os;
	}
	
	public JComboBox<String> getTypeAppareil(){
		return type;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
