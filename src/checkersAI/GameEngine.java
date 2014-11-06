//package Checkers;

public class GameEngine {

	public Piece[] board = new Piece[33]; // ignore 0th index
	public Grid[] grid = new Grid[33]; // stores piece strings in grid objects or empty string grid objects
	String currentPlayer;
	String previousPlayer;

	public GameEngine() {
		currentPlayer = "red";
		previousPlayer = currentPlayer;

		// placing pieces on the board
		for (int i = 1; i < 13; i++) {
			board[i] = new Pawn("B", i);
			grid[i] = new Grid(i);
			grid[i].setStr(board[i].getText());
		}
		for (int i = 13; i < 21; i++)
			grid[i] = new Grid(i);
		for (int i = 21; i < 33; i++) {
			board[i] = new Pawn("R", i);
			grid[i] = new Grid(i);
			grid[i].setStr(board[i].getText());
		}
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

	public void boardToString() {
		for (int i = 1; i < 33; i++) {
			if (board[i] == null) {
				System.out.println("EMPTY");
			} else {
				System.out.println(i + " " + board[i].getColor());
			}
		}
	}
}
