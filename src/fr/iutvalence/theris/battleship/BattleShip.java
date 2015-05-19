package fr.iutvalence.theris.battleship;

import java.util.Scanner;

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
		System.out.println("Quel est le pseudonyme du joueur 1 ?");
		String joueur1 = scan.next();
		System.out.println("Quel est le pseudonyme du joueur 2 ?");
		String joueur2 = scan.next();
		game = new Game(new Player(joueur1), new Player(joueur2));
		game.play();
		scan.close();
	}
	


}
