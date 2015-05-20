package com.java_s2.STRI.utils;

import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;

public class ImageIconLoader {
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        return new ImageIcon(path);
    }

    public static ImageIcon getLocal()
    {
    	return createImageIcon("images/Crystal_Clear_action_gohome.png");
    }
    
    public static ImageIcon getSalle()
    {
    	return createImageIcon("images/Crystal_Clear_device_blockdevice.png");
    }

    
    public static ImageIcon getTerminal()
    {
    	return createImageIcon("images/Crystal_Clear_app_klaptop.png");
    }
    
    public static ImageIcon getSwitch()
    {
    	return createImageIcon("images/Crystal_Clear_app_network.png");
    }
    
    public static ImageIcon getCarteReseau()
    {
    	return createImageIcon("images/Crystal_Clear_app_hardware.png");
    }

    public static ImageIcon getOS()
    {
    	return createImageIcon("images/Crystal_Clear_action_run.png");
    }

    public static ImageIcon getFirmware()
    {
    	return createImageIcon("images/Crystal_Clear_action_run.png");
    }
    
    

    public static DefaultTreeCellRenderer getTreeRenderLocal()
    {
    	DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    	renderer.setIcon(getLocal());
    	return renderer;
    }
    
    public static DefaultTreeCellRenderer getTreeRenderSalle()
    {
    	DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    	renderer.setIcon(getSalle());
    	return renderer;
    }

    
    public static DefaultTreeCellRenderer getTreeRenderTerminal()
    {
    	DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    	renderer.setIcon(getTerminal());
    	return renderer;
    }
    
    public static DefaultTreeCellRenderer getTreeRenderSwitch()
    {
    	DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    	renderer.setIcon(getSwitch());
    	return renderer;
    }
    
    public static DefaultTreeCellRenderer getTreeRenderCarteReseau()
    {
    	DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    	renderer.setIcon(getCarteReseau());
    	return renderer;
    }

    public static DefaultTreeCellRenderer getTreeRenderOS()
    {
    	DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    	renderer.setIcon(getOS());
    	return renderer;
    }

    public static DefaultTreeCellRenderer getTreeRenderFirmware()
    {
    	DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    	renderer.setIcon(getFirmware());
    	return renderer;
    }
    
}
