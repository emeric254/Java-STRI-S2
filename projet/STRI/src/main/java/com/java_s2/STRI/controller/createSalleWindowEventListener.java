package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.tree.*;

import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.vue.createSalleWindow;


public class createSalleWindowEventListener implements ActionListener
{
	private createSalleWindow fenetre;
	private Salle salle;
	
	public createSalleWindowEventListener(createSalleWindow pFenetre, Salle pSalle)
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
			//@todo add a popup where user have to confirm
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
