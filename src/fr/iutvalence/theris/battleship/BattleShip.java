package fr.iutvalence.theris.battleship;

/**
 * @author Robin
 * battleship main
 */
public class BattleShip {
	
	/**
	 * the futur game.
	 */
	private static Game game;
	
	public static void main(String[] args) {
		
		game = new Game(new Player("Joueur 1"), new Player("Joueur 2"));
		game.play();

	}
	


}
