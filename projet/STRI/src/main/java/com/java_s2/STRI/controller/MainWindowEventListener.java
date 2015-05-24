package com.java_s2.STRI.controller;

import java.awt.event.*;
import java.util.*;

import javax.swing.event.*;
import javax.swing.tree.*;

import com.java_s2.STRI.App;
import com.java_s2.STRI.controller.creation.CreateAppareilWindowEventListener;
import com.java_s2.STRI.controller.creation.CreateIntercoWindowListener;
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
        
        PostgreSQL.importBase(pLocaux, pSalles, pOS, pCartesReseaux, pAppareils, pFirmwares);

        fenetre.getBouton1().addActionListener(this);
        fenetre.getBouton2().addActionListener(this);
        fenetre.getBouton3().addActionListener(this);
        fenetre.getBouton4().addActionListener(this);
        fenetre.getTree().addTreeSelectionListener(this);

    	// TODO faire les icones stylées selon le noeud
    	fenetre.getTree().setCellRenderer(null);
    	
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
									if(appareils.get(id) instanceof Terminal || (appareils.get(id) instanceof Switch && ((Switch)appareils.get(id)).getEquipementsAppareil().size() == 0))
									{
										for (Appareil a : salles.get(Integer.parseInt(noeudSelect.getParent().toString().split(" - ")[0])).getAppareils())
											if(a instanceof Switch)
												if(((Switch)a).getEquipementsAppareil().contains(appareils.get(id)))
													((Switch)a).getEquipementsAppareil().remove(appareils.get(id));
										salles.get(Integer.parseInt(noeudSelect.getParent().toString().split(" - ")[0])).getAppareils().remove(appareils.get(id));
										appareils.remove(id);
									}
									break;
								case 5:
									if(noeudSelect.toString().split(" - ")[1].compareTo("Ordinateur") == 0 ||
											noeudSelect.toString().split(" - ")[1].compareTo("Switch") == 0 ||
											noeudSelect.toString().split(" - ")[1].compareTo("Terminal") == 0)
									{
										((Switch)appareils.get(new Integer(noeudSelect.getParent().getParent().toString().split(" - ")[0]))).getEquipementsAppareil().remove(appareils.get(id));
									}
									break;
	
								default:
									break;
								}
	                            fenetre.removeComponent(noeudSelect);
	                            refreshTree();
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
                    DefaultMutableTreeNode noeudAppareil = new DefaultMutableTreeNode(appareil.getIdAppareil() + " - " + ((appareil instanceof Terminal)?"Terminal":"Switch") + " - " + appareil.getNomAppareil());
                    fenetre.addComponent(noeudSalle, noeudAppareil);

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
                    
                    if(appareil instanceof Switch)
                    {
                        DefaultMutableTreeNode intercoNode = new DefaultMutableTreeNode("Connexions");
                        fenetre.addComponent(noeudAppareil, intercoNode);	
                        if(((Switch)appareil).getEquipementsAppareil().size()>0)
                        	for(Appareil a : ((Switch)appareil).getEquipementsAppareil() )
                        	{
                                DefaultMutableTreeNode temp = new DefaultMutableTreeNode (  a.getIdAppareil() + " - " + ((a instanceof Terminal)?"Terminal":"Switch") + " - " + a.getNomAppareil());
                                fenetre.addComponent(intercoNode, temp);	
                        	}
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
                // appareil select
            	break;
            	
            case 4:
            	if(noeudSelect.toString().compareTo("Connexions") == 0)
            	{
            		Switch sw = (Switch) appareils.get(new Integer(noeudSelect.getParent().toString().split(" - ")[0]));
            		Salle salle = salles.get(new Integer(noeudSelect.getParent().getParent().toString().split(" - ")[0]));
            		if(salle.getAppareils().size()>1)
            			new CreateIntercoWindowListener(new CreateIntercoWindow(), this, sw, salle, appareils);
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
	        if(noeudSelect.getLevel() > 0 && noeudSelect.getLevel() <4)
	        {
	        	int id = Integer.parseInt(noeudSelect.toString().split(" - ")[0]);
	        	switch (noeudSelect.getLevel()) {
				case 1:
					if(noeudSelect.toString().split(" - ")[1].compareTo("Local") == 0)
						new DetailsLocalListener(new CreateLocalWindow(), this, locaux.get(id), locaux);
					break;
				case 2:
					if(noeudSelect.toString().split(" - ")[1].compareTo("Salle") == 0)
						new DetailsSalleListener(new CreateSalleWindow(), this, salles.get(id), salles, locaux.get(Integer.parseInt(noeudSelect.getParent().toString().split(" - ")[0])));
					break;
				case 3:
					if(noeudSelect.toString().split(" - ")[1].compareTo("Terminal") == 0 || 
					noeudSelect.toString().split(" - ")[1].compareTo("Switch") == 0 )
						new DetailsAppareilListener(new CreateAppareilWindow(), this, appareils.get(id), appareils, salles.get(Integer.parseInt(noeudSelect.getParent().toString().split(" - ")[0])), firmwares, OS);
					break;
				default:
					break;
	        	}
	        }    	
    }
    
	public void refreshTree() {
    	
    	PostgreSQL.exportBase(locaux, salles, appareils, cartesReseaux, firmwares, OS);
    	
    	PostgreSQL.importBase(locaux, salles, OS, cartesReseaux, appareils, firmwares);
    	
		refreshTree(locaux);
	}

}
