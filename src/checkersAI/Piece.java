package checkersAI;

public abstract class Piece {

	private char color;
	private int row;
	private int col;
	
	/**
	 * Constructor for a Piece
	 * @param color The color of the piece
	 * @param startingPos The starting position of the piece on the board
	 */
	public Piece(char color, int row, int col){
		this.color = color;
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Gets the color of this piece
	 * @return The color of this piece
	 */
	public char getColor(){
		return color;
	}
	
	/**
	 * Gets the current position of this piece on the board
	 * @return The position on the board.
	 */
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	/**
	 * Checks if moving this piece from the its current position to
	 * the given position is legal. Should be overwritten in subclasses.
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public abstract boolean isLegalMove(int row, int col);
	
	/**
	 * Checks if moving this piece from the its current position to
	 * the given position is a legal jump. Should be overwritten in subclasses.
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public abstract boolean isLegalJump(int row, int col);
	
	//checks make sure the piece doesnt try to go to a position 
	//out of the boundary, for example, row -1, col 9
	public boolean checkBoundary(int endRow, int endCol)
	{
		if(endRow >=0 && endRow <= 7 )
		{
			if(endCol >= 0 && endCol <= 7)
				{return true;}
		}
		return false;
	}
	
	/**
	 * Sets the current position of this piece to the given position.
	 * @param pos The position on the board to move this piece to.
	 */
	public void setPosition(int row, int col){
		this.row = row;
		this.col = col;
	}


}
