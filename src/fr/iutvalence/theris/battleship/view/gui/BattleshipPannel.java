package fr.iutvalence.theris.battleship.view.gui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

/**
 * BattleShip's IHM converter. 
 * @author robinvi
 *
 */
public class BattleshipPannel implements Runnable {

	/**
	 * The window
	 */
	private JFrame window;
	
	/**
	 * TODO Javadoc
	 */
	private JSplitPane launcher;
	
	/**
	 * TODO Javadoc
	 */
	private JSplitPane init;
	
	/**
	 * TODO Javadoc
	 */
	private JSplitPane player;
	
	public void run() {  
		this.guiInitializer();
	}
	
	/**
	 * TODO Javadoc
	 */
	private void guiInitializer(){
		this.window = new JFrame("Test");
		this.window.setVisible(true);
		
		this.window.setSize(500, 500);
		this.window.setTitle("Battleship");
		this.window.setResizable(false);
		
		this.window.setJMenuBar(new BattleshipMenu(this.window));
		PlayerEntry player = new PlayerEntry();
		this.player=player.getDisplay();
		
		
	}
	
}
