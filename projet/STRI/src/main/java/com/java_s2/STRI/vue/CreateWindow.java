package com.java_s2.STRI.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public abstract class CreateWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// boutons
	private JButton annuler;
	private JButton creer;

	private JPanel contenu;
	
	
	public CreateWindow(String title)
	{
		super();
		
		setTitle(title);
		
		//setModalityType(DEFAULT_MODALITY_TYPE);
	
		// position sur bureau
		setLocationRelativeTo(null);
		// dimensions fixe
		setResizable(false);
		
		// quand appui sur la "croix" fermer >>> quitter l'applis
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ajout composants
		setContentPane(buildContentPane());
		// maj taille fenetre et composants selon ces derniers
		pack();
		// afficher la fenetre
		setVisible(true);
	}
	
	private JPanel buildContentPane()
	{
		// layout de fond
		JPanel monPanneau = new JPanel(new GridBagLayout());
		
		//creation boutons
		annuler = new JButton(" annuler ");
		creer = new JButton(" creer ");
		contenu = new JPanel(new GridBagLayout());
		
		// definition contriantes du layout
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(10,15,10,15);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		monPanneau.add(contenu, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
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
	
	public JPanel getContenuPanel() {
		return contenu;
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}