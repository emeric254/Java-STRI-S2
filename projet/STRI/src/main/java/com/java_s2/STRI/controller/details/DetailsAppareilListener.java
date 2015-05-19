package com.java_s2.STRI.controller.details;

import java.util.HashMap;

import com.java_s2.STRI.controller.MainWindowEventListener;
import com.java_s2.STRI.controller.creation.CreateAppareilWindowEventListener;
import com.java_s2.STRI.modele.Appareil;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.vue.CreateAppareilWindow;

public class DetailsAppareilListener extends CreateAppareilWindowEventListener {

	public DetailsAppareilListener(CreateAppareilWindow fenetre, MainWindowEventListener parent, Appareil appareil, HashMap<Integer, Appareil> appareils, Salle salle, HashMap<Integer, Firmware> firmwares, HashMap<Integer, SystemeExploitation> os) {
		super(fenetre, parent, appareil, appareils, salle, firmwares, os);
		fenetre.getCreerBouton().setText("valider");
		fenetre.getNomField().setText(appareil.getNomAppareil());
		fenetre.getMarqueField().setText(appareil.getMarqueAppareil());
		fenetre.getModeleField().setText(appareil.getModeleAppareil());
		fenetre.getEtatCheck().setSelected(appareil.getEtatAppareil());
		// TODO changer ce selected
//		fenetre.getFirmAppareil().setSelectedItem(appareil.getInterfaceReseau().getFirmware());
		// TODO changer ce selected
//		fenetre.getOSAppareil().setSelectedItem(appareil.getOs().getNomOS());
	}

}
