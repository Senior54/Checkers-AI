//package Checkers;

public class Player {

	public String color;
	public int piecesLeft;
	
	public Player(String color, int numberOfPieces){
		this.color = color;
		this.piecesLeft = numberOfPieces;
	}
	
	public String getColor(){
		return color;
	}
	
	public int getPiecesLeft(){
		return piecesLeft;
	}
	
	public void deletePiece(int num){
		piecesLeft -= num;
	}
}
