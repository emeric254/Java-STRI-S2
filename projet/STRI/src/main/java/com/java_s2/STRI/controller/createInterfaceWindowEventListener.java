package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.tree.*;

import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.vue.createInterfaceWindow;


public class createInterfaceWindowEventListener implements ActionListener
{
	private createInterfaceWindow fenetre;
	private InterfaceReseau interfaceReseau;
	
	public createInterfaceWindowEventListener(createInterfaceWindow pFenetre, InterfaceReseau pInterfaceReseau)
	{
		fenetre = pFenetre;
		
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
				interfaceReseau.setNomInterface(fenetre.getNomField().getText());
				//interfaceReseau.setAdresseMAC(new Integer(fenetre.getMACField().getText().replace(':',' ').trim()));
				fenetre.dispose();
			}
	}

}
