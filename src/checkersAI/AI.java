package checkersAI;

public class AI extends Player {
	
	// Minimax recursion with multi-threading
	// Heuristic function

	public AI(String color, int numberOfPieces) {
		super(color, numberOfPieces);
	}
	
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
				//if ( (p.getColor() == "b") && )
			}
		}
		
		return heuristic;
	}
//	
//	public int[] minimax()
//	{
//		
//	}
    

}
