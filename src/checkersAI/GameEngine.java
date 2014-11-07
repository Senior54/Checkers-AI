package checkersAI;

public class GameEngine {

	public Piece[] board = new Piece[33]; // ignore 0th index
	String currentPlayer;
	String previousPlayer;

	/**
	 * Constructor for GameEngine class. Sets human as the red pieces,
	 * gives them the first move, and initializes the board.
	 */
	public GameEngine() {
		currentPlayer = "red";
		previousPlayer = currentPlayer;

		// placing pieces on the board
		for (int i = 1; i < 13; i++)
			board[i] = new Pawn("b", i);

		for (int i = 21; i < 33; i++)
			board[i] = new Pawn("r", i);
	}

	/**
	 * Returns the current player (red/black) as a string.
	 * @return
	 */
	public String getCurrentPLayer() {
		return currentPlayer;
	}

	/**
	 * Updates the current player to the other player.
	 */
	public void updateCurrentPlayer() {
		if (currentPlayer == "red") {
			currentPlayer = "black";
		} else {
			currentPlayer = "red";
		}
	}

	/**
	 * Checks whether the given move of the given piece is 
	 * a legal move. 
	 * @param piece The piece to be moved
	 * @param position The position on the board to move the piece to.
	 * @return True if move is legal, false otherwise
	 */
	public boolean isLegalMove(Piece piece, int position) {
		return piece.isLegalMove(position);
	}

	/**
	 * Checks for the opportunity to jump.
	 * @param position The position of the piece to check for an
	 * available jump.
	 * @return
	 */
	//public boolean isJump(int position){
		 //make recursive to check for multiple jumps
		 // check if legal move
		 // is there any neighboring enemy pieces
		 // check enemy piece's neighboring positions
	 //}
	
	/**
	 * Delete a piece from the board.
	 * @param The position of the piece to be captured.
	 */
	 public void capture(int pos){
	 // check if it is a jump from piece class
	 // if true: delete piece & update piece's position
	 // else: nothing
	 }

	/**
	 * Moves the given piece from the start position to the
	 * ending position.
	 * @param startPos The place on the board where the piece currently is located.
	 * @param endPos The ending position on the board where the piece will be moved to.
	 */
	public void makeMove(int startPos, int endPos) {
		// check if normal move is legal
		// true: update piece's position
		// false: exception/error message for illegal move
		// delete pieces if necessary
		// update current player
	}

	/**
	 * Determines if a neighboring piece belongs to the opponent.
	 * @param occupantsPosition The position of the neighboring piece
	 * @param piecePosition The position of the piece you want to move.
	 * @return True if the neighboring piece belongs to the opponent, 
	 * false otherwise.
	 */
	public boolean isOccopantOpponentsPiece(int occupantsPosition, int piecePosition)
	{
		return !(board[occupantsPosition].getColor().equals(board[piecePosition].getColor()));
	}
	
	/**
	 * This method is used to king a pawn piece when it makes its way to 
	 * the opposite end of the board from where it started.
	 * @param pos The current position of the piece to be kinged.
	 */
	public void kingMe(int pos)
	{
		
	}
	
	/**
	 * Checks whether the turn of the current player is over or not.
	 * @return True if the current player has made their move and their turn
	 * is over, false otherwise. // multiple jumps??  
	 */
	public boolean isMoveMade() {
		if (previousPlayer == currentPlayer)
			return false;
		else {
			previousPlayer = currentPlayer;
		}
		return true;
	}

	/**
	 * Checks whether a square or cell of the board is occupied by 
	 * another piece.
	 * @param square The square or cell to be checked.
	 * @return True if the square is occupied, false otherwise.
	 */
	public boolean isOccupied(int square) {
		return !(board[square] == null);
	}

	/**
	 * Prints the state of the board. 'x' is used in spaces which are not part of
	 * the game (always empty). Spaces which are available for a piece to move into 
	 * are shown by '_'. Pieces are represented as follows:
	 * black king = B, black pawn = b, red king = R, red pawn = r
	 */
	public void printBoard() {
		int index = 1;
		//char block = '■';
		for (int r = 1; r <= 8; r++) {	// 8 rows of game spaces
			for (int c = 1; c <= 4; c++) {	// 4 cols of game spaces
				if(r % 2 == 1){		// odd rows have empty spaces first
					if(!(board[index]  == null)){
						System.out.print("[■][" + board[index].getColor()+ "]");
						index++;
					}else{
						System.out.print("[■][ ]");
						index++;
					}
				}else{		// even rows have game spaces first
					if(!(board[index] == null)){
						System.out.print("[" + board[index].getColor() + "][■]");
						index++;
					}else{
						System.out.print("[ ][■]");
						index++;
					}
				}
			}
			System.out.println();
		}

		System.out.println();
	}
}
