package com.bitguiders.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Splash extends JWindow {

	   public void showSplashWindow()
	    {
	      URL url = this.getClass().getResource("images/ejt.png");
	      
	      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	      ImageIcon icon =new ImageIcon(url);
	      Cursor c = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
	      getContentPane().add(new JLabel(icon));
	      setCursor(c);
	      pack();
	      setLocation((d.width- icon.getIconWidth())/2,(d.height-icon.getIconHeight())/2);
	      setBackground(new Color(138,157,170));
	      setVisible(true);
	      try
	      {
	        Thread.sleep(8000);
	      }
	      catch(InterruptedException ie)
	      {

	      }
	      dispose();
	    }
}
