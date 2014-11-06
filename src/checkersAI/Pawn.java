//package Checkers;

public class Pawn extends Piece {
	
	public Pawn(String color, int startingPos) {
		super(color, startingPos);
		// TODO Auto-generated constructor stub
	}

	public boolean isLegalMove(int endPosition)
	{
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
