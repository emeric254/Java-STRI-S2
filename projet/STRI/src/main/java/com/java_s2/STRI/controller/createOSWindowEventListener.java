package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.tree.*;

import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.vue.createOSWindow;


public class createOSWindowEventListener implements ActionListener
{
	private createOSWindow fenetre;
	private SystemeExploitation os;
	
	public createOSWindowEventListener(createOSWindow pFenetre, SystemeExploitation pOS)
	{
		fenetre = pFenetre;
		os = pOS;
		fenetre.getAnnulerBouton().addActionListener(this);
		fenetre.getCreerBouton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == fenetre.getAnnulerBouton())
		{
			//@todo add a popup where user have to confirm
			fenetre.dispose();
		}
		else 
			if(source == fenetre.getCreerBouton())
				{
					os.setNomOS(fenetre.getNomField().getText());
					os.setVersionOS(fenetre.getVersionField().getText());
					fenetre.dispose();
				}
	}

}
