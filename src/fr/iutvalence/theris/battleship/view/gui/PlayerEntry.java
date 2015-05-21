package fr.iutvalence.theris.battleship.view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class PlayerEntry extends JPanel {

	/**
	 * TODO Javadoc
	 */
	private JSplitPane display;
	
	private JTextField nickname = new JTextField("nickname");
	
	private JLabel label = new JLabel("Player 1 :");
	
	public JSplitPane getDisplay() {
		return display;
	}
	
	public PlayerEntry() {
		Font police = new Font("Arial", Font.BOLD, 14);
		nickname.setFont(police);
		nickname.setPreferredSize(new Dimension(150, 30));
		nickname.setForeground(Color.BLUE);
		JPanel top = new JPanel();
	    top.add(label);
	    top.add(nickname);
	    display.add(top, BorderLayout.NORTH);
	    this.setVisible(true);            
	}

}
