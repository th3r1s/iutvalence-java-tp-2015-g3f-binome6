package fr.iutvalence.theris.battleship;

import fr.iutvalence.theris.battleship.boats.Boat;

public class Board {

	private static final int NB_ROWS = 10;
	private static final int NB_COLUMNS = 10;
	
	private final int rows;
	private final int columns;
	
	private final Box box[][];
	
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
	
	public Board() {
		this(NB_ROWS, NB_COLUMNS);
	}
	
	public void createBoat(Direction direction, Location location, Boat boat){
		Box[] relativesBoxes = boat.getRelativesBoxes();
		relativesBoxes[0] = getBox(location);
		relativesBoxes[0].setBoat(boat);
		try{
		for(int i=1;i<boat.getSize();i++){
			relativesBoxes[i] = getNextBox(direction, relativesBoxes[i-1]);
			relativesBoxes[i].setBoat(boat);
		}
		}catch(ArrayIndexOutOfBoundsException out)
		{System.out.println("Erreur : le bateau ne rentre pas dans le tableau");
		for(int i=0;i<boat.getSize();i++){
			if(relativesBoxes[i] == null)
				break;
			relativesBoxes[i].setBoat(null);
		}}
		
	}
	
	
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
	
	public Box getBox(int row, int column){
		return this.box[row][column];
	}

	public Box getBox(Location location){
		return getBox(location.getRow(), location.getColumn());
	}
	
	public Box getBottomBox(Location location){
		return this.box[location.getRow()+1][location.getColumn()];
	}
	
	public Box getUpperBox(Location location){
		return this.box[location.getRow()-1][location.getColumn()];
	}
	
	public Box getLeftBox(Location location){
		return this.box[location.getRow()][location.getColumn()-1];
	}
	
	public Box getRightBox(Location location){
		return this.box[location.getRow()][location.getColumn()+1];
	}
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	
	public Boat hit(Location position) {
		try{
		getBox(position).hit();
		return getBox(position).getBoat();}
		catch(ArrayIndexOutOfBoundsException out){
			System.out.println("Erreur : le tir ne rentre pas dans le tableau");
			return null;
		}
		
	}
	
	public String toString(){
		String str = "";
		for(int nbRow = 0; nbRow<rows;nbRow++){
			str += "\n";
			for(int nbCol = 0;nbCol<columns;nbCol++){
				str += this.box[nbRow][nbCol].toString();
			}
		}
		
		return str;
	}
	
	
}