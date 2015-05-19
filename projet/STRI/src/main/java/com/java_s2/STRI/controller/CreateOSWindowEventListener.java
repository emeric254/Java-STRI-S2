package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.JOptionPane;

import com.java_s2.STRI.modele.SystemeExploitation;
import com.java_s2.STRI.vue.creation.CreateOSWindow;


public class CreateOSWindowEventListener implements ActionListener
{
	private CreateOSWindow fenetre;
	private SystemeExploitation os;
	
	public CreateOSWindowEventListener(CreateOSWindow pFenetre, SystemeExploitation pOS)
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
			if(JOptionPane.showConfirmDialog(fenetre, "Voulez vous vraiment annuler","Annuler ?",JOptionPane.YES_NO_OPTION) == 0)
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
