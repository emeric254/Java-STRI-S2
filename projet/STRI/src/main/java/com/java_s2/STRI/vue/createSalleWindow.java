package com.java_s2.STRI.vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;

public class createSalleWindow extends JFrame {

	// boutons
	private JButton annuler;
	private JButton creer;

	private JTextField nom;
	
	
	public createSalleWindow()
	{
		super("Création de «Salle»");
	
		// position sur bureau
		setLocationRelativeTo(null);
		// dimensions fixe
		setResizable(false);
		
		// quand appui sur la "croix" fermer >>> quitter l'applis
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// ajout composants
		setContentPane(buildContentPane());
		// maj taille fenetre et composants selon ces derniers
		pack();
		// afficher la fenetre
		setVisible(true);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private JPanel buildContentPane()
	{
		// layout de fond
		JPanel monPanneau = new JPanel(new GridBagLayout());
		
		//creation boutons
		annuler = new JButton(" annuler ");
		creer = new JButton(" creer ");
		nom = new JTextField("");
		
		// definition contriantes du layout
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,15,10,15);
		c.gridx = 0;
		c.gridy = 0;
		monPanneau.add(new JLabel("nom"), c);
		c.gridx = 1;
		monPanneau.add(nom, c);
		
		c.gridx = 0;
		c.gridy = 1;
		monPanneau.add(annuler, c); // ajout bouton1 au layout
		
		c.gridx = 1;
		monPanneau.add(creer, c); // ajout bouton2 au layout

		return monPanneau;
	}

	public JButton getAnnulerBouton() {
		return annuler;
	}

	public JButton getCreerBouton() {
		return creer;
	}

	public JTextField getNomField() {
		return nom;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
