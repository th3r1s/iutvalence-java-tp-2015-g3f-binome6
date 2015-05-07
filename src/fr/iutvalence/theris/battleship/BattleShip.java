package fr.iutvalence.theris.battleship;

import fr.iutvalence.theris.battleship.boats.AircraftCarrier;
import fr.iutvalence.theris.battleship.boats.Cruiser;
import fr.iutvalence.theris.battleship.boats.Destroyer;

public class BattleShip {
	
	public static void main(String[] args) {
		
		Board board = new Board();
		board.createBoat(Direction.NS, new Location(0, 0), new AircraftCarrier());
		board.createBoat(Direction.NS, new Location(9, 9), new Cruiser());
		board.createBoat(Direction.EW, new Location(5, 5), new Destroyer());
		board.hit(new Location(5,5));
		board.hit(new Location(5,4));
		board.hit(new Location(2,4));
		board.hit(new Location(1,0));
		board.hit(new Location(12,0));
		System.out.println(board.toString());
	}

}
