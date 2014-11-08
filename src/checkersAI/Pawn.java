package checkersAI;

public class Pawn extends Piece {
	
	/**
	 * Constuctor for Pawn class
	 * @param color The color of the Pawn
	 * @param startingPos The starting position of the Pawn
	 */
	public Pawn(String color, int startingPos) {
		super(color.toLowerCase(), startingPos);
	}

	/**
	 * Checks if moving this piece from the its current position to
	 * the given position is legal for a pawn.
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public boolean isLegalMove(int endPosition)
	{	// Move is illegal if endPosition is not an index to the board
		if((endPosition < 1) || (endPosition > 32))
			return false;
		
		// If current position is a square which is flush left or
		// flush right on the board special checks apply... TO DO!!!
		
		
		// Checking validity for current positions that are not flush
		// left or flush right on the board.
		int positionDiffernece = endPosition - super.getPosition();
		switch (super.getColor()){
			case "b":
				if ( super.getRowNumber() % 2 == 1 ){
					// Piece is in an odd numbered row
					if( (positionDiffernece == 4) || (positionDiffernece == 5) ){
						return true;
					}
				}else if( super.getRowNumber() % 2 == 0 ){
					// Piece is in an even numbered row
					if( (positionDiffernece == 3) || (positionDiffernece == 4) ){
						return true;
					}
				}
				break;
			case "r":
				if ( super.getRowNumber() % 2 == 1 ){
					// Piece is in an odd numbered row
					if( (positionDiffernece == -3) || (positionDiffernece == -4) ){
						return true;
					}
				}else if( super.getRowNumber() % 2 == 0 ){
					// Piece is in an even numbered row
					if( (positionDiffernece == -4) || (positionDiffernece == -5) ){
						return true;
					}
				}
				break;
			default:
				// do nothing; should not hit this point
				break;
		}
		
		return false;
	}

	/**
	 * Checks if moving this pawn from the its current position to
	 * the given position is a legal jump. 
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public boolean isLegalJump(int position) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
