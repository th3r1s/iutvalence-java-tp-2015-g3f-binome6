package fr.iutvalence.theris.battleship;

import java.util.Scanner;

import fr.iutvalence.theris.battleship.model.Player;
import fr.iutvalence.theris.battleship.view.commandline.Game;

/**
 * @author Robin
 * battleship main
 */
public class BattleShip {
	
	/**
	 * the battleship game.
	 */
	private static Game game;
	
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		System.out.println("Write the player1's name?");
		String joueur1 = scan.next();
		System.out.println("Write the player2's name?");
		String joueur2 = scan.next();
		game = new Game(new Player(joueur1), new Player(joueur2));
		game.play();
		scan.close();
	}
	


}
