package fr.iutvalence.theris.battleship;

import fr.iutvalence.theris.battleship.boats.Boat;

/**
 * @author Robin
 *
 */
/**
 * @author Robin
 *
 */
public class Box {

	/**
	 * Position d'une case
	 */
	private final Location location;
	
	/**
	 * Case touchée ?
	 */
	private boolean hitted;
	
	/**
	 * Si un bateau est posé sur la case
	 */
	private Boat boat;


	/**
	 * @param location
	 * Créer une case selon une position
	 */
	public Box(Location location) {
		this.location = location;
		this.boat = null;
	}


	/**
	 * @return
	 * Récupère le bateau qui est sur la case
	 */
	public Boat getBoat() {
		return boat;
	}

	/**
	 * @param boat
	 * Place un bateau sur la case
	 */
	public void setBoat(Boat boat) {
		this.boat = boat;
	}


	/**
	 * @return
	 * Donne la position de la case
	 */
	public Location getLocation() {
		return location;
	}
	
	
	
	/**
	 * @return
	 * Dis si la case est touchée
	 */
	public boolean isHitted() {
		return hitted;
	}


	/**
	 * Touche la case et le bateau dessus si il existe
	 */
	public void hit() {
		this.hitted = true;
		if(this.boat != null)
			this.boat.isHitted();
	}


	/**
	 * @param foe
	 * @return
	 * toString d'une case. Foe permet de gérer l'affichage entre les deux plateaux
	 */
	public String toString(boolean foe){
		if(this.boat != null){
			if(hitted && !boat.isSinked())
				return "o";
			if(hitted && boat.isSinked())
				return "X";
			if(!hitted && !boat.isSinked()){
				if(!foe)
					return "B";
				else
					return "*";
			}
			
					
		}
		return (hitted ? "x" : "*");
	}
}
