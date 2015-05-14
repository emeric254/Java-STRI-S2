package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.tree.*;

import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.vue.createLocalWindow;


public class createLocalWindowEventListener implements ActionListener
{
	private createLocalWindow fenetre;
	private Local local;
	
	public createLocalWindowEventListener(createLocalWindow pFenetre, Local pLocal)
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
			//@todo add a popup where user have to confirm
			fenetre.dispose();
		}
		else 
			if(source == fenetre.getCreerBouton())
			{
				local.setLieuLocal(fenetre.getLieuField().getText());
				local.setNomLocal(fenetre.getNomField().getText());
				fenetre.dispose();
			}
	}

}
