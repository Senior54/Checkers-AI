package checkersAI;

import java.util.ArrayList;

public class Node {

	private ArrayList<Node> children = new ArrayList<Node>();
	private Piece[][] boardState;

	/**
	 * Constructor for a Node.
	 * 
	 * @param b
	 *            The current state of the board
	 */
	public Node(Piece[][] b) {
		boardState = b;

	}

	/**
	 * Adds a child for this node. A child represents one move of a player in
	 * the game.
	 * 
	 * @param n
	 */
	public void addChild(Node n) {
		children.add(n);
	}
}
