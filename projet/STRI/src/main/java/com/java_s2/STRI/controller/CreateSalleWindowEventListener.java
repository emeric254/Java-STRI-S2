package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.tree.*;

import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.vue.CreateSalleWindow;


public class CreateSalleWindowEventListener implements ActionListener
{
	private CreateSalleWindow fenetre;
	private Salle salle;
	
	public CreateSalleWindowEventListener(CreateSalleWindow pFenetre, Salle pSalle)
	{
		fenetre = pFenetre;
		salle = pSalle;
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
				fenetre.dispose();
			}
	}

}
