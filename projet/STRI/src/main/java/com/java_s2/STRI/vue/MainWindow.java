package com.java_s2.STRI.vue;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// boutons
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	
	// model arborescence
	public DefaultMutableTreeNode rootTree; //@todo public pour le moment
	private DefaultTreeModel modelTree;
	
	// vue arborescence
	private JTree arborescense;
	// TODO a voir pour des icones perso par ex > http://commons.wikimedia.org/wiki/Crystal_Clear
	
	
	public MainWindow()
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
		bouton2 = new JButton(" supprimer ");
		bouton3 = new JButton(" actualiser ");
		// FIXME bouton «details»
		
		// creation modele de l'arborescense
		rootTree = new DefaultMutableTreeNode("Locaux");
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
		
		c.gridx = 2;
		monPanneau.add(bouton3, c); // ajout bouton3 au layout
		
		// TODO bouton «details»
		
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 3;
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
	
	public void clearAllComponent()
	{
		// suppression d'un noeud
		while(rootTree.getChildCount() > 0)
		{
			removeComponent(rootTree.getFirstLeaf());
		}
	}

	public JButton getBouton1() {
		return bouton1;
	}

	public JButton getBouton2() {
		return bouton2;
	}

	public JButton getBouton3() {
		return bouton3;
	}
	
	// TODO bouton «details»

	public JTree getTree() {
		return arborescense;
	}

	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	  public void expandAll() {
	    TreeNode root = (TreeNode) arborescense.getModel().getRoot();
	    expandAll(arborescense, new TreePath(root));
	  }

	  private void expandAll(JTree tree, TreePath parent) {
	    TreeNode node = (TreeNode) parent.getLastPathComponent();
	    if (node.getChildCount() >= 0) {
	      for (Enumeration e = node.children(); e.hasMoreElements();) {
	        TreeNode n = (TreeNode) e.nextElement();
	        TreePath path = parent.pathByAddingChild(n);
	        expandAll(tree, path);
	      }
	    }
	    tree.expandPath(parent);
	    // tree.collapsePath(parent);
	  }
}