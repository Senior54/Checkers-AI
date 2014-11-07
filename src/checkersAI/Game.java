package checkersAI;

import java.util.Scanner;
public class Game {
	
	public Player human = new Player("R", 12);
	public Player comp = new Player("B", 12);
	public GameEngine engine;
	public boolean gameover;
	public int numPlayers;  // number of players, 2 for human, 1 for AI
	public char AI;  // the AI level of difficulty
	public int depth = 2;  // search depth for game tree
	
	
	public Game(){
		startGame();
	}
	
	public void startGame(){
		// do stuff
		engine = setUp();
		Scanner scan = new Scanner(System.in);
		begin(scan);
		GUI test = new GUI();
		//test.drawBoard(engine.grid);
		
		int[] moves = new int[2]; // array to hold moves to be made for each player
		
		while(!isEndOfGame()){
			
			//engine.boardToString();
			
			/*System.out.println(engine.getCurrentPLayer() + " please select a piece");
			String line = scan.nextLine();
			int currPos = Integer.parseInt(line);
			System.out.println(engine.getCurrentPLayer() + " please make a move");
			line = scan.nextLine();
			int endPos = Integer.parseInt(line);*/
			
			test.drawBoard(engine.grid);
			moves = test.getMove(engine, scan);
			
			/* not finished yet, just an idea
			if (engine.isValidPiece(moves[0])) { 
				if (engine.isLegalMove(moves)) {
					engine.move(moves);
				}
			}*/
			
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
	
	public GameEngine setUp(){
		
		gameover = false;
		engine = new GameEngine();
		return engine;
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
	
	public void begin(Scanner scan) {
		// display welcome screen and original prompts
		System.out.println("WELCOME TO CHECKERS!");
		System.out.println("1 Player or 2?");
		String line = scan.nextLine();
		numPlayers = Integer.parseInt(line);
		if (numPlayers == 1) {
			System.out.println("Easy, Normal, or Advanced AI?");
			line = scan.nextLine();
			AI = line.charAt(0);
			if (AI == 'E' || AI == 'e')
				depth = 2;
			else if (AI == 'N' || AI == 'n')
				depth = 4;
			else if (AI == 'A' || AI == 'A')
				depth = 6;
		}
		
	}
}
