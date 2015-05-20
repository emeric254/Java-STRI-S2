package com.java_s2.STRI.controller.details;

import java.awt.event.ActionEvent;
import java.awt.print.Paper;
import java.util.HashMap;

import com.java_s2.STRI.controller.MainWindowEventListener;
import com.java_s2.STRI.controller.creation.CreateAppareilWindowEventListener;
import com.java_s2.STRI.modele.*;
import com.java_s2.STRI.vue.CreateAppareilWindow;

public class DetailsAppareilListener extends CreateAppareilWindowEventListener {

	private CreateAppareilWindow fenetre;
	private Appareil appareil;
	public DetailsAppareilListener(CreateAppareilWindow pFenetre, MainWindowEventListener parent, Appareil appareil, HashMap<Integer, Appareil> appareils, Salle salle, HashMap<Integer, Firmware> firmwares, HashMap<Integer, SystemeExploitation> os) {
		super(pFenetre, parent, appareil, appareils, salle, firmwares, os);
		fenetre = pFenetre;
		this.appareil = appareil;
		fenetre.getCreerBouton().setText("valider");
		fenetre.setTitle("Modification de «Appareil»");
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


	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == fenetre.getCreerBouton())
		{
			if(!fenetre.getEtatCheck().isSelected() && appareil instanceof Switch)
				desactivation((Switch)appareil);
		}
		super.actionPerformed(e);
	}
	
	private void desactivation(Switch maitre) {
		if(maitre.getEtatAppareil())
		{
			for(Appareil a : maitre.getEquipementsAppareil())
			{
				if(a instanceof Switch)
					desactivation((Switch)a);
				else
					a.desactiver();
			}
		}	
	}
}
