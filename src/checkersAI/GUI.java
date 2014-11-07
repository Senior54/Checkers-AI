package checkersAI;

import java.util.Scanner;

public class GUI {
	
	// will pull pieces from the array and will add this in later
	public void drawBoard(Grid[] grid) {
		System.out.println("-------------------------------------------------");
		System.out.println("|     | "+grid[1].getGridString()+" |     | "+grid[2].getGridString()+" |     | "+grid[3].getGridString()+" |     | "+grid[4].getGridString()+" |");
		System.out.println("-------------------------------------------------");
		System.out.println("| "+grid[5].getGridString()+" |     | "+grid[6].getGridString()+" |     | "+grid[7].getGridString()+" |     | "+grid[8].getGridString()+" |     |");
		System.out.println("-------------------------------------------------");
		System.out.println("|     | "+grid[9].getGridString()+" |     | "+grid[10].getGridString()+" |     | "+grid[11].getGridString()+" |     | "+grid[12].getGridString()+" |");
		System.out.println("-------------------------------------------------");
		System.out.println("| "+grid[13].getGridString()+" |     | "+grid[14].getGridString()+" |     | "+grid[15].getGridString()+" |     | "+grid[16].getGridString()+" |     |");
		System.out.println("-------------------------------------------------"); 
		System.out.println("|     | "+grid[17].getGridString()+" |     | "+grid[18].getGridString()+" |     | "+grid[19].getGridString()+" |     | "+grid[20].getGridString()+" |");
		System.out.println("-------------------------------------------------");
		System.out.println("| "+grid[21].getGridString()+" |     | "+grid[22].getGridString()+" |     | "+grid[23].getGridString()+" |     | "+grid[24].getGridString()+" |     |");
		System.out.println("-------------------------------------------------");
		System.out.println("|     | "+grid[25].getGridString()+" |     | "+grid[26].getGridString()+" |     | "+grid[27].getGridString()+" |     | "+grid[28].getGridString()+" |");
		System.out.println("-------------------------------------------------");
		System.out.println("| "+grid[29].getGridString()+" |     | "+grid[30].getGridString()+" |     | "+grid[31].getGridString()+" |     | "+grid[32].getGridString()+" |     |");
		System.out.println("-------------------------------------------------");
	}
	
	public int[] getMove(GameEngine engine, Scanner scan) {
		System.out.println("Player "+ engine.getCurrentPLayer() + " please select a piece");
		String line = scan.nextLine();
		int currPos = Integer.parseInt(line);
		System.out.println("Player "+ engine.getCurrentPLayer() + " please make a move");
		line = scan.nextLine();
		int endPos = Integer.parseInt(line);
		int[] move = new int[2];
		move[0] = currPos;
		move[1] = endPos;
		return move;
	}
}
