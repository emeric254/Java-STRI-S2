package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.tree.*;

import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.vue.createAppareilWindow;


public class createAppareilWindowEventListener implements ActionListener
{
	private createAppareilWindow fenetre;
	private Appareil appareil;
	
	public createAppareilWindowEventListener(createAppareilWindow pFenetre, Appareil pAppareil)
	{
		fenetre = pFenetre;
		appareil = pAppareil;
		
		appareil.desactiver(); // par defaut non actif
		
		fenetre.getEtatCheck().addActionListener(this);;
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
				appareil.setNomAppareil(fenetre.getNomField().getText());
				appareil.setMarqueAppareil(fenetre.getMarqueField().getText());
				appareil.setModeleAppareil(fenetre.getModeleField().getText());
				fenetre.dispose();
			}
			else
				if(source == fenetre.getEtatCheck())
				{
					if(appareil.getEtatAppareil())
						appareil.desactiver();
					else
						appareil.activer();
				}
	}

}
