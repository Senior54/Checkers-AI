package checkersAI;
import java.util.Scanner;
public class Game {
	
	public Player human = new Player("red", 12);
	public AI computer = new AI("black", 12);
	// maxSearch depth = (number of turns for each player)*(number of players)
	public int maxSearchDepth = 4;
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
				boolean moveablePiece = false;
				System.out.println(engine.getCurrentPLayer() + " Please select a piece");
				String line = scan.nextLine();
				int selectedPiece = Integer.parseInt(line);
				while(!moveablePiece){
					if( (selectedPiece > 0) && (selectedPiece < 33) && 
							(engine.isOccupied(selectedPiece)) &&
							engine.getBoard()[selectedPiece].getColor().equals("r"))
					{
						// The user has given input which is within the board size,
						// and the square in the board is holding a users's red piece.
						moveablePiece = true;
					}else{
						System.out.println("Invalid position number\n" +
								engine.getCurrentPLayer() + " Please select a piece");
						line = scan.nextLine();
						selectedPiece = Integer.parseInt(line);
					}
				}

				boolean validMove = false;
				System.out.println(engine.getCurrentPLayer() + " Please make a move");
				line = scan.nextLine();
				int endPos = Integer.parseInt(line);
				while(!validMove){
					if( (!engine.isOccupied(endPos)) && 
							engine.isLegalMove(engine.getBoard()[selectedPiece], endPos))
					{
						// The user has chosen an open square on the board to move to.
						// Still needs to check for validity of the move/jump
						validMove = true;
					}else{
						System.out.println("Cannot move here\n" +
								engine.getCurrentPLayer() + " Please make a move");
						line = scan.nextLine();
						endPos = Integer.parseInt(line);
					}
				}
				
				// Updating board to show the move made by the user.
				engine.makeMove(selectedPiece, endPos);
				
			} else if(engine.getCurrentPLayer().equals("black"))
			{	// Computer's turn
				System.out.println("Computer's turn...");
				
//				System.out.println("Heuristic value: " +computer.getHeuristic(engine.board));
			}
			
			
			
			
//			if(!engine.isMoveMade())
//			{
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
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
