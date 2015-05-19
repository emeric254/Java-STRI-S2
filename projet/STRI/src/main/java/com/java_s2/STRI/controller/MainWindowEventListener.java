package com.java_s2.STRI.controller;

import java.awt.event.*;
import java.util.*;

import javax.swing.event.*;
import javax.swing.tree.*;

import com.java_s2.STRI.controller.creation.CreateAppareilWindowEventListener;
import com.java_s2.STRI.controller.creation.CreateLocalWindowEventListener;
import com.java_s2.STRI.controller.creation.CreateSalleWindowEventListener;
import com.java_s2.STRI.controller.details.DetailsAppareilListener;
import com.java_s2.STRI.modele.*;
import com.java_s2.STRI.utils.*;
import com.java_s2.STRI.vue.*;
import com.java_s2.STRI.controller.details.*;


public class MainWindowEventListener implements ActionListener, TreeSelectionListener
{
    private MainWindow fenetre;

    /* ensembles d'objets (comme en bd) */
    private HashMap<Integer, Local> locaux;
    private HashMap<Integer, Salle> salles;
    private HashMap<Integer, Appareil> appareils;
    private HashMap<Integer, InterfaceReseau> cartesReseaux;
	HashMap<Integer, Firmware> firmwares;
	HashMap <Integer, SystemeExploitation> OS;

    private DefaultMutableTreeNode noeudSelect;


    public MainWindowEventListener(MainWindow pFenetre, HashMap<Integer,
            Local> pLocaux, HashMap<Integer, Salle> pSalles,
            HashMap<Integer, Appareil> pAppareils,
            HashMap<Integer, InterfaceReseau> pCartesReseaux,
            HashMap<Integer, Firmware> pFirmwares,
            HashMap<Integer,SystemeExploitation> pOS)
    {
        fenetre = pFenetre;
        locaux = pLocaux;
        salles = pSalles;
        appareils = pAppareils;
        cartesReseaux = pCartesReseaux;
        firmwares = pFirmwares;
        OS = pOS;

        fenetre.getBouton1().addActionListener(this);
        fenetre.getBouton2().addActionListener(this);
        fenetre.getBouton3().addActionListener(this);
        fenetre.getBouton4().addActionListener(this);
        fenetre.getTree().addTreeSelectionListener(this);

        refreshTree(locaux);
    }

