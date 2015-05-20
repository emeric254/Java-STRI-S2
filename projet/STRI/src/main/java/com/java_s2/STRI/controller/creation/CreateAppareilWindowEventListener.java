package com.java_s2.STRI.controller.creation;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.java_s2.STRI.controller.MainWindowEventListener;
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
		fenetre.getIdLabel().setText(new Integer(appareil.getIdAppareil()).toString());

		for(Firmware f : firmwares.values())
			fenetre.getFirmAppareil().addItem(f.getIdFirmware() + " - " + f.getNomFirmware());
		
		for(SystemeExploitation o : OS.values())
			fenetre.getOSAppareil().addItem(o.getIdOS() + " - " + o.getNomOS());
		
		fenetre.pack();
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
				if(salle.getAppareils().contains(appareil))
				{
					salle.getAppareils().remove(appareil);
				}
				
				// FIXME ajouter interface reseau par defaut
				
				appareil.setNomAppareil(fenetre.getNomField().getText());
				appareil.setMarqueAppareil(fenetre.getMarqueField().getText());
				appareil.setModeleAppareil(fenetre.getModeleField().getText());

				// TODO firmwares 
				appareil.getInterfaceReseau().setFirmware(firmwares.get(new Integer(fenetre.getFirmAppareil().getSelectedItem().toString().split(" - ")[0]) ) );
				
				// TODO OS
				appareil.setOs(OS.get(new Integer(fenetre.getOSAppareil().getSelectedItem().toString().split(" - ")[0])) );
				
				if(fenetre.getEtatCheck().isSelected())
					appareil.activer();
				else
					appareil.desactiver();
				
				if(appareil.getNomAppareil().length() > 0 && appareil.getMarqueAppareil().length() > 0
						&& appareil.getModeleAppareil().length() > 0)
				{
					if(fenetre.getTypeAppareil().getSelectedItem() == "Switch")
					{
						// FIXME gerer le switch !!!
						appareil = new Switch(appareil.getIdAppareil(), appareil.getNomAppareil(), appareil.getMarqueAppareil(), appareil.getModeleAppareil(), appareil.getEtatAppareil(), appareil.getOs(), appareil.getInterfaceReseau());
					}
					else
					{
						appareil = new Terminal(appareil.getIdAppareil(), appareil.getNomAppareil(),
								appareil.getMarqueAppareil(), appareil.getModeleAppareil(),
								appareil.getEtatAppareil(), appareil.getOs(), appareil.getInterfaceReseau(),
								("Tablette".compareTo(fenetre.getTypeAppareil().getSelectedItem().toString()) == 0)?com.java_s2.STRI.modele.Type.TABLETTE:com.java_s2.STRI.modele.Type.ORDINATEUR);
					}
					
					appareils.put(appareil.getIdAppareil(), appareil);
					salle.getAppareils().add(appareil);
					
					
					
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
