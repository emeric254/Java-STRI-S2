package com.java_s2.STRI.controller.details;

import java.util.HashMap;

import com.java_s2.STRI.controller.MainWindowEventListener;
import com.java_s2.STRI.controller.creation.CreateAppareilWindowEventListener;
import com.java_s2.STRI.modele.*;
import com.java_s2.STRI.vue.CreateAppareilWindow;

public class DetailsAppareilListener extends CreateAppareilWindowEventListener {

	public DetailsAppareilListener(CreateAppareilWindow fenetre, MainWindowEventListener parent, Appareil appareil, HashMap<Integer, Appareil> appareils, Salle salle, HashMap<Integer, Firmware> firmwares, HashMap<Integer, SystemeExploitation> os) {
		super(fenetre, parent, appareil, appareils, salle, firmwares, os);
		fenetre.getCreerBouton().setText("valider");
		fenetre.getNomField().setText(appareil.getNomAppareil());
		fenetre.getMarqueField().setText(appareil.getMarqueAppareil());
		fenetre.getModeleField().setText(appareil.getModeleAppareil());
		fenetre.getEtatCheck().setSelected(appareil.getEtatAppareil());
		fenetre.getTypeAppareil().setSelectedItem((appareil instanceof Terminal)?((com.java_s2.STRI.modele.Type.TABLETTE == ((Terminal)appareil).getType())?"Tablette":"Ordinateur"):"Switch");
		// TODO changer ce selected
//		fenetre.getFirmAppareil().setSelectedItem(appareil.getInterfaceReseau().getFirmware());
		// TODO changer ce selected
//		fenetre.getOSAppareil().setSelectedItem(appareil.getOs().getNomOS());
	}

}
