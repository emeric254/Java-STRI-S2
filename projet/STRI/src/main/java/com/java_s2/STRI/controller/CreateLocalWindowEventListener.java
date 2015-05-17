package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.tree.*;

import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.vue.CreateLocalWindow;


public class CreateLocalWindowEventListener implements ActionListener
{
	private CreateLocalWindow fenetre;
	private Local local;
	
	public CreateLocalWindowEventListener(CreateLocalWindow pFenetre, Local pLocal)
	{
		fenetre = pFenetre;
		local = pLocal;
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
				local.setLieuLocal(fenetre.getLieuField().getText());
				local.setNomLocal(fenetre.getNomField().getText());

				//@FIXME verif creation + ajout dans la HASHMAP
				/*
				if(local.getNomLocal().length() > 0)
					locaux.put(local.getIdLocal(), local);
				*/
				
				fenetre.dispose();
			}
	}

}
