package com.java_s2.STRI.controller.details;

import com.java_s2.STRI.controller.creation.CreateInterfaceWindowEventListener;
import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.vue.CreateInterfaceWindow;

public class DetailsInterfaceListener extends CreateInterfaceWindowEventListener {

	public DetailsInterfaceListener(CreateInterfaceWindow fenetre, InterfaceReseau pInterfaceReseau) {
		super(fenetre, pInterfaceReseau);
		fenetre.getCreerBouton().setText("valider");
		fenetre.getNomField().setText(pInterfaceReseau.getNomInterface());
		// TODO voir pour le firmware !
		
	}
}
