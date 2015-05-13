package fr.iutvalence.theris.battleship;

import fr.iutvalence.theris.battleship.boats.Boat;

/**
 * @author Robin
 * Plateau
 */
public class Board {

	/**
	 * Nombre de ligne standard d'un plateau
	 */
	private static final int NB_ROWS = 10;
	/**
	 * Nombre de colonnes standard d'un plateau
	 */
	private static final int NB_COLUMNS = 10;
	
	/**
	 *  Nombre de ligne d'un plateau
	 */
	private final int rows;
	/**
	 * Nombre de colonnes d'un plateau
	 */
	private final int columns;
	
	/**
	 * Tableau de cases composants le plateau
	 */
	private final Box box[][];
	
	/**
	 * @param rows
	 * @param columns
	 * Constructeur d'une plateau
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
	 * Permet de créer le plateau
	 */
	public Board() {
		this(NB_ROWS, NB_COLUMNS);
	}
	
	/**
	 * @param direction
	 * @param location
	 * @param boat
	 * @return Permet de créer un bateau et de le placer sur le plateau Vérifie
	 *         si il n'y a pas de chevauchement de bateau
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
			if (relativesBoxes[i].getBoat() != null) {
				i++;
			} else {
				verif = true;
				System.err
						.println("Erreur : il y a un chevauchement de bateaux");
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
				System.out
						.println("Erreur : le bateau ne rentre pas dans le tableau");
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
	 * @param direction
	 * @param firstBox
	 * @return
	 * Methode permettant d'avoir la case suivante selon la direction
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
	 * @param row
	 * @param column
	 * @return
	 * Permet de récupérer une case selon une ligne et une colonne
	 */
	public Box getBox(int row, int column){
		return this.box[row][column];
	}

	/**
	 * @param location
	 * @return
	 * Permet de récupérer une case selon un emplacement
	 */
	public Box getBox(Location location){
		return getBox(location.getRow(), location.getColumn());
	}
	
	/**
	 * @param location
	 * @return
	 * Permet de récupérer la case inférieure à l'emplacement donné
	 */
	public Box getBottomBox(Location location){
		return this.box[location.getRow()+1][location.getColumn()];
	}
	
	/**
	 * @param location
	 * @return
	 * Permet de récupérer la case supérieure à l'emplacement donné
	 */
	public Box getUpperBox(Location location){
		return this.box[location.getRow()-1][location.getColumn()];
	}
	
	/**
	 * @param location
	 * @return
	 * Permet de récupérer la case à gauche de l'emplacement donné
	 */
	public Box getLeftBox(Location location){
		return this.box[location.getRow()][location.getColumn()-1];
	}
	
	/**
	 * @param location
	 * @return
	 * Permet de récupérer la case inférieure à l'emplacement donné
	 */
	public Box getRightBox(Location location){
		return this.box[location.getRow()][location.getColumn()+1];
	}
	
	/**
	 * @return
	 * Permet de récupérer les lignes
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @return
	 * Permet de récupérer les colonnes
	 */
	public int getColumns() {
		return columns;
	}
	
	
	/**
	 * @param position
	 * @return
	 * Touche une case sauf si le tir n'est pas dans le plateau
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
	 * @param foe
	 * @return
	 * toString d'un plateau. Foe permet de gérer l'affichage entre les deux plateaux
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