package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.tree.*;

import com.java_s2.STRI.modele.Firmware;
import com.java_s2.STRI.vue.createFirmwareWindow;


public class createFirmwareWindowEventListener implements ActionListener
{
	private createFirmwareWindow fenetre;
	private Firmware firmware;
	
	public createFirmwareWindowEventListener(createFirmwareWindow pFenetre, Firmware pFirmware)
	{
		fenetre = pFenetre;
		firmware = pFirmware;
		fenetre.getAnnulerBouton().addActionListener(this);
		fenetre.getCreerBouton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == fenetre.getAnnulerBouton())
		{
			if(JOptionPane.showConfirmDialog(fenetre, "Voulez vous vraiment annuler","Annuler ?",JOptionPane.YES_NO_OPTION) == 0)
				fenetre.dispose();
		}
		else 
			if(source == fenetre.getCreerBouton())
			{
				firmware.setNomFirmware(fenetre.getNomField().getText());
				firmware.setVersionFirmware(fenetre.getVersionField().getText());
				fenetre.dispose();
			}
	}

}
