package fr.iutvalence.theris.battleship.view.gui;

import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

/**
 * BattleShip's IHM converter. 
 * @author robinvi
 *
 */
public class BattleshipPanel implements Runnable {

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
	private JPanel init;
	
	/**
	 * TODO Javadoc
	 */
	
	private JPanel players;
	
	private JButton playButton;
	
	public void run() {  
		this.guiInitializer();
	}
	
	/**
	 * TODO Javadoc
	 */
	private void guiInitializer(){
		this.window = new JFrame("Test");
		this.window.setVisible(true);

		this.window.setSize(510, 510);
		this.window.setTitle("Battleship");
		this.window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.window.setJMenuBar(new BattleshipMenu(this.window));
		players = new PlayerPanel();
	    Border border = BorderFactory.createTitledBorder("Joueurs" );
	    players.setBorder(border);
	    
		this.init = new JPanel();
		init.add(players);
		playButton = new JButton("Lancer la partie");
		init.add(playButton);
		window.add(init);
	}
	
}
