package fr.iutvalence.theris.battleship;

/**
 * @author Robin
 * main de la bataille navale. Permet de créer une partie (game)
 */
public class BattleShip {
	
	/**
	 * Partie du jeu
	 */
	private static Game game;
	
	public static void main(String[] args) {
		
		game = new Game(new Player("Joueur 1"), new Player("Joueur 2"));
		game.play();

	}
	


}
