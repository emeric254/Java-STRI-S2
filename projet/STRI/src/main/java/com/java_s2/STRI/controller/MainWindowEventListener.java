package com.java_s2.STRI.controller;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.event.*;
import javax.swing.tree.*;

import com.java_s2.STRI.App;
import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.utils.GestionSerial;
import com.java_s2.STRI.vue.CreateLocalWindow;
import com.java_s2.STRI.vue.MainWindow;


public class MainWindowEventListener implements ActionListener, TreeSelectionListener
{
	private MainWindow fenetre;
	
	/* ensembles d'objets (comme en bd) */
	private HashMap<Integer, Local> locaux;
	private HashMap<Integer, Salle> salles;
	private HashMap<Integer, Appareil> appareils;
	private HashMap<Integer, InterfaceReseau> cartesReseaux;
	
	private DefaultMutableTreeNode noeudSelect;
	
	
	public MainWindowEventListener(MainWindow pFenetre, HashMap<Integer,
			Local> pLocaux, HashMap<Integer, Salle> pSalles,
			HashMap<Integer, Appareil> pAppareils,
			HashMap<Integer, InterfaceReseau> pCartesReseaux)
	{
		fenetre = pFenetre;
		locaux = pLocaux;
		salles = pSalles;
		appareils = pAppareils;
		cartesReseaux = pCartesReseaux;
		
		fenetre.getBouton1().addActionListener(this);
		fenetre.getBouton2().addActionListener(this);
		fenetre.getTree().addTreeSelectionListener(this);
		
		refreshTree(locaux);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == fenetre.getBouton1())
			createChild();
		else 
			if(source == fenetre.getBouton2())
				if(noeudSelect != null)
					if(noeudSelect.getLevel() > 0)
						fenetre.removeComponent(noeudSelect);
	}
	
	public void refreshTree(HashMap<Integer, Local> locaux)
	{
		System.out.println(locaux);
		fenetre.clearAllComponent();
		for (Integer id : locaux.keySet())
		{
			DefaultMutableTreeNode noeudLocal = new DefaultMutableTreeNode(id + " - " + locaux.get(id).getNomLocal());
			fenetre.addComponent(fenetre.rootTree, noeudLocal);
			
			ArrayList<Salle> salles = locaux.get(id).getSallesLocal();
			
			for (Salle salle : salles)
			{
				DefaultMutableTreeNode noeudSalle = new DefaultMutableTreeNode(salle.getIdSalle() + " - " + salle.getNomSalle());
				fenetre.addComponent(noeudLocal, noeudSalle);

				ArrayList<Appareil> appareils = salle.getAppareils();
				
				for (Appareil appareil : appareils)
				{
					DefaultMutableTreeNode noeudAppareil = new DefaultMutableTreeNode(appareil.getIdAppareil() + " - " + appareil.getNomAppareil());
					fenetre.addComponent(noeudSalle, noeudAppareil);
					
					InterfaceReseau carte = appareil.getInterfaceReseau();
					DefaultMutableTreeNode noeudCarte = new DefaultMutableTreeNode(carte.getAdresseMAC() + " - " + carte.getNomInterface());
					fenetre.addComponent(noeudAppareil, noeudCarte);
					
					Firmware firm = carte.getFirmware();
					DefaultMutableTreeNode noeudFirm = new DefaultMutableTreeNode(firm.getIdFirmware() + " - " + firm.getNomFirmware());
					fenetre.addComponent(noeudCarte, noeudFirm);
					
					SystemeExploitation os = appareil.getOs();
					DefaultMutableTreeNode noeudOs = new DefaultMutableTreeNode(os.getIdOS() + " - " + os.getNomOS());
					fenetre.addComponent(noeudAppareil, noeudOs);
				}
			}
		}
	}

	public void valueChanged(TreeSelectionEvent arg0)
	{
		noeudSelect = (DefaultMutableTreeNode) fenetre.getTree().getLastSelectedPathComponent();
		
		/* rien de selectionner */ 
		if (noeudSelect == null)
			return;
		
		Object nodeInfo = noeudSelect.getUserObject();
		
		System.out.println(nodeInfo.toString());
		//@TODO a finir ...
	}
	
	public void createChild()
	{
		//@TODO a faire
		if(noeudSelect != null)
			switch (noeudSelect.getLevel()) {
			case 1:
				System.out.println(1);
				break;
				
			case 2:
				System.out.println(2);
				break;
				
			case 3:
				System.out.println(3);
				break;
				
			case 4:
				System.out.println(4);
				break;
	
			default:
				System.out.println(1);
				Local newLocal = new Local(GestionSerial.prochainSerial(locaux.keySet()), "", "");
				
				CreateLocalWindow creaFenetre = new CreateLocalWindow();
				CreateLocalWindowEventListener creaListener = new CreateLocalWindowEventListener(creaFenetre, newLocal);

				//@FIXME rendre bloqubnte les sous fenetres
				
				//@TODO verif creation
				if(newLocal.getNomLocal().length() > 0)
					locaux.put(newLocal.getIdLocal(), newLocal);
				
				break;
			}
		
		refreshTree(locaux);
	}

}
