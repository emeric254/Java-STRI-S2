package com.java_s2.STRI.controller.creation;

import java.awt.event.*;

import javax.swing.JOptionPane;

import com.java_s2.STRI.modele.InterfaceReseau;
import com.java_s2.STRI.vue.CreateInterfaceWindow;


public class CreateInterfaceWindowEventListener implements ActionListener
{
	private CreateInterfaceWindow fenetre;
	private InterfaceReseau interfaceReseau;
	
	public CreateInterfaceWindowEventListener(CreateInterfaceWindow pFenetre, InterfaceReseau pInterfaceReseau)
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
			if(JOptionPane.showConfirmDialog(fenetre, "Voulez vous vraiment annuler","Annuler ?",JOptionPane.YES_NO_OPTION) == 0)
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
