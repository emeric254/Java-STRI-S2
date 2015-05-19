package com.java_s2.STRI.vue;

import java.awt.*;

import javax.swing.*;

public class CreateIntercoWindow extends CreateWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> app;
	
	
	public CreateIntercoWindow()
	{
		super("Interco de «Appareils»");
		buildContentPane();
		pack();
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void buildContentPane()
	{
		app = new JComboBox<String>();
		
		// definition contraintes du layout
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,15,10,15);
		c.gridx = 0;
		c.gridy = 0;
		getContenuPanel().add(new JLabel("appareil "), c);
		c.gridx = 1;
		getContenuPanel().add(app, c);

		
	}
	
	public JComboBox<String> getAppareil(){
		return app;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
