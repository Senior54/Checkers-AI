package checkersAI;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {

	Scanner scanner = new Scanner(System.in);
	private GameEngine engine;
	private boolean gameover;

	public Game() {
		startGame();
	}

	public void startGame(){
		setUp();
		
		while(!isEndOfGame()){
			// Human player will always be red and have the first move
			playerTakesTurn();
			// Give turn to next player
			engine.updateCurrentPlayer();
			System.out.println("Red: " + engine.human().getPiecesLeft() + " Pieces left ( " +
								engine.human().getKingedPieces() + " kings).");
			System.out.println("Black: " + engine.comp().getPiecesLeft() + " Pieces left ( " +
					engine.comp().getKingedPieces() + " kings).");
		}
		
		// Gameover:
		engine.printBoard();
		System.out.println("GAMEOVER");
		String winner;
		if(engine.comp().getPiecesLeft() == 0){
			winner = "RED";
		}else{
			winner = "BLACK";
		}
		System.out.println(winner + " wins!");
		scanner.close();
	}

	private void playerTakesTurn() {
		// Get the piece the human player wishes to move.
		Piece movingPiece = getPieceToMove();
		while ((movingPiece == null)
				|| (movingPiece.getColor() != engine.getCurrentPlayer())
				|| ((engine.isThereAvaMove(movingPiece).size() < 1) && (engine
						.isThereJumps(movingPiece).size() < 1))) {
			// If selected row & col do not hold a piece belonging to the player
			// OR
			// If the selected piece has no moves, then the selection is invalid
			System.out.println("You have no piece at this position, or the piece has no available moves.");
			movingPiece = getPieceToMove();
		}

		// Jumping moves this piece can make
		ArrayList<Move> availableJumps = engine.isThereJumps(movingPiece);
		// Normal moves this piece can make
		ArrayList<Move> availableMoves = engine.isThereAvaMove(movingPiece);

		// If selected piece can jump, make it take a jump.
		if (availableJumps.size() > 0) {
			System.out.println("This piece must make a jump.");
			performAJump(movingPiece, availableJumps);
		} else {
			// Otherwise it makes a normal move
			performNormalMove(movingPiece, availableMoves);
		}

	}

	private void performNormalMove(Piece piece, ArrayList<Move> moves) {
		Move selectedMove = getMove();
		boolean selectedMoveExist = false;
		while(!selectedMoveExist){
			for(Move m : moves){
				if(movesAreEqual(m, selectedMove)){
					selectedMoveExist = true;
					break;
				}
			}
			if(!selectedMoveExist){
				// As long as the move given by the human player is not valid/not exist,
				// ask the human player for a different place to move the selected piece.
				System.out.println("The selected piece (" + piece.getRow() + 
						", " + piece.getCol() + ") cannot move to ( " + 
						selectedMove.getMovesRow() + ", " +selectedMove.getMovesCol() + ").");
				selectedMove = getMove();
			}
		}
		
		// Once the move is valid, make the move.
		if(engine.getCurrentPlayer() == engine.human().getColor()){
			engine.makeMove(engine.human(),piece, selectedMove.getMovesRow(), selectedMove.getMovesCol());
		}
		else{
			engine.makeMove(engine.comp(),piece, selectedMove.getMovesRow(), selectedMove.getMovesCol());
		}
	}

	/**
	 * This method is recursive. Make this piece jump as long as there
	 * is a jump available for it.
	 * @param piece The moving piece
	 * @param availableJumps The list of jumps this piece can make from
	 * 			its current position (at most four).
	 */
	private void performAJump(Piece piece, ArrayList<Move> jumps) {
		Move selectedMove = getMove();
		boolean selectedMoveExist = false;
		while(!selectedMoveExist){
			// If the jump given by the human player is in the list of available jumps,
			// then it is valid/exists
			for(Move m : jumps){
				if(movesAreEqual(m, selectedMove)){
					selectedMoveExist = true;
					break;
				}
			}
			if(!selectedMoveExist){
				// As long as the jump given by the human player is not valid/not exist,
				// ask the human player for a different place to move the selected piece.
				System.out.println("The selected piece (" + piece.getRow() + 
						", " + piece.getCol() + ") cannot jump to (" + 
						selectedMove.getMovesRow() + ", " +selectedMove.getMovesCol() + ").");
				selectedMove = getMove();
			}
		}
		// When the jump exists/is valid, make the jump
		if(engine.getCurrentPlayer() == engine.human().getColor()){
			engine.makeMove(engine.human(),piece, selectedMove.getMovesRow(), selectedMove.getMovesCol());
		}
		else{
			engine.makeMove(engine.comp(),piece, selectedMove.getMovesRow(), selectedMove.getMovesCol());
		}
		
		// Check if there is another jump for the piece.
		jumps = engine.isThereJumps(piece);
		if(jumps.size() > 0){
			engine.printBoard();
			System.out.println("This piece (" + piece.getRow() + ", " + piece.getCol() + 
					") can jump again. Make the jump? (Y/N)");
			String response = scanner.nextLine().toUpperCase();
			// If human player wishes to make another jump, recursive call to this method.
			if(response.equals("Y")){
				performAJump(piece, jumps);
			}
		}
	}

	/**
	 * Checks whether the given moves are the same.
	 * @param x A move to check for equality
	 * @param selected Another move to check for equality
	 * @return True if equal, false otherwise.
	 */
	private boolean movesAreEqual(Move x, Move selected) {
		if(x.getMovesRow() == selected.getMovesRow()){
			if(x.getMovesCol() == selected.getMovesCol()){
				return true;
			}
		}
		return false;
	}

	/**
	 * Asks the human player for a place to move the piece it has already selected.
	 * @return A move object consisting of a row and col to move the selected piece to.
	 */
	private Move getMove() {
		// Get the position the player wishes to move its piece to
//		engine.printBoard();
		System.out.println(engine.getCurrentPlayer() + ": Please enter the row number to move to:");
		String line = scanner.nextLine();
		int row = Integer.parseInt(line);
		System.out.println(engine.getCurrentPlayer() + ": Please enter the column number to move to:");
		line = scanner.nextLine();
		int col = Integer.parseInt(line);
		
		return new Move(row, col);
	}

	/**
	 * Asks the human player for a a row and col of the board.
	 * @return The piece at this position. Null for invalid positions.
	 */
	private Piece getPieceToMove(){
		// Get the piece the user wishes to move
		engine.printBoard();
		System.out.println(engine.getCurrentPlayer() + ": Please enter the row number of the piece you wish to move:");
		String line = scanner.nextLine();
		int currRow = Integer.parseInt(line);
		System.out.println(engine.getCurrentPlayer() + ": Please enter the column number of the piece you wish to move:");
		line = scanner.nextLine();
		int currCol = Integer.parseInt(line);
		return  engine.getPiece(currRow, currCol);
	}
	
	/**
	 * Checks if the game is over
	 * @return True if it is gameover, otherwise false.
	 */
	private boolean isEndOfGame() {
		// check for a player having no more pieces
		if (engine.human().getPiecesLeft() == 0
				|| engine.comp().getPiecesLeft() == 0) {
			return true;
		} else if (gameover == true) {
			return true;
		}
		return false;
	}

	public void resign() {
		gameover = true;
	}

	/**
	 * Sets up a new game in the initial state.
	 */
	private void setUp() {
		gameover = false;
		engine = new GameEngine();
	}
}
