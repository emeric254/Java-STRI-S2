package com.java_s2.STRI.controller;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.event.*;
import javax.swing.tree.*;

import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.utils.GestionSerial;
import com.java_s2.STRI.vue.CreateAppareilWindow;
import com.java_s2.STRI.vue.CreateLocalWindow;
import com.java_s2.STRI.vue.CreateSalleWindow;
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
        fenetre.getBouton3().addActionListener(this);
        fenetre.getTree().addTreeSelectionListener(this);

        refreshTree(locaux);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == fenetre.getBouton1())
            createChild();
        else
            if(source == fenetre.getBouton3())
                refreshTree(locaux);
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
								salles.remove(id);
								break;
							case 3:
								appareils.remove(id);
								break;

							default:
								break;
							}
                            fenetre.removeComponent(noeudSelect);
                        }
    }

    public void refreshTree(HashMap<Integer, Local> locaux)
    {
        // TODO ajouter nom classe avant ce quil y a deja ?

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
                        DefaultMutableTreeNode interfacesNode = new DefaultMutableTreeNode("Interfaces Réseaux");
                        fenetre.addComponent(noeudAppareil, interfacesNode);

                        DefaultMutableTreeNode noeudCarte = new DefaultMutableTreeNode(carte.getAdresseMAC() + " - " + carte.getNomInterface());
                        fenetre.addComponent(interfacesNode, noeudCarte);

                        DefaultMutableTreeNode firmsNode = new DefaultMutableTreeNode("Firmware");
                        fenetre.addComponent(noeudCarte, firmsNode);

                        Firmware firm = carte.getFirmware();
                        DefaultMutableTreeNode noeudFirm = new DefaultMutableTreeNode(firm.getIdFirmware() + " - " + firm.getNomFirmware());
                        fenetre.addComponent(firmsNode, noeudFirm);
                    }


                    SystemeExploitation os = appareil.getOs();
                    if(os != null)
                    {
                        DefaultMutableTreeNode osNode = new DefaultMutableTreeNode("Système d'exploitation");
                        fenetre.addComponent(noeudAppareil, osNode);

                        DefaultMutableTreeNode noeudOs = new DefaultMutableTreeNode(os.getIdOS() + " - " + os.getNomOS());
                        fenetre.addComponent(osNode, noeudOs);
                    }

                }
            }
        }
        fenetre.expandAll();
    }

    public void valueChanged(TreeSelectionEvent arg0)
    {
        noeudSelect = (DefaultMutableTreeNode) fenetre.getTree().getLastSelectedPathComponent();
    }

    public void createChild()
    {
        // TODO a finir
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
                Appareil newAppareil = new Appareil(GestionSerial.prochainSerial(appareils.keySet()), "", "", "", false, null, null);
                Salle salleParent = salles.get(id);
                new CreateAppareilWindowEventListener(new CreateAppareilWindow(), this, newAppareil, appareils, salleParent);
                break;

            case 3:
                // interco switch - equipement
            case 4:
                // TODO interco
                // FIXME donner l'appareil switch parent en param !
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

        // inutile sans fenetres modales
        // refreshTree(locaux);
        // TODO filer «fenetre» en param de chaque creation pour refresh en fin de creation
        // TODO bloquer «fenetre» lors de creation
    }

	public void refreshTree() {
		refreshTree(locaux);
	}

}
