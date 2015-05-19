package com.java_s2.STRI.controller.details;

import java.util.HashMap;

import com.java_s2.STRI.controller.MainWindowEventListener;
import com.java_s2.STRI.controller.creation.CreateSalleWindowEventListener;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.modele.Salle;
import com.java_s2.STRI.vue.CreateSalleWindow;

public class DetailsSalleListener extends CreateSalleWindowEventListener {

	public DetailsSalleListener(CreateSalleWindow fenetre, MainWindowEventListener parent, Salle salle, HashMap<Integer, Salle> salles, Local local) {
		super(fenetre, parent, salle, salles, local);
		fenetre.getCreerBouton().setText("valider");
		fenetre.getNomField().setText(salle.getNomSalle());
	}
}
