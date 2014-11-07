package checkersAI;

public class AI extends Player {
	
	private int pawnValue = 1;
	private int kingValue = 3;
//	private int positionValue = 5;
	
	// Minimax recursion with multi-threading
	// Heuristic function

	/**
	 * Constructor for AI class to be a computer player in a game of checkers.
	 * @param color The color the computer will be playing.
	 * @param numberOfPieces The starting number of pieces for this player.
	 */
	public AI(String color, int numberOfPieces) {
		super(color, numberOfPieces);
	}
	
	/**
	 * 
	 * @param board
	 * @return
	 */
	public int getHeuristic(Piece[] board){
		int heuristic = 0;
		int numOfBlackPawns = 0;
		int numOfBlackKings = 0;
		int numOfRedPawns = 0;
		int numOfRedKings = 0;
		
		for(int i = 1; i <= 32; i++)
		{
			if(board[i] != null)
			{
				Piece p = board[i];
				if(p instanceof Pawn)
				{
					if(p.color.equalsIgnoreCase("b"))
					{
						numOfBlackPawns++;
					}else if(p.color.equalsIgnoreCase("r"))
					{
						numOfRedPawns++;
					}
				}else if(p instanceof King)
				{
					if(p.color.equalsIgnoreCase("b"))
					{
						numOfBlackKings++;
					}else if(p.color.equalsIgnoreCase("r"))
					{
						numOfRedKings++;
					}
				}
			}
		}
		heuristic = ((pawnValue*numOfBlackPawns) + (kingValue*numOfBlackKings)) -
				((pawnValue*numOfRedPawns) + (kingValue*numOfRedKings));
		return heuristic;
	}
	
	/**
	 * This is the method which recursively searches the tree of possible moves 
	 * (up to a certain depth) to find the best heuristic value.
	 * @return An array of length 2. Index 0: the current position of the piece
	 * to move; Index 1: The new position where the piece is moved to.
	 */
	public int[] minimax()
	{
		int[] move = new int[2];
		
		return move;
	}
    

}
