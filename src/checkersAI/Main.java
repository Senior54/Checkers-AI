package checkersAI;

public class Main {

	public static Piece[] board = new Piece[33]; // ignore 0th index
	public static Grid[] grid = new Grid[33]; // stores piece strings in grid objects or empty string grid objects
	
	public static void main(String[] args) {
		Game game = new Game();
		
		// placing pieces on the board
				for (int i = 1; i < 13; i++) {
					board[i] = new Pawn("B", i);
					grid[i] = new Grid(i);
					grid[i].setStr(board[i].getText());
				}
				for (int i = 13; i < 21; i++)
					grid[i] = new Grid(i);
				for (int i = 21; i < 33; i++) {
					board[i] = new Pawn("R", i);
					grid[i] = new Grid(i);
					grid[i].setStr(board[i].getText());
				}
		//GUI test = new GUI();
		//test.drawBoard(grid);
		//game.begin();
	}

}
