package checkersAI;

import java.util.ArrayList;

public class GameEngine {
   //using 2d array for the board
	private Piece[][] board = new Piece[8][8];
	private Player human = new Player('r', 12, 0);
	private Player comp = new Player('b', 12, 0);
	private char currentPlayer;
	private char previousPlayer;

	/**
	 * Constructor for GameEngine class. Sets human as the red pieces, gives
	 * them the first move, and initializes the board.
	 */
	//TESTING PURPOSE, use this to set certain position 
	//and the amount of pieces in each player for testing 
	//to see if each method works
	public GameEngine() {
		currentPlayer = 'r';
		previousPlayer = 'r';

		board[1][0] = new King('r', 1, 0);
		board[2][1] = new Pawn('b', 2, 1);
		board[4][3] = new Pawn('b', 4, 3);
		board[6][5] = new Pawn('b', 6, 5);
		
		human = new Player('r', 1, 1);
		comp = new Player('b', 3, 0);
	}

//	public GameEngine() {
//		currentPlayer = 'r';
//		previousPlayer = 'r';
//
//		// placing pieces on the board
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 8; j++) {
//				if (i % 2 == 0) {
//					if (j % 2 != 0) {
//						board[i][j] = new Pawn('b', i, j);
//					}
//				} else {
//					if (j % 2 == 0) {
//						board[i][j] = new Pawn('b', i, j);
//					}
//				}
//			}
//		}
//		for (int i = 5; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				if (i % 2 != 0) {
//					if (j % 2 == 0) {
//						board[i][j] = new Pawn('r', i, j);
//					}
//				} else {
//					if (j % 2 != 0) {
//						board[i][j] = new Pawn('r', i, j);
//					}
//				}
//			}
//		}
//	}

	/**
	 * Returns the current player (r/b) as a string.
	 * 
	 * @return
	 */
	public char getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Updates the current player to the other player.
	 */
	public void updateCurrentPlayer() {
		if (currentPlayer == 'r') {
			currentPlayer = 'b';
		} else {
			currentPlayer = 'r';
		}
	}

	/**
	 * Checks whether the given move of the given piece is a legal move.
	 * 
	 * @param piece
	 *            The piece to be moved
	 * @param position
	 *            The position on the board to move the piece to.
	 * @return True if move is legal, false otherwise
	 */
	public boolean isLegalMove(Piece piece, int endRow, int endCol) {
		
		if ((piece.getColor() == getCurrentPlayer()) &&
			(isPlayingSquare(endRow, endCol)) ) {
			if (isOccupied(endRow, endCol) == false) {
				return piece.isLegalMove(endRow, endCol);
			}
		}
		return false;
	}

	/**
	 * Checks if jump with this piece is valid .
	 * 
	 * @param position
	 *            The position of the piece to check for an available jump.
	 * @return
	 */
	public boolean isLegalJump(Piece piece, int endRow, int endCol) {

		if (piece.isLegalJump(endRow, endCol)) {
			if (!(isOccupied(endRow, endCol))) { //check if endPos is empty
				int r = piece.getRow();
				int c = piece.getCol();
				if (isOccupied((r + endRow) / 2, (c + endCol) / 2)) { 
					//check if the piece trying to jump over is opponent's or not
					return isOccopantOpponentsPiece((r + endRow) / 2,
							(c + endCol) / 2, r, c);
				}
			}
		}

		return false;
	}

//returns the available jumps into arrayList, which good for AI to generate moves 	
	public ArrayList<Move> isThereJumps(Piece piece) {
		ArrayList<Move> temp = new ArrayList<Move>();
		int r = piece.getRow();
		int c = piece.getCol();
		if (piece instanceof Pawn) {
			if (piece.getColor() == 'b') {
				// Legal jumps for black pawns
				if (isLegalJump(piece, r + 2, c - 2)) {
					temp.add(new Move(r + 2, c - 2));
				}
				if (isLegalJump(piece, r + 2, c + 2)) {
					temp.add(new Move(r + 2, c + 2));
				}
			} else {
				// Legal jumps for red pawns
				if (isLegalJump(piece, r - 2, c - 2)) {
					temp.add(new Move(r - 2, c - 2));
				}
				if (isLegalJump(piece, r - 2, c + 2)) {
					temp.add(new Move(r - 2, c + 2));
				}
			}
		} else {
			// Legal jumps for Kings of either color
			if (isLegalJump(piece, r + 2, c - 2)) {
				temp.add(new Move(r + 2, c - 2));
			}
			if (isLegalJump(piece, r + 2, c + 2)) {
				temp.add(new Move(r + 2, c + 2));
			}
			if (isLegalJump(piece, r - 2, c - 2)) {
				temp.add(new Move(r - 2, c - 2));
			}
			if (isLegalJump(piece, r - 2, c + 2)) {
				temp.add(new Move(r - 1, c + 1));
			}
		}
		return temp;
	}

	/**
	 * check for availible moves around the piece good for AI to generate moves
	 * 
	 * @param piece
	 * @return
	 */
	public ArrayList<Move> isThereAvaMove(Piece piece) {
		ArrayList<Move> temp = new ArrayList<Move>();
		int r = piece.getRow();
		int c = piece.getCol();
		if (piece instanceof Pawn) {
			if (piece.getColor() == 'b') {
				// Legal normal moves for black pawns
				if (isLegalMove(piece, r + 1, c - 1)) {
					temp.add(new Move(r + 1, c - 1));

				}
				if (isLegalMove(piece, r + 1, c + 1)) {
					temp.add(new Move(r + 1, c + 1));

				}
			} else {
				// Legal normal moves for red pawns
				if (isLegalMove(piece, r - 1, c - 1)) {
					temp.add(new Move(r - 1, c - 1));
				}
				if (isLegalMove(piece, r - 1, c + 1)) {
					temp.add(new Move(r - 1, c + 1));
				}
			}
		} else {
			// Legal normal moves for Kings of either color
			if (isLegalMove(piece, r + 1, c - 1)) {
				temp.add(new Move(r + 1, c - 1));
			}
			if (isLegalMove(piece, r + 1, c + 1)) {
				temp.add(new Move(r + 1, c + 1));
			}
			if (isLegalMove(piece, r - 1, c - 1)) {
				temp.add(new Move(r - 1, c - 1));
			}
			if (isLegalMove(piece, r - 1, c + 1)) {
				temp.add(new Move(r - 1, c + 1));
			}
		}
		return temp;
	}

	/**
	 * Verifies the move is a legal jump for the given piece. If it is, then
	 * the position of the moved piece is updated and an opponent's piece is
	 * deleted.
	 * 
	 * @param player
	 * @param piece
	 * @param endRow
	 * @param endCol
	 */
	public void makeaJump(Player player, Piece piece, int endRow, int endCol) {
		// Check if the move is a legal jump for the given piece.
		if (isLegalJump(piece, endRow, endCol)) {
			int r = piece.getRow();
			int c = piece.getCol();
			// Remove opponent's piece from the board
			board[(r + endRow) / 2][(c + endCol) / 2] = null;
			// Update piece's position
			board[endRow][endCol] = board[r][c];
			board[r][c] = null;
			piece.setPosition(endRow, endCol);
			// Delete a piece from opponent's total piece count
			if (human.getColor() == getCurrentPlayer()) {
				if (piece instanceof King){
					comp.deleteKingPiece(1);
				}
				comp.deletePiece(1);
			} else {
				if (piece instanceof King){
					human.deleteKingPiece(1);
				}
				human.deletePiece(1);
			}
			// Kings the moved piece if it has crossed the entire board.
			kingMe(player, piece);
		}
	}

	/**
	 * Moves the given piece from the start position to the ending position.
	 * 
	 * @param startPos The place on the board where the piece currently is located.
	 * @param endPos The ending position on the board where the piece will be moved to.
	 */
	public void makeMove(Player player, Piece piece, int endRow, int endCol) {
		// Is a piece in the selected position...
		if (piece != null) {
			int r = piece.getRow();
			int c = piece.getCol();
			char color = piece.getColor();
			// Does the selected piece belong to the current player...
			if (Character.toLowerCase(color) == player.getColor()) {
				// Check if the move is a legal normal move for the given piece.
				if (isLegalMove(piece, endRow, endCol)) {
					// Update piece's position
					board[endRow][endCol] = board[r][c];
					board[r][c] = null;
					piece.setPosition(endRow, endCol);
					// Kings the moved piece if it has crossed the entire board.
					kingMe(player, piece);
					return;
				} 

				// Check if the move is a legal jump for the given piece.
				if (isLegalJump(piece, endRow, endCol)) {
					// Handles a single legal jump and piece deletion.
					makeaJump(player, piece, endRow, endCol);
					return;
				}
			}
		}
		
		// Error message for illegal move
		System.out.println("Illegal move. Please try again.");
		System.out.println();
	}

	/**
	 * Determines if a neighboring piece belongs to the opponent.
	 * 
	 * @param occupantsPosition The position of the neighboring piece
	 * @param piecePosition The position of the piece you want to move.
	 * @return True if the neighboring piece belongs to the opponent, false
	 *         otherwise.
	 */
	public boolean isOccopantOpponentsPiece(int occupantsRow, int occupantsCol,
			int pieceRow, int pieceCol) {
		return !(board[occupantsRow][occupantsCol].getColor() == (board[pieceRow][pieceCol]
				.getColor()));
	}

	/**
	 * This method is used to king a pawn piece when it makes its way to the
	 * opposite end of the board from where it started.
	 * 
	 * @param pos The current position of the piece to be kinged.
	 */
	public void kingMe(Player player, Piece piece) {
		if (isKing(piece)) {
			int r = piece.getRow();
			int c = piece.getCol();
			char color = piece.getColor();
			board[r][c] = new King(Character.toUpperCase(color), r, c);
			player.addKingPiece();
		}
	}

	//checks the piece if it's a king or not
	public boolean isKing(Piece piece) {
		int r = piece.getRow();
		char color = piece.getColor();
		if (color == 'r' && r == 0) {
			return true;
		}
		if (color == 'b' && r == 7) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the turn of the current player is over or not.
	 * 
	 * @return True if the current player has made their move and their turn is
	 *         over, if yes, update previous player = current player, false
	 *         otherwise. // multiple jumps??
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
	 * Checks whether a square or cell of the board is occupied by another
	 * piece.
	 * 
	 * @param square
	 *            The square or cell to be checked.
	 * @return True if the square is occupied, false otherwise.
	 */
	public boolean isOccupied(int endRow, int endCol) {
		return !(board[endRow][endCol] == null);
	}

	// get human player
	public Player human() {
		return human;
	}

	// get computer (AI) player
	public Player comp() {
		return comp;
	}

	public Piece[][] getBoard() {
		return board;
	}

	//returns a piece from the board
	public Piece getPiece(int row, int col) {
		if(isPlayingSquare(row, col)){
			return board[row][col];
		}
		return null;
	}

	public boolean isPlayingSquare(int r, int c){
		if (r > 7 || r < 0) {
//			System.out.println("Invalid row #");
			return false;
		}
		if (c > 7 || c < 0) {
//			System.out.println("Invalid column #");
			return false;
		}
		if( (r == c) || bothEven(r, c) || bothOdd(r, c)){
//			System.out.println("This is not a playing square");
			return false;
		}
		return true;
	}

	private boolean bothEven(int r, int c) {
		if((r % 2 == 0) && (c % 2 == 0)){
			return true;
		}
		return false;
	}
	
	private boolean bothOdd(int r, int c) {
		if((r % 2 == 1) && (c % 2 == 1)){
			return true;
		}
		return false;
	}

	/**
	 * Prints the state of the board. 'x' is used in spaces which are not part
	 * of the game (always empty). Spaces which are available for a piece to
	 * move into are shown by '_'. Pieces are represented as follows: black king
	 * = B, black pawn = b, red king = R, red pawn = r
	 */
	public void printBoard() {
		System.out.print("   ");
	    for(int k =0 ; k <8; k++){
	    	System.out.print(k + "  ");
	    	
	    }
	    System.out.println();
		for (int r = 0; r < 8; r++) {
			System.out.print(r + "  ");
			for (int c = 0; c < 8; c++) {
				if ( (board[r][c] != null) && (board[r][c] instanceof King) ){
					char ch = (char) (board[r][c].getColor() - 32); 
					System.out.print(ch + "  ");
				}else if (board[r][c] != null) {
					System.out.print(board[r][c].getColor() + "  ");
				}else if ( ((r % 2 == 0) && (c % 2 == 0)) ||
						   ((r % 2 == 1) && (c % 2 == 1)) ){
					// Print unused square
					System.out.print("■" + "  ");
				}else{
					// Print empty square
					System.out.print(" " + "  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