    // action listener boutons
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == fenetre.getBouton1())
            createChild();
        else
            if(source == fenetre.getBouton3())
                refreshTree(locaux);
            else
            	if(source == fenetre.getBouton4())
            		details();
            	else
	                if(source == fenetre.getBouton2())
	                    if(noeudSelect != null)
	                        if(noeudSelect.getLevel() > 0)
	                        {
	                        	int id = Integer.parseInt(noeudSelect.toString().split(" - ")[0]);
	                        	switch (noeudSelect.getLevel()) {
								case 1:
									locaux.remove(id);
									break;
								case 2:
									locaux.get(Integer.parseInt(noeudSelect.getParent().toString().split(" - ")[0])).getSallesLocal().remove(salles.get(id));
									salles.remove(id);
									break;
								case 3:
									salles.get(Integer.parseInt(noeudSelect.getParent().toString().split(" - ")[0])).getAppareils().remove(appareils.get(id));
									// FIXME interco a verif a chaque fois
									appareils.remove(id);
									break;
	
								default:
									break;
								}
	                            fenetre.removeComponent(noeudSelect);
	                        }
    }

    // action listener JTree
    public void valueChanged(TreeSelectionEvent arg0)
    {
        noeudSelect = (DefaultMutableTreeNode) fenetre.getTree().getLastSelectedPathComponent();
    }

    
    public void refreshTree(HashMap<Integer, Local> locaux)
    {
        fenetre.clearAllComponent();
        for (Integer id : locaux.keySet())
        {
            DefaultMutableTreeNode noeudLocal = new DefaultMutableTreeNode(id + " - Local - " + locaux.get(id).getNomLocal());
            fenetre.addComponent(fenetre.rootTree, noeudLocal);

            ArrayList<Salle> salles = locaux.get(id).getSallesLocal();

            for (Salle salle : salles)
            {
                DefaultMutableTreeNode noeudSalle = new DefaultMutableTreeNode(salle.getIdSalle() + " - Salle - " + salle.getNomSalle());
                fenetre.addComponent(noeudLocal, noeudSalle);

                ArrayList<Appareil> appareils = salle.getAppareils();

                for (Appareil appareil : appareils)
                {
                    DefaultMutableTreeNode noeudAppareil = new DefaultMutableTreeNode(appareil.getIdAppareil() + " - Appareil - " + appareil.getNomAppareil());
                    fenetre.addComponent(noeudSalle, noeudAppareil);

                    // TODO a revoir pour en faire des sous categories (os / firmware / interfaces)

                    InterfaceReseau carte = appareil.getInterfaceReseau();
                    if(carte != null)
                    {
                        DefaultMutableTreeNode noeudCarte = new DefaultMutableTreeNode(carte.getAdresseMAC() + " - Carte Réseau - " + carte.getNomInterface());
                        fenetre.addComponent(noeudAppareil, noeudCarte);

                        Firmware firm = carte.getFirmware();
                        DefaultMutableTreeNode noeudFirm = new DefaultMutableTreeNode(firm.getIdFirmware() + " - Firmware - " + firm.getNomFirmware());
                        fenetre.addComponent(noeudCarte, noeudFirm);

                    }

                    SystemeExploitation os = appareil.getOs();
                    if(os != null)
                    {
                        DefaultMutableTreeNode noeudOs = new DefaultMutableTreeNode(os.getIdOS() + " - O/S - " + os.getNomOS());
                        fenetre.addComponent(noeudAppareil, noeudOs);
                    }

                }
            }
        }
        fenetre.expandAll();
    }

    
    public void createChild()
    {
        if(noeudSelect != null)
        {
            int id = 0;
            if(noeudSelect.getLevel()>0 && noeudSelect.toString().contains(" - "))
                id = Integer.parseInt(noeudSelect.toString().split(" - ")[0]);
            switch (noeudSelect.getLevel()) {
            case 1:
                Salle newSalle = new Salle(GestionSerial.prochainSerial(salles.keySet()), "");
                newSalle.setAppareils(new ArrayList<Appareil>());
                Local localParent = locaux.get(id);
                new CreateSalleWindowEventListener(new CreateSalleWindow(), this, newSalle, salles, localParent);
                break;

            case 2:
                Appareil newAppareil = new Appareil(GestionSerial.prochainSerial(appareils.keySet()), "", "", "", false, null, new InterfaceReseau(GestionMAC.prochainMAC(cartesReseaux.keySet()), "defaut", firmwares.get(0)));
                Salle salleParent = salles.get(id);
                new CreateAppareilWindowEventListener(new CreateAppareilWindow(), this, newAppareil, appareils, salleParent, firmwares, OS);
                break;

            case 3:
                // interco switch - equipement
            case 4:
            	Appareil appareil = appareils.get(id);
            	if (appareil instanceof Switch)
            	{
                    // FIXME interco
                    // TODO donner l'appareil switch parent en param !
            	}
                break;

            default:
                Local newLocal = new Local(GestionSerial.prochainSerial(locaux.keySet()), "", "");
                newLocal.setSallesLocal(new ArrayList<Salle>());
                new CreateLocalWindowEventListener(new CreateLocalWindow(), this, newLocal, locaux);
                break;
            }
        }
        else {
            Local newLocal = new Local(GestionSerial.prochainSerial(locaux.keySet()), "", "");
            newLocal.setSallesLocal(new ArrayList<Salle>());
            new CreateLocalWindowEventListener(new CreateLocalWindow(), this, newLocal, locaux);
        }

        // TODO bloquer «fenetre» lors de creation
    }

    public void details()
    {
    	if(noeudSelect!= null)
	        if(noeudSelect.getLevel() > 0)
	        {
	        	int id = Integer.parseInt(noeudSelect.toString().split(" - ")[0]);
	        	switch (noeudSelect.getLevel()) {
				case 1:
					new DetailsLocalListener(new CreateLocalWindow(), this, locaux.get(id), locaux);
					break;
				case 2:
					new DetailsSalleListener(new CreateSalleWindow(), this, salles.get(id), salles, locaux.get(Integer.parseInt(noeudSelect.getParent().toString().split(" - ")[0])));
					break;
				case 3:
					new DetailsAppareilListener(new CreateAppareilWindow(), this, appareils.get(id), appareils, salles.get(Integer.parseInt(noeudSelect.getParent().toString().split(" - ")[0])), firmwares, OS);
					break;
	
				default:
					break;
	        	}
	        }    	
    }
    
	public void refreshTree() {
		refreshTree(locaux);
	}

}
