package com.java_s2.STRI.controller;

import java.awt.event.*;
import java.util.HashMap;

import javax.swing.JOptionPane;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.vue.CreateLocalWindow;


public class CreateLocalWindowEventListener implements ActionListener
{
	private CreateLocalWindow fenetre;
	private Local local;
	private HashMap<Integer, Local> locaux;
	
	public CreateLocalWindowEventListener(CreateLocalWindow pFenetre, Local pLocal, HashMap<Integer, Local> pLocaux)
	{
		fenetre = pFenetre;
		local = pLocal;
		locaux = pLocaux;
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

				//@FIXME verif creation
				
				if(local.getNomLocal().length() > 0)
					locaux.put(local.getIdLocal(), local);
				
				fenetre.dispose();
			}
	}

}