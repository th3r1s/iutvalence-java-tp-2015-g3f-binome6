package fr.iutvalence.theris.battleship;

import fr.iutvalence.theris.battleship.boats.Boat;

public class Box {

	private final Location location;
	
	private boolean hitted;
	
	private Boat boat;


	public Box(Location location) {
		this.location = location;
		this.boat = null;
	}


	public Boat getBoat() {
		return boat;
	}


	public void setBoat(Boat boat) {
		this.boat = boat;
	}


	public Location getLocation() {
		return location;
	}
	
	
	
	public boolean isHitted() {
		return hitted;
	}


	public void hit() {
		this.hitted = true;
		if(this.boat != null)
			this.boat.isHitted();
	}


	public String toString(){
		if(this.boat != null){
			if(hitted && !boat.isSinked())
				return "o";
			if(hitted && boat.isSinked())
				return "X";
			if(!hitted && !boat.isSinked())
				return "B";
					
		}
		return (hitted ? "x" : "*");
	}
}
