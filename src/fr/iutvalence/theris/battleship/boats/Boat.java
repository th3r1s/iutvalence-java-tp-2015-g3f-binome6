package fr.iutvalence.theris.battleship.boats;

import fr.iutvalence.theris.battleship.Box;

public abstract class Boat {
	
	private final int size;
	
	private int life;
	
	private final Box[] relativesBoxes;

	/**
	 * @param size
	 * @param direction
	 * @param relativesBoxes
	 */
	public Boat(int size){
		this.size = size;
		this.life = size;
		relativesBoxes = new Box[size];
	}

	public int getSize() {
		return size;
	}

	public void isHitted() {
		this.life--;
	}
	
	public boolean isSinked() {
		return(life==0 ? true : false);
	}

	public Box[] getRelativesBoxes() {
		return relativesBoxes;
	}

}
