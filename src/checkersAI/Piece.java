package checkersAI;

public abstract class Piece {

	String color;
	int position;
	
	public Piece(String color, int startingPos){
		this.color = color;
		position = startingPos;
	}
	
	public String getColor(){
		return color;
	}
	
	public int getPosition(){
		return position;
	}
	
	public abstract boolean isLegalMove(int position);
	
	public void setPosition(int pos){
		position = pos;
	}
}
