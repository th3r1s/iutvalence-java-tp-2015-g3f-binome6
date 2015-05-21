package fr.iutvalence.theris.battleship.view.gui;


//TODO Javadoc on this page


import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class BattleshipMenu extends JMenuBar {

	private JFrame window;
	
	private JMenuItem AboutMenuItem;
	
	private JMenuItem CloseMenuItem;
	
	/**
	 * 
	 */
	public BattleshipMenu(JFrame window) {
		this.window=window;
		JMenu menu = new JMenu("Menu");
		
		this.AboutMenuItem = new JMenuItem("About");
		this.CloseMenuItem = new JMenuItem("Close");
		menu.add(this.AboutMenuItem);
		menu.add(this.CloseMenuItem);
		//this.AboutMenuItem.addActionListener(this);
		//this.CloseMenuItem.addActionListener(this);
		
		this.add(menu);
	}

	
	
}
