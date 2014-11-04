package checkersAI;

public class Pawn extends Piece {
	
	public Pawn(String color, int startingPos) {
		super(color.toLowerCase(), startingPos);
	}

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
	
}
