package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.JOptionPane;
import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.vue.CreateAppareilWindow;


public class CreateAppareilWindowEventListener implements ActionListener
{
	private CreateAppareilWindow fenetre;
	private Appareil appareil;
	
	public CreateAppareilWindowEventListener(CreateAppareilWindow pFenetre, Appareil pAppareil)
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
			if(JOptionPane.showConfirmDialog(fenetre, "Voulez vous vraiment annuler","Annuler ?",JOptionPane.YES_NO_OPTION) == 0)
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
