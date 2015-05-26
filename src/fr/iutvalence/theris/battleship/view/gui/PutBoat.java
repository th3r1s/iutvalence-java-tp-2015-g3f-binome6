package fr.iutvalence.theris.battleship.view.gui;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class PutBoat extends JSplitPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PutBoat(BattleshipPanel battleshipPanel) {
		
		JSplitPane buttons = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JButton quit = new JButton("Quitter");
		JButton restart = new JButton("Restart");
		buttons.add(restart);
		buttons.add(quit);
		
		JSplitPane play_buttons = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JPanel game = new JPanel();
		play_buttons.add(game);
		play_buttons.add(buttons);
		
		JSplitPane pb_texte = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JPanel texte = new JPanel();
		// ...
		
		
	}

}
