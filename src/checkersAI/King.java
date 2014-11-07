package checkersAI;

public class King extends Piece
{

	public King(String color, int position, String king) {
		super(color, position, king);
		// TODO Auto-generated constructor stub
	}
	public boolean isLegalMove(int endPosition)
	{
		if(
				(Math.abs(super.getPosition() - endPosition) )== 4 ||
				(Math.abs(super.getPosition() - endPosition) )== 5 )
		
		  return true;
		
		return false;
	}
}
