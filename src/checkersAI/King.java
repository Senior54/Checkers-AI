package checkersAI;

public class King extends Piece
{

	/**
	 * Constructor for King class
	 * @param color The color of the king piece
	 * @param position The position for the king to be placed.
	 */
	public King(String color, int position) {
		super(color.toUpperCase(), position);
	}
	
	/**
	 * Checks if moving this piece from the its current position to
	 * the given position is legal for a king.
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 * @param endPosition
	 * @return
	 */
	public boolean isLegalMove(int endPosition)
	{
		if((Math.abs(super.getPosition() - endPosition) )== 4 || 
				(Math.abs(super.getPosition() - endPosition) )== 5 )
		
			return true;
		
		return false;
	}
	
	/**
	 * /**
	 * Checks if moving this king from the its current position to
	 * the given position is a legal jump.
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 * @param endPosition
	 * @return
	 */
	public boolean isLegalJump(int endPosition){
		if((Math.abs(super.getPosition() - endPosition) )== 9 || 
				(Math.abs(super.getPosition() - endPosition) )== 7 )
		
			return true;
		
		return false;
	}
}
