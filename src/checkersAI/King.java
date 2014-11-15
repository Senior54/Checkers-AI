package checkersAI;

public class King extends Piece {

	/**
	 * Constructor for King class
	 * 
	 * @param color
	 *            The color of the king piece
	 * @param position
	 *            The position for the king to be placed.
	 */
	public King(char color, int row, int col) {
		super(color, row, col);
	}
	
	/**
	 * Gets the color of this piece. Overrides method in Piece class.
	 * @return The color of this piece
	 */
	public char getColor(){
		String c = "" + super.getColor();
		c = c.toLowerCase();
		return c.charAt(0);
	}

	/**
	 * Checks if moving this piece from the its current position to the given
	 * position is legal for a king.
	 * 
	 * @param position
	 *            The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 * @param endPosition
	 * @return
	 */
	public boolean isLegalMove(int endRow, int endCol) {
		if (checkBoundary(endRow, endCol)) {
			if ((endRow - super.getRow() == 1)
					|| (endRow - super.getRow() == -1)) {
				if ((endCol - super.getCol() == 1)
						|| (endCol - super.getCol() == -1)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * /** Checks if moving this king from the its current position to the given
	 * position is a legal jump.
	 * 
	 * @param position
	 *            The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 * @param endPosition
	 * @return
	 */
	public boolean isLegalJump(int endRow, int endCol) {
		if (checkBoundary(endRow, endCol)) {
			if ((endRow - super.getRow() == 2)
					|| (endRow - super.getRow() == -2)) {
				if ((endCol - super.getCol() == 2)
						|| (endCol - super.getCol() == -2)) {
					return true;
				}
			}
		}
		return false;
	}
}
