package fr.iutvalence.theris.battleship;

import java.util.Scanner;

import fr.iutvalence.theris.battleship.boats.AircraftCarrier;
import fr.iutvalence.theris.battleship.boats.Battleship;
import fr.iutvalence.theris.battleship.boats.Boat;
import fr.iutvalence.theris.battleship.boats.Cruiser;
import fr.iutvalence.theris.battleship.boats.Destroyer;
import fr.iutvalence.theris.battleship.boats.Submarine;

public class Game {

	private Board boardPlayer1;
	
	private Board boardPlayer2;
	
	private Player player1;
	
	private Player player2;
	
	private int turn;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		
		boardPlayer1 = new Board();
		boardPlayer2 = new Board();
		
		turn = 0;
	}
	
	public void play(){
		init();
		while(!end()){
			
		}
		
	}
	
	public void init(){
		Scanner scan = new Scanner(System.in);
		while(turn != 10){
			Player currentPlayer = (turn%2 == 0 ? player1 : player2);
			Board currentBoard = (turn%2 == 0 ? boardPlayer1 : boardPlayer2);
			System.out.println("Ligne où poser le bateau");
			int row = scan.nextInt();
			System.out.println("Colonne où poser le bateau");
			int col = scan.nextInt();
			Location location;
			if(col > -1 && col < currentBoard.getColumns() && row > -1 && row < currentBoard.getRows())
				location = new Location(row, col);
			else{
				System.out.println("Position en dehors du tableau");
				continue;
			}
			System.out.println("Direction du bateau {NS, SN, WE, EW}");
			Direction direction;
			try{
				direction = Direction.valueOf(scan.next());
			}catch(IllegalArgumentException e){System.out.println("Mauvaise direction"); continue;};
			
			System.out.println("Type de bateau {Aircraft, BattleShip, Cruiser, Destroyer, Submarine}");
			
			String type = scan.next();
			
			Boat boat;
			
			switch(type.toLowerCase()){
			case "destroyer" : boat = new Destroyer(); break;
			case "cruiser" : boat = new Cruiser(); break;
			case "aircraft" : boat = new AircraftCarrier(); break;
			case "submarine" : boat = new Submarine(); break;
			case "battleship" : boat = new Battleship(); break;
			default : System.out.println("Mauvais choix de bateau"); continue;
			}
			
			if(currentBoard.createBoat(direction, location,(Boat) boat)){
				turn++;
				System.out.println(currentPlayer.getNickname());
				System.out.println(currentBoard.toString(false));
			}
			
		}
		scan.close();
	}
	
	public boolean end(){
		// TODO Fin du jeu
		return false;
	}

}
