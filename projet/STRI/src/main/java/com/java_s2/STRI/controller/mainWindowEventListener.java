package com.java_s2.STRI.controller;

import java.awt.event.*;
import javax.swing.tree.*;

import com.java_s2.STRI.vue.mainWindow;


public class mainWindowEventListener implements ActionListener
{
	private mainWindow fenetre;
	
	public mainWindowEventListener(mainWindow pFenetre)
	{
		fenetre = pFenetre;
		fenetre.getBouton1().addActionListener(this);
		fenetre.getBouton2().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == fenetre.getBouton1())
			fenetre.addComponent(fenetre.rootTree,new DefaultMutableTreeNode("node - "+fenetre.rootTree.getChildCount()));
		else 
			if(source == fenetre.getBouton2())
				fenetre.removeComponent(fenetre.rootTree.getLastLeaf());
	}

}
