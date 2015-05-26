package fr.iutvalence.theris.battleship.view.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

import fr.iutvalence.theris.battleship.view.gui.buttons.Play;

public class Launcher extends JSplitPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Launcher(BattleshipPanel battleshipPanel) {
		super(JSplitPane.VERTICAL_SPLIT);
		battleshipPanel.getWindow().setJMenuBar(new BattleshipMenu(battleshipPanel.getWindow()));
		
		JPanel players = new PlayerPanel();
	    Border border = BorderFactory.createTitledBorder("Joueurs" );
	    players.setBorder(border);
	    
		JPanel init = new JPanel();
		Play playButton = new Play("Lancer la partie", battleshipPanel);
		init.add(playButton);
		
		add(players);
		add(init);
		
		setDividerSize(0);
	}

}
