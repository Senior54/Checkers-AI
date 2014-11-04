package checkersAI;

public class King extends Piece
{

	public King(String color, int position) {
		super(color.toUpperCase(), position);
	}
	
	public boolean isLegalMove(int endPosition)
	{
		if((Math.abs(super.getPosition() - endPosition) )== 4 || 
				(Math.abs(super.getPosition() - endPosition) )== 5 )
		
			return true;
		
		return false;
	}
	
	public boolean isLegalJump(int endPosition){
		if((Math.abs(super.getPosition() - endPosition) )== 9 || 
				(Math.abs(super.getPosition() - endPosition) )== 7 )
		
			return true;
		
		return false;
	}
}
