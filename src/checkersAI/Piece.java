package checkersAI;

public abstract class Piece {

	String color;
	int position;
	String king;
	String text = "";
	
	public Piece(String color, int startingPos){
		this.color = color;
		this.position = startingPos;
		this.king = "";
		this.text =  this.position+this.color+this.king;
	}
	
	public Piece(String color, int startingPos, String king){
		this.color = color;
		this.position = startingPos;
		this.king = "K";
	}
	
	public String getColor(){
		return color;
	}
	
	public String getText() {
		return this.text;
	}
	
	public abstract boolean isLegalMove(int position);
	
	public void setPosition(int pos){
		position = pos;
	}
	
	public int getPosition(){
		return position;
	}

}
