package com.java_s2.STRI.vue;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;

public class mainWindow extends JFrame implements ActionListener {

	// boutons
	private JButton bouton1;
	private JButton bouton2;
	
	// model arborescence
	private DefaultMutableTreeNode rootTree;
	private DefaultTreeModel modelTree;
	
	// vue arborescence
	private JTree arborescense;
	
	
	public mainWindow()
	{
		super("STRI - Managing Tool");
	
		// position sur bureau
		setLocationRelativeTo(null);
		// dimensions minimales
		setMinimumSize(new Dimension(320,240));
		
		// quand appui sur la "croix" fermer >>> quitter l'applis
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ajout composants
		setContentPane(buildContentPane());
		// maj taille fenetre et composants selon ces derniers
		pack();
		// afficher la fenetre
		setVisible(true);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private JPanel buildContentPane()
	{
		// layout de fond
		JPanel monPanneau = new JPanel(new GridBagLayout());
		
		//creation boutons
		bouton1 = new JButton(" creer ");
		bouton1.addActionListener(this);
		bouton2 = new JButton(" supprimer ");
		bouton2.addActionListener(this);
		
		// creation modele de l'arborescense
		rootTree = new DefaultMutableTreeNode("/");
		modelTree = new DefaultTreeModel(rootTree);
		
		// creation vue de l'arborescense
		arborescense = new JTree(modelTree);
		arborescense.setShowsRootHandles(true);
//		arborescense.setRootVisible(false);
		
		// ajout de cette vue dans un composant qui permet une barre de defilement
		JScrollPane scrollPaneE = new JScrollPane(arborescense);
		
		// definition contriantes du layout
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10,5,5,5);
		monPanneau.add(bouton1, c); // ajout bouton1 au layout
		
		c.gridx = 1;
		monPanneau.add(bouton2, c); // ajout bouton2 au layout
		
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 2;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1.0;
		c.weightx = 1.0;
		c.insets = new Insets(5,0,0,0); // top, left, bottom, right ;)
		monPanneau.add(scrollPaneE, c); // ajout arborescense avec barre de defilement au layout
		
		return monPanneau;
	}
	
	public void addComponent(MutableTreeNode parent, MutableTreeNode child)
	{
		// ajout du noeud comme fils d'un parent
		modelTree.insertNodeInto(child, parent, parent.getChildCount());
	}
	
	public void removeComponent(MutableTreeNode child)
	{
		// suppression d'un noeud
		modelTree.removeNodeFromParent(child);
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//@TODO a bouger tout ce qui suit vers package controller !
	
	/** gestionnaire d'évènement : **/
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == bouton1)
			addComponent(rootTree,new DefaultMutableTreeNode("node - "+rootTree.getChildCount()));
		else 
			if(source == bouton2)
				removeComponent(rootTree.getLastLeaf());
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}