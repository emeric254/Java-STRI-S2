package com.java_s2.STRI.controller.creation;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.java_s2.STRI.controller.MainWindowEventListener;
import com.java_s2.STRI.modele.*;
import com.java_s2.STRI.vue.*;

public class CreateIntercoWindowListener  implements ActionListener
{
	private CreateIntercoWindow fenetre;
	private Switch sw;
	private Salle salle;
	private MainWindowEventListener parent;
    private HashMap<Integer, Appareil> appareils;
	
	public CreateIntercoWindowListener(CreateIntercoWindow pFenetre, MainWindowEventListener pParent, Switch pSw, Salle salleParent, HashMap<Integer, Appareil> pAppareils)
	{
		fenetre = pFenetre;
		sw = pSw;
		salle = salleParent;
		parent = pParent;
		appareils = pAppareils;
		
		sw.activer();
		
		fenetre.getAnnulerBouton().addActionListener(this);
		fenetre.getCreerBouton().addActionListener(this);
		fenetre.getIdLabel().setText(new Integer(sw.getIdAppareil()).toString());

		for(Appareil a : salleParent.getAppareils())
			if(!sw.getEquipementsAppareil().contains(a) && a != sw)
				fenetre.getAppareil().addItem(a.getIdAppareil() + " - " + a.getNomAppareil());
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
				// TODO a verif
				Appareil app = appareils.get(fenetre.getAppareil().getSelectedItem().toString().split(" - ")[0]);
				if(salle.getAppareils().contains(app));
				{
					sw.getEquipementsAppareil().add(app);
				}	
					parent.refreshTree();
					fenetre.dispose();
			}
	}

}
