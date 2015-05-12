package fr.iutvalence.theris.battleship;

/**
 * @author Robin
 * Joueur
 */
public class Player {

	/**
	 * pseudonyme du joueur
	 */
	private final String nickname;

	/**
	 * @param nickname
	 * créer une joueur à partir de son pseudonyme
	 */
	public Player(String nickname){
		this.nickname=nickname;
	}
	
	/**
	 * @return
	 * permet de récupérer le pseudonyme d'un joueur
	 */
	public String getNickname() {
		return nickname;
	}
}
