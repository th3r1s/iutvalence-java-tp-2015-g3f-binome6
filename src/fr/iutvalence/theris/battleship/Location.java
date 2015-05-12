package fr.iutvalence.theris.battleship;

/**
 * @author Robin
 *
 */
public class Location {

	/**
	 * ligne de la position
	 */
	private final int row;
	/**
	 * colonne de la postion
	 */
	private final int column;
	
	/**
	 * @param row
	 * @param column
	 * créer une position
	 */
	public Location(int row, int column) {
		this.row=row;
		this.column=column;
	}

	/**
	 * @return
	 * donne la ligne de la position
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return
	 * donne la colonne de la position
	 */
	public int getColumn() {
		return column;
	}
	
	
}
