package checkersAI;

public class GameEngine {

	public Piece[] board = new Piece[33]; // ignore 0th index
	String currentPlayer;
	String previousPlayer;

	public GameEngine() {
		currentPlayer = "red";
		previousPlayer = currentPlayer;

		// placing pieces on the board
		for (int i = 1; i < 13; i++)
			board[i] = new Pawn("b", i);

		for (int i = 21; i < 33; i++)
			board[i] = new Pawn("r", i);
	}

	public String getCurrentPLayer() {
		return currentPlayer;
	}

	public void updateCurrentPlayer() {
		if (currentPlayer == "red") {
			currentPlayer = "black";
		} else {
			currentPlayer = "red";
		}
	}

	public boolean isLegalMove(Piece piece, int position) {
		return piece.isLegalMove(position);
	}

	// public boolean isJump(int position){
	// if()
	// // check if legal move
	// // is there any neighboring enemy pieces
	// // check enemy piece's neighboring positions
	// }
	//
	// public void capture(){
	// // check if it is a jump from piece class
	// // if true: delete piece & update piece's position
	// // else: nothing
	// }

	public void makeMove(int position) {
		// check if normal move is legal
		// true: update piece's position
		// false: exception/error message for illegal move
		// delete pieces if necessary
		// update current player
	}

	public boolean isMoveMade() {
		if (previousPlayer == currentPlayer)
			return false;
		else {
			previousPlayer = currentPlayer;
		}
		return true;
	}

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
		for (int r = 1; r <= 8; r++) {	// 8 rows of game spaces
			for (int c = 1; c <= 4; c++) {	// 4 cols of game spaces
				if(r % 2 == 1){		// odd rows have empty spaces first
					if(!(board[index]  == null)){
						System.out.print("x\t" + board[index].getColor()+ "\t");
						index++;
					}else{
						System.out.print("x\t_\t");
						index++;
					}
				}else{		// even rows have game spaces first
					if(!(board[index] == null)){
						System.out.print(board[index].getColor() + "\tx\t");
						index++;
					}else{
						System.out.print("_\tx\t");
						index++;
					}
				}
			}
			System.out.println();
		}

		System.out.println();
	}
}
