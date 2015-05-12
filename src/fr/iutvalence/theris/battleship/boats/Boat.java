package fr.iutvalence.theris.battleship.boats;

import fr.iutvalence.theris.battleship.Box;

/**
 * @author Robin
 *Classe bateau dont est issus les bateaux
 */
public abstract class Boat {
	
	/**
	 * Taille d'un bateau
	 */
	private final int size;
	
	/**
	 * Vie d'un bateau
	 */
	private int life;
	
	/**
	 * liste des cases relatives au bateau
	 */
	private final Box[] relativesBoxes;

	/**
	 * @param size
	 * @param direction
	 * @param relativesBoxes
	 * Créer une bateau (constructeur)
	 */
	public Boat(int size){
		this.size = size;
		this.life = size;
		relativesBoxes = new Box[size];
	}

	/**
	 * @return
	 * Donne la taille du bateau
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Le bateau est touché et perd de la vie
	 */
	public void isHitted() {
		this.life--;
	}
	
	/**
	 * @return
	 * Le bateau est coulé car il n'a plus de vie
	 */
	public boolean isSinked() {
		return(life==0 ? true : false);
	}

	/**
	 * @return
	 * donne la liste des cases relatives au bateau
	 */
	public Box[] getRelativesBoxes() {
		return relativesBoxes;
	}

}
