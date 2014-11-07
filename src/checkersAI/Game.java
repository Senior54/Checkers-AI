package checkersAI;
import java.util.Scanner;
public class Game {
	
	public Player human = new Player("red", 12);
	public AI computer = new AI("black", 12);
	public GameEngine engine;
	public boolean gameover;
	
	public Game(){
		startGame();
	}
	
	public void startGame(){
		setUp();
		Scanner scan = new Scanner(System.in);
		while(!isEndOfGame()){
			
			engine.printBoard();
			if(engine.getCurrentPLayer().equals("red"))
			{	// Human's turn...
				boolean validPiece = false;
				System.out.println(engine.getCurrentPLayer() + " Please select a piece");
				String line = scan.nextLine();
				int currPos = Integer.parseInt(line);
				while(!validPiece){
					if( (currPos > 0) && (currPos < 33) && 
							(engine.board[currPos] != null) &&
							engine.board[currPos].getColor().equals("r"))
					{
						// The user has given input which is within the board size,
						// and the square in the board is holding a users's red piece.
						validPiece = true;
					}else{
						System.out.println("Invalid position number\n" +
								engine.getCurrentPLayer() + " Please select a piece");
						line = scan.nextLine();
						currPos = Integer.parseInt(line);
					}
				}

				boolean validMove = false;
				System.out.println(engine.getCurrentPLayer() + " Please make a move");
				line = scan.nextLine();
				int endPos = Integer.parseInt(line);
				while(!validMove){
					if(engine.board[endPos] == null)
					{
						// The user has chosen an open square on the board to move to.
						validMove = true;
					}else{
						System.out.println("Cannot move here\n" +
								engine.getCurrentPLayer() + " Please make a move");
						line = scan.nextLine();
						endPos = Integer.parseInt(line);
					}
				}
				
				// Updating board to show the move made by the user.
				Piece p = engine.board[currPos];
				engine.board[currPos] = null;
				engine.board[endPos] = p;
				
			} else if(engine.getCurrentPLayer().equals("black"))
			{	// Computer's turn
				System.out.println("Computer's turn...");
				
				System.out.println("Heuristic value: " +computer.getHeuristic(engine.board));
			}
			
			
			
			
//			if(!engine.isMoveMade())
//			{
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
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
		if(computer.piecesLeft == 0 || human.piecesLeft == 0){
			return true;
		}
		// check if gameover is false
		return gameover;
	}
	
	public void resign(){
		gameover = true;
	}
}
