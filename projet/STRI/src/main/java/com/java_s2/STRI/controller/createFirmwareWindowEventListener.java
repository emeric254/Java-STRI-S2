package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.tree.*;

import com.java_s2.STRI.vue.createFirmwareWindow;


public class createFirmwareWindowEventListener implements ActionListener
{
	private createFirmwareWindow fenetre;
	
	public createFirmwareWindowEventListener(createFirmwareWindow pFenetre)
	{
		fenetre = pFenetre;
		fenetre.getAnnulerBouton().addActionListener(this);
		fenetre.getCreerBouton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == fenetre.getAnnulerBouton())
			fenetre.getNomField().setText("annuler !!!");
		else 
			if(source == fenetre.getCreerBouton())
				fenetre.getNomField().setText("creeer !!!");
	}

}
