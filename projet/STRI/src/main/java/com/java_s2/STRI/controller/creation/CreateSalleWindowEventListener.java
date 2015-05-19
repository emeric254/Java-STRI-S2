package com.java_s2.STRI.controller.creation;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.java_s2.STRI.controller.MainWindowEventListener;
import com.java_s2.STRI.modele.*;
import com.java_s2.STRI.vue.*;


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
		fenetre.getIdLabel().setText(new Integer(salle.getIdSalle()).toString());
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
					if(local.getSallesLocal().contains(salle))
						local.getSallesLocal().remove(salle);
					
					salle.setNomSalle(nom);
					
					salles.put(salle.getIdSalle(), salle);
					local.getSallesLocal().add(salle);
					
					parent.refreshTree();
					fenetre.dispose();
				}
				
			}
	}

}
