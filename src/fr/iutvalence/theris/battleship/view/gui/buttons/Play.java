package fr.iutvalence.theris.battleship.view.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.iutvalence.theris.battleship.view.gui.BattleshipPanel;

public class Play extends JButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BattleshipPanel battleshipPanel;

	public Play(String name, BattleshipPanel battleshipPanel) {
		super(name);
		this.battleshipPanel = battleshipPanel;
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel j = new JPanel();
		battleshipPanel.getWindow().setContentPane(j);
		battleshipPanel.getWindow().setSize(510, 510);
		battleshipPanel.getWindow().revalidate();
		battleshipPanel.getWindow().setLocationRelativeTo(null);
		
	}
	
	

}
