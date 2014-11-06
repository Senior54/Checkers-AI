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
	{
		// this depends on the row where a piece starts and ends.
		// sometimes the difference is 4/5 other times the difference is 3/4.
		
		if(super.color.equals("red") &&
				(super.getPosition() - endPosition == 4 ||
				super.getPosition() - endPosition == 5) )
		{
		  return true;
		}else if(super.color.equals("black") &&
				(super.getPosition() - endPosition == -4 ||
				super.getPosition() - endPosition == -5) )
		{
		  return true;
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
