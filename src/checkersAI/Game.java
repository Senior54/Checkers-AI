//package Checkers;
import java.util.Scanner;
public class Game {
	
	public Player human = new Player("red", 12);
	public Player comp = new Player("black", 12);
	public GameEngine engine;
	public boolean gameover;
	
	public Game(){
		startGame();
	}
	
	public void startGame(){
		// do stuff
		setUp();
		Scanner scan = new Scanner(System.in);
		while(!isEndOfGame()){
			
			engine.boardToString();
			
			System.out.println(engine.getCurrentPLayer() + " please select a piece");
			String line = scan.nextLine();
			int currPos = Integer.parseInt(line);
			System.out.println(engine.getCurrentPLayer() + " please make a move");
			line = scan.nextLine();
			int endPos = Integer.parseInt(line);
			
			
			
			if(!engine.isMoveMade())
			{
				try {
					this.wait(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			engine.updateCurrentPlayer();
		}
		scan.close();
	}
	
	public void setUp(){
		
		gameover = false;
		engine = new GameEngine();
	}

	public boolean isEndOfGame(){
		// check for a player having no more pieces
		if(comp.piecesLeft == 0 || human.piecesLeft == 0){
			return true;
		}
		// check if gameover is false
		return gameover;
	}
	
	public void resign(){
		gameover = true;
	}
}
