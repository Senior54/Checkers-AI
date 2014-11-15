package checkersAI;

public class AI extends Player {
	
	private int pawnValue = 1;
	private int kingValue = 3;
//	private int positionValue = 5;

	/**
	 * Constructor for AI class to be a computer player in a game of checkers.
	 * @param color The color the computer will be playing.
	 * @param numberOfPieces The starting number of pieces for this player.
	 */
	public AI(char color, int numberOfPieces, int numKings) {
		super(color, numberOfPieces, numKings);
	}
	
	/**
	 * Gets the heuristic value for the current state of the board which 
	 * refers to the "goodness" of a given board state for the computer.
	 * @param board The current state of the board
	 * @return The heuristic value
	 */
	public int getHeuristic(GameEngine eng){
		int heuristic = 0;
		
		int totalBlackPieces = eng.comp().getPiecesLeft();
		int numOfBlackKings = eng.comp().getKingedPieces();
		int numOfBlackPawns = totalBlackPieces - numOfBlackKings;
		
		int totalRedPieces = eng.human().getPiecesLeft();
		int numOfRedKings = eng.comp().getKingedPieces();
		int numOfRedPawns = totalRedPieces - numOfRedKings;
		
		// Will need to be modified for pieces in favorable positions
		
		
		
		heuristic = ((pawnValue*numOfBlackPawns) + (kingValue*numOfBlackKings)) -
				((pawnValue*numOfRedPawns) + (kingValue*numOfRedKings));
		return heuristic;
	}
	
	/**
	 * This is the method which recursively searches the tree of possible moves 
	 * (up to a certain depth) to find the best heuristic value.
	 * 
	 * @param currBoard The current state of the board.
	 * @param turn The currentPlayer making a move (red or black).
	 * @param searchDepth The number of levels down the minimax tree to search.
	 * @return An array of length 2 representing the best move found. Index 0: the
	 * current position of the piece to move; Index 1: The new position where the 
	 * piece is moved to. Index 2: the heuristic value.
	 */
	public int[] minimaxRecursion(GameEngine eng,  int searchDepth)
	{	// Possibly to be done with multi-threading
		
		// Board is cloned so the actual board is not modified during a search.
		Piece[][] boardState = eng.getBoard().clone();
		char turn = eng.getCurrentPlayer();
		int[] moveInfo = new int[3];
		
		if(searchDepth == 0){
			// base case, at a leaf in the tree.
			moveInfo[2] = getHeuristic(eng);
		}else{
			// recursive step:
			// make move and call minimax on modified boardState and updating turn
			
		}
		
		return moveInfo;
	}
    

}
