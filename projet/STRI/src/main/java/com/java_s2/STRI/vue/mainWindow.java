package com.java_s2.STRI.vue;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;

public class mainWindow extends JFrame implements ActionListener {

	private JButton bouton1;
	private JButton bouton2;
	private DefaultMutableTreeNode rootTree;
	private DefaultTreeModel modelTree;
	private JTree arborescense;
	
	public mainWindow(){
		super("STRI - Managing Tool");
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(320,240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
		pack();
		setVisible(true);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private JPanel buildContentPane(){
		JPanel monPanneau = new JPanel(new GridBagLayout());
		
		bouton1 = new JButton(" creer ");
		bouton1.addActionListener(this);
		
		bouton2 = new JButton(" supprimer ");
		bouton2.addActionListener(this);
		
		rootTree = new DefaultMutableTreeNode("/");
		modelTree = new DefaultTreeModel(rootTree);
		
		arborescense = new JTree(modelTree);
		arborescense.setShowsRootHandles(true);
//		arborescense.setRootVisible(false);
		
		JScrollPane scrollPaneE = new JScrollPane(arborescense);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10,5,5,5);
		monPanneau.add(bouton1, c);
		
		c.gridx = 1;
		monPanneau.add(bouton2, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 2;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1.0;
		c.weightx = 1.0;
		c.insets = new Insets(5,0,0,0); // top, left, bottom, right ;)
		monPanneau.add(scrollPaneE, c);
		
		return monPanneau;
	}
	
	public void addComponent(MutableTreeNode parent, MutableTreeNode child)
	{
		modelTree.insertNodeInto(child, parent, parent.getChildCount());
	}
	
	public void removeComponent(MutableTreeNode child)
	{
		modelTree.removeNodeFromParent(child);
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/** gestionnaire d'évènement : **/
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == bouton1)
			addComponent(rootTree,new DefaultMutableTreeNode("creer "+rootTree.getChildCount()));
		else 
			if(source == bouton2)
				removeComponent(rootTree.getLastLeaf());
	}
}