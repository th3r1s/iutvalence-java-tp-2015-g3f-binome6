package fr.iutvalence.theris.battleship.view.gui;

import java.awt.Image;

import javax.security.auth.callback.LanguageCallback;
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
	private Launcher launcher;
	
	/**
	 * TODO Javadoc
	 */
	
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

		this.window.setSize(510, 175);
		this.window.setTitle("Battleship");
		this.window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		launcher = new Launcher(this);
		window.setContentPane(launcher);

	}
	
	public JFrame getWindow() {
		return window;
	}
	
}
