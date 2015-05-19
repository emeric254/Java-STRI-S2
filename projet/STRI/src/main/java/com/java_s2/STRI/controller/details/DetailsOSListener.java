package com.java_s2.STRI.controller.details;

import com.java_s2.STRI.controller.creation.CreateOSWindowEventListener;
import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.vue.CreateOSWindow;

public class DetailsOSListener extends CreateOSWindowEventListener {

	public DetailsOSListener(CreateOSWindow fenetre, SystemeExploitation os) {
		super(fenetre, os);
		fenetre.getCreerBouton().setText("valider");
		fenetre.getNomField().setText(os.getNomOS());
		fenetre.getVersionField().setText(os.getVersionOS());
	}

}
