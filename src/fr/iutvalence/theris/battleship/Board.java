package fr.iutvalence.theris.battleship;

import fr.iutvalence.theris.battleship.boats.Boat;

/**
 * @author Robin
 * board.
 */
public class Board {

	/**
	 * default number of board's rows.
	 */
	private static final int NB_ROWS = 10;
	/**
	 * default number of board's columns.
	 */
	private static final int NB_COLUMNS = 10;
	
	/**
	 * number of board's rows.
	 */
	private final int rows;
	/**
	 * number of board's columns.
	 */
	private final int columns;
	
	/**
	 * box table of the board.
	 */
	private final Box box[][];
	
	/**
	 * board builder.
	 * @param rows
	 * @param columns
	 */
	public Board(int rows, int columns) {
		this.rows=columns;
		this.columns=rows;
		this.box= new Box[NB_ROWS][NB_COLUMNS];
		
		for(int nbRow = 0; nbRow<rows;nbRow++){
			for(int nbCol = 0;nbCol<columns;nbCol++){
				this.box[nbRow][nbCol]=new Box(new Location(nbRow,nbCol));
			}
		}
		
	}
	
	/**
	 * allow to create a board.
	 */
	public Board() {
		this(NB_ROWS, NB_COLUMNS);
	}
	
	/**
	 * allow to create a boat and to put it on the board. Check if there is no boats overlap.
	 * @param direction of the added boat
	 * @param location of the added boat
	 * @param boat : type of the added boat
	 * @return 
	 */
	public boolean createBoat(Direction direction, Location location, Boat boat) {
		Box[] relativesBoxes = boat.getRelativesBoxes();
		relativesBoxes[0] = getBox(location);
		boolean verif = false;
		for (int i = 1; i < boat.getSize(); i++) {
			relativesBoxes[i] = getNextBox(direction, relativesBoxes[i - 1]);
		}
		int i = 0;
		while (i < boat.getSize()) {
			if (relativesBoxes[i].getBoat() == null) {
				i++;
			} else {
				verif = true;
				System.err.println("Erreur : il y a un chevauchement de bateaux");
				break;
			}
		}
		if (!verif) {
			try {
				relativesBoxes[0].setBoat(boat);
				for (i = 1; i < boat.getSize(); i++) {
					relativesBoxes[i] = getNextBox(direction,
							relativesBoxes[i - 1]);
					relativesBoxes[i].setBoat(boat);
				}
			} catch (ArrayIndexOutOfBoundsException out) {
				System.out.println("Erreur : le bateau ne rentre pas dans le tableau");
				for (i = 0; i < boat.getSize(); i++) {
					if (relativesBoxes[i] == null)
						break;
					relativesBoxes[i].setBoat(null);
				}
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * method allowing to get the next box according to the direction.
	 * @param direction allowing to know which box we want to get
	 * @param firstBox : the box from the method is used
	 * @return
	 */
	private Box getNextBox(Direction direction, Box firstBox){
		switch(direction){
		case NS : return getBottomBox(firstBox.getLocation());
		case SN : return getUpperBox(firstBox.getLocation());
		case EW : return getLeftBox(firstBox.getLocation());
		case WE : return getRightBox(firstBox.getLocation());
		default:
			return null;
		}
	}
	
	/**
	 * allow to get a box according to a row and a column.
	 * @param row of the box
	 * @param column of the box
	 * @return the box we need to get
	 */
	public Box getBox(int row, int column){
		return this.box[row][column];
	}

	/**
	 * allow to get a box according to a location.
	 * @param location of the box
	 * @return the box we need to get
	 */
	public Box getBox(Location location){
		return getBox(location.getRow(), location.getColumn());
	}
	
	/**
	 * allow to get the bottom box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	public Box getBottomBox(Location location){
		return this.box[location.getRow()+1][location.getColumn()];
	}
	
	/**
	 * allow to get the upper box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	public Box getUpperBox(Location location){
		return this.box[location.getRow()-1][location.getColumn()];
	}
	
	/**
	 * allow to get the left box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	public Box getLeftBox(Location location){
		return this.box[location.getRow()][location.getColumn()-1];
	}
	
	/**
	 * allow to get the right box of the location.
	 * @param location from the method is used
	 * @return the box we need to get
	 */
	public Box getRightBox(Location location){
		return this.box[location.getRow()][location.getColumn()+1];
	}
	
	/**
	 * allow to get rows.
	 * @return row
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * allow to get columns.
	 * @return column
	 */
	public int getColumns() {
		return columns;
	}
	
	
	/**
	 * hit a box except if the hit is not on the board.
	 * @param position where we want to hit
	 * @return boolean : hit / not hit
	 */
	public boolean hit(Location position) {
		try{
		getBox(position).hit();
		return true;}
		catch(ArrayIndexOutOfBoundsException out){
			System.out.println("Erreur : le tir ne rentre pas dans le tableau");
			return false;
		}
		
	}
	
	/**
	 * board toString. Foe allow to differentiate the player's board and the foe's board.
	 * @param foe : for the foe's board
	 * @return str : local variable with the string
	 */
	public String toString(boolean foe){
		String str = "";
		for(int nbRow = 0; nbRow<rows;nbRow++){
			str += "\n";
			for(int nbCol = 0;nbCol<columns;nbCol++){
				str += this.box[nbRow][nbCol].toString(foe);
			}
		}
		
		return str;
	}
	
	
}