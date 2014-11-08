package checkersAI;

public abstract class Piece {

	private String color;
	private int position;
	private int rowPos;
	// Each piece has neighboring squares around its current position with a
	// minimum of one and a maximum of four.
	private int[] neighboringSquares = new int[4];
	
	/**
	 * Constructor for a Piece
	 * @param color The color of the piece
	 * @param startingPos The starting position of the piece on the board
	 */
	public Piece(String color, int startingPos){
		this.color = color;
		position = startingPos;
		setRowPos(position);
		findNeighboringSquares();
	}
	
	/**
	 * Finds the positions of squares on the board which are neighbors to the 
	 * square that this piece is in. Stored in neighboringSquares field. May
	 * contain a value of zero for a neighbor if this piece's position is on 
	 * the edge of the board.
	 */
	private void findNeighboringSquares(){
		int numberOfNeighbors = 0;
		switch (position) {
			case  4:
			case 29:
				numberOfNeighbors = 1;
				break;
			case 1:
			case 2:
			case 3:
			case 5:
			case 12:
			case 13:
			case 20:
			case 21:
			case 28:
			case 30:
			case 31:
			case 32:
				numberOfNeighbors = 2;
				break;
			default:
				numberOfNeighbors = 4;
				break;
		}
		
		if(numberOfNeighbors == 1){
			if(rowPos == 1){
				// Corner position 4, only has position 8 for a neighbor
				neighboringSquares[0] = 8;
			}else if (rowPos == 8){
				// Corner position 29, only has position 25 for a neighbor
				neighboringSquares[0] = 25;
			}
		}else if(numberOfNeighbors == 2){
			if(rowPos == 1){
				// Position is 1, 2, or 3
				neighboringSquares[0] = position + 4;
				neighboringSquares[1] = position + 5;
			}else if (rowPos == 8){
				// Position is 30, 31, 32
				neighboringSquares[0] = position - 5;
				neighboringSquares[1] = position - 4;
			}else{
				// Positions 5, 12, 13, 20, 21, 28
				neighboringSquares[0] = position - 4;
				neighboringSquares[1] = position + 4;
			}
		}else{
			// Positions with four neighbors are not on the edge of the board.
			if ( rowPos % 2 == 1 ){
				// Piece is in an odd numbered row
				neighboringSquares[0] = position - 4; // top left neighbor
				neighboringSquares[1] = position - 3; // top right neighbor
				neighboringSquares[2] = position + 4; // bottom left neighbor
				neighboringSquares[3] = position + 5; // bottom right neighbor
			}else if( rowPos % 2 == 0 ){
				// Piece is in an even numbered row
				neighboringSquares[0] = position - 5; // top left neighbor
				neighboringSquares[1] = position - 4; // top right neighbor
				neighboringSquares[2] = position + 3; // bottom left neighbor
				neighboringSquares[3] = position + 4; // bottom right neighbor
			}
		}
	}
	
	/**
	 * Gets the color of this piece
	 * @return The color of this piece
	 */
	public String getColor(){
		return color;
	}
	
	public int[] getNeighboringSquares() {
		return neighboringSquares;
	}
	
	/**
	 * Gets the current position of this piece on the board
	 * @return The position on the board.
	 */
	public int getPosition(){
		return position;
	}
	
	/**
	 * Gets the row that this piece is currently in.
	 * @return The row of the board (1 - 8).
	 */
	public int getRowNumber(){
		return rowPos;
	}
	
	/**
	 * Checks if moving this piece from the its current position to
	 * the given position is a legal jump. Should be overwritten in subclasses.
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public abstract boolean isLegalJump(int position);
	
	/**
	 * Checks if moving this piece from the its current position to
	 * the given position is legal. Should be overwritten in subclasses.
	 * @param position The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public abstract boolean isLegalMove(int position);

	/**
	 * Determines what row a piece is currently in and stores that value
	 * in the field rowPos.
	 * @param pos The current position of the piece (0 < pos < 33).
	 */
	private void setRowPos(int pos){
		if(pos == 1 || pos == 2 || pos == 3 || pos == 4){
			rowPos = 1;
		}else if (pos == 5 || pos == 6 || pos == 7 || pos == 8){
			rowPos = 2;
		}else if (pos == 9 || pos == 10 || pos == 11 || pos == 12){
			rowPos = 3;
		}else if (pos == 13 || pos == 14 || pos == 15 || pos == 16){
			rowPos = 4;
		}else if (pos == 17 || pos == 18 || pos == 19 || pos == 20){
			rowPos = 5;
		}else if (pos == 21 || pos == 22 || pos == 23 || pos == 24){
			rowPos = 6;
		}else if (pos == 25 || pos == 26 || pos == 27 || pos == 28){
			rowPos = 7;
		}else if (pos == 29 || pos == 30 || pos == 31 || pos == 32){
			rowPos = 8;
		}
	}
	
	/**
	 * Sets the current position of this piece to the given position.
	 * @param pos The position on the board to move this piece to.
	 */
	public void setPosition(int pos){
		position = pos;
	}
}
