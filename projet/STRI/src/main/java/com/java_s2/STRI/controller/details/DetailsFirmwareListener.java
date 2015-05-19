package com.java_s2.STRI.controller.details;

import com.java_s2.STRI.controller.creation.CreateFirmwareWindowEventListener;
import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.vue.CreateFirmwareWindow;

public class DetailsFirmwareListener extends CreateFirmwareWindowEventListener {

	public DetailsFirmwareListener(CreateFirmwareWindow fenetre, Firmware firmware){
		super(fenetre, firmware);
		fenetre.getCreerBouton().setText("valider");
		fenetre.getNomField().setText(firmware.getNomFirmware());
		fenetre.getVersionField().setText(firmware.getVersionFirmware());
	}

}
