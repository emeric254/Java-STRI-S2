package com.java_s2.STRI.controller;

import java.awt.event.*;
import java.util.HashMap;

import javax.swing.JOptionPane;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.vue.CreateSalleWindow;


public class CreateSalleWindowEventListener implements ActionListener
{
	private CreateSalleWindow fenetre;
	private Salle salle;
	private HashMap<Integer, Salle> salles;
	
	public CreateSalleWindowEventListener(CreateSalleWindow pFenetre, Salle pSalle, HashMap<Integer, Salle> pSalles)
	{
		fenetre = pFenetre;
		salle = pSalle;
		salles = pSalles;
		fenetre.getAnnulerBouton().addActionListener(this);
		fenetre.getCreerBouton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == fenetre.getAnnulerBouton())
		{
			if(JOptionPane.showConfirmDialog(fenetre, "Voulez vous vraiment annuler","Annuler ?",JOptionPane.YES_NO_OPTION) == 0)
				fenetre.dispose();
		}
		else 
			if(source == fenetre.getCreerBouton())
			{
				salle.setNomSalle(fenetre.getNomField().getText());

				//@FIXME verif creation
				
				if(salle.getNomSalle().length() > 0)
					salles.put(salle.getIdSalle(), salle);
				
				//@FIXME ajout dans le parent !
				
				fenetre.dispose();
			}
	}

}
