package fr.iutvalence.theris.battleship;

import javax.swing.SwingUtilities;

import fr.iutvalence.theris.battleship.view.gui.BattleshipPannel;

/**
 * @author Robin
 * battleship main
 */
public class BattleShip {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new BattleshipPannel());
		
		
		
		/*	Scanner scan  = new Scanner(System.in);
		System.out.println("Write the player1's name?");
		String joueur1 = scan.next();
		System.out.println("Write the player2's name?");
		String joueur2 = scan.next();
		Game game = new Game(new Player(joueur1), new Player(joueur2));
		game.play();
		scan.close();*/
	}
	


}
