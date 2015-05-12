package fr.iutvalence.theris.battleship.boats;

/**
 * @author Robin
 * Enumeration des différentes tailles des différents bateaux
 */
public enum BoatSizes {

	DESTROYER(2),
	CRUISER(3),
	SUBMARINE(3),
	BATTLESHIP(4),
	AIRCRAFTCARRIER(5);
	
	/**
	 * taille d'un bateau
	 */
	private final int size;
	
	/**
	 * @param size
	 * défini le bateau selon sa taille
	 */
	private BoatSizes(int size){
		this.size = size;
	}

	/**
	 * @return
	 * donne la taille d'un type de bateau
	 */
	public int getSize() {
		return size;
	}
	
}
