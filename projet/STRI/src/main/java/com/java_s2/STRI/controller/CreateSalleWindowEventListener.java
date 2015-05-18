package com.java_s2.STRI.controller;

import java.awt.event.*;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.vue.CreateSalleWindow;
import com.java_s2.STRI.vue.MainWindow;


public class CreateSalleWindowEventListener implements ActionListener
{
	private CreateSalleWindow fenetre;
	private Salle salle;
	private HashMap<Integer, Salle> salles;
	private Local local;
	private MainWindowEventListener parent;
	
	public CreateSalleWindowEventListener(CreateSalleWindow pFenetre, MainWindowEventListener pParent, Salle pSalle, HashMap<Integer, Salle> pSalles, Local localParent)
	{
		fenetre = pFenetre;
		salle = pSalle;
		salles = pSalles;
		local=localParent;
		
		parent = pParent;
		
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
				String nom = fenetre.getNomField().getText();
				
				if(nom.length() > 0)
				{
					salle.setNomSalle(nom);
					
					salles.put(salle.getIdSalle(), salle);
					local.ajouterSalle(salle);
					
					parent.refreshTree();
					fenetre.dispose();
				}
				
			}
	}

}
