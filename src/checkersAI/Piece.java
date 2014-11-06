package checkersAI;

public abstract class Piece {

	String color;
	int position;
	
	/**
	 * Constructor for a Piece
	 * @param color The color of the piece
	 * @param startingPos The starting position of the piece on the board
	 */
	public Piece(String color, int startingPos){
		this.color = color;
		position = startingPos;
	}
	
	/**
	 * Gets the color of this piece
	 * @return The color of this piece
	 */
	public String getColor(){
		return color;
	}
	
	/**
	 * Gets the current position of this piece on the board
	 * @return The position on the board.
	 */
	public int getPosition(){
		return position;
	}
	
	/**
	 * Checks if moving this piece from the its current position to
	 * the given position is legal. Should be overwritten in subclasses.
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public abstract boolean isLegalMove(int position);
	
	/**
	 * Checks if moving this piece from the its current position to
	 * the given position is a legal jump. Should be overwritten in subclasses.
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public abstract boolean isLegalJump(int position);
	
	/**
	 * Sets the current position of this piece to the given position.
	 * @param pos The position on the board to move this piece to.
	 */
	public void setPosition(int pos){
		position = pos;
	}
}
