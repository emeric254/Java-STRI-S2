package com.java_s2.STRI.controller;

import java.awt.event.*;

import javax.swing.tree.*;

import com.java_s2.STRI.vue.createInterfaceWindow;


public class createInterfaceWindowEventListener implements ActionListener
{
	private createInterfaceWindow fenetre;
	
	public createInterfaceWindowEventListener(createInterfaceWindow pFenetre)
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
