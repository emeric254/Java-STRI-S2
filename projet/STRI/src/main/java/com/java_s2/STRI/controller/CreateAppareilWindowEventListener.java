package com.java_s2.STRI.controller;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.java_s2.STRI.modele.*;
import com.java_s2.STRI.vue.*;


public class CreateAppareilWindowEventListener implements ActionListener
{
	private CreateAppareilWindow fenetre;
	private Appareil appareil;
	private HashMap<Integer, Appareil> appareils;
	private HashMap<Integer, Firmware> firmwares;
	private HashMap<Integer, SystemeExploitation> OS;
	private Salle salle;
	private MainWindowEventListener parent;
	
	public CreateAppareilWindowEventListener(CreateAppareilWindow pFenetre, MainWindowEventListener pParent, Appareil pAppareil, HashMap<Integer, Appareil> pAppareils, Salle salleParent, HashMap<Integer, Firmware> pFirmwares, HashMap<Integer, SystemeExploitation> pOS)
	{
		fenetre = pFenetre;
		appareil = pAppareil;
		appareils = pAppareils;
		salle = salleParent;
		firmwares = pFirmwares;
		OS = pOS;
		parent = pParent;
		
		appareil.desactiver(); // par defaut non actif
		
		fenetre.getEtatCheck().addActionListener(this);;
		fenetre.getAnnulerBouton().addActionListener(this);
		fenetre.getCreerBouton().addActionListener(this);

		for(Firmware f : firmwares.values())
			fenetre.getFirmAppareil().addItem(f.getIdFirmware() + " - " + f.getNomFirmware());
		
		for(SystemeExploitation o : OS.values())
			fenetre.getOSAppareil().addItem(o.getIdOS() + " - " + o.getNomOS());
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


				// FIXME verif creation
				
				if(appareil.getNomAppareil().length() > 0 && appareil.getMarqueAppareil().length() > 0
						&& appareil.getModeleAppareil().length() > 0)
				{
					// FIXME differencié le switch du terminal
					if(fenetre.getTypeAppareil().getSelectedItem() == "Switch")
					{
						// FIXME gerer le switch !!!
						appareil = new Switch(appareil.getIdAppareil(), appareil.getNomAppareil(), appareil.getMarqueAppareil(), appareil.getModeleAppareil(), appareil.getEtatAppareil(), appareil.getOs(), appareil.getInterfaceReseau());
					}
					else
					{
						appareil = new Terminal(appareil.getIdAppareil(), appareil.getNomAppareil(), appareil.getMarqueAppareil(), appareil.getModeleAppareil(), appareil.getEtatAppareil(), appareil.getOs(), appareil.getInterfaceReseau(), fenetre.getTypeAppareil().getSelectedItem())
						appareils.put(appareil.getIdAppareil(), appareil);
						try {
							salle.ajouterAppareil(appareil);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
					parent.refreshTree();
					fenetre.dispose();
				}
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
