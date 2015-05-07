package fr.iutvalence.theris.battleship.boats;

public enum BoatSizes {

	DESTROYER(2),
	CRUISER(3),
	SUBMARINE(3),
	BATTLESHIP(4),
	AIRCRAFTCARRIER(5);
	
	private final int size;
	
	private BoatSizes(int size){
		this.size = size;
	}

	public int getSize() {
		return size;
	}
	
}
