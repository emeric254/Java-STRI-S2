package com.java_s2.STRI.controller.details;

import java.util.HashMap;

import com.java_s2.STRI.controller.MainWindowEventListener;
import com.java_s2.STRI.controller.creation.CreateLocalWindowEventListener;
import com.java_s2.STRI.modele.Local;
import com.java_s2.STRI.vue.CreateLocalWindow;

public class DetailsLocalListener extends CreateLocalWindowEventListener {

	public DetailsLocalListener(CreateLocalWindow fenetre, MainWindowEventListener parent, Local local, HashMap<Integer, Local> locaux) {
		super(fenetre, parent, local, locaux);
		fenetre.getCreerBouton().setText("valider");
		fenetre.getNomField().setText(local.getNomLocal());
		fenetre.getLieuField().setText(local.getLieuLocal());
	}

}
