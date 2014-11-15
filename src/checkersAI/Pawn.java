package checkersAI;

public class Pawn extends Piece {

	/**
	 * Constructor for Pawn class
	 * @param color
	 *            The color of the Pawn
	 * @param startingPos
	 *            The starting position of the Pawn
	 */
	public Pawn(char color, int row, int col) {
		super(color, row, col);
	}

	/**
	 * check if the move is in a valid row
	 * @param endPosition
	 * @return
	 */

	private boolean isLegalMoveHelperRed(int endRow, int endCol) {
		if (endRow - super.getRow() == -1) {
			if ((endCol - super.getCol() == 1)
					|| (endCol - super.getCol() == -1)) {
				return true;
			}
		}
		return false;
	}

	private boolean isLegalMoveHelperBlack(int endRow, int endCol) {

		if (endRow - super.getRow() == 1) {
			if ((endCol - super.getCol() == 1)
					|| (endCol - super.getCol() == -1)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if moving this piece from the its current position to the given
	 * position is legal for a pawn.
	 * 
	 * @param position
	 *            The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public boolean isLegalMove(int endRow, int endCol) {
		if (checkBoundary(endRow, endCol)) {

			if (super.getColor() == 'r') {
				return isLegalMoveHelperRed(endRow, endCol);
			}

			else {
				return isLegalMoveHelperBlack(endRow, endCol);
			}
		}

		return false;
	}

	private boolean isLegalJumpHelperRed(int endRow, int endCol) {
		if (endRow - super.getRow() == -2) {
			if ((endCol - super.getCol() == 2)
					|| (endCol - super.getCol() == -2)) {
				return true;
			}
		}

		return false;
	}

	private boolean isLegalJumpHelperBlack(int endRow, int endCol) {
		if (endRow - super.getRow() == 2) {
			if ((endCol - super.getCol() == 2)
					|| (endCol - super.getCol() == -2)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if moving this pawn from the its current position to the given
	 * position is a legal jump.
	 * 
	 * @param position
	 *            The position on the board to move this piece to.
	 * @return True if the move is legal, false otherwise.
	 */
	public boolean isLegalJump(int endRow, int endCol) {
		if (checkBoundary(endRow, endCol)) {
			if (super.getColor() == 'r') {
				return isLegalJumpHelperRed(endRow, endCol);
			} else {
				return isLegalJumpHelperBlack(endRow, endCol);
			}
		}
		return false;
	}
}
