package checkersAI;

public class Player {

	private char color;
	private int piecesLeft;
	private int kingedPieces; //keep track of how many kings there are,good for
	                       // AI heuristic calculation.
	
	public Player(char color, int numberOfPieces, int kingPiece){
		this.color = color;
		this.piecesLeft = numberOfPieces;
		this.kingedPieces = kingPiece;
	}
	
	public char getColor(){
		return color;
	}
	
	public int getPiecesLeft(){
		return piecesLeft;
	}
	
	public void deletePiece(int num){
		piecesLeft -= num;
	}
	
	public void addKingPiece(){
		kingedPieces ++;
	}
	
	public void deleteKingPiece(int num){
		kingedPieces -= num;
	}
	
	public int getKingedPieces()
	{
		return kingedPieces;
	}
}
