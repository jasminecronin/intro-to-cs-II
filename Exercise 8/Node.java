
/**
 * Node class that represents a location in the maze. Contains a row, String
 * index, and pointer to the parent, which is necessary for the final
 * backtracking.
 * 
 * @author Jasmine Roebuck, Quinn Masters, Alec Lunn, Brandon Arenas
 *
 */
public class Node {

	private int row; // Row of the String containing this location
	private int index; // Index of the String containing this location
	private Node parent = null; // Parent pointer, assigned during the BFS

	/**
	 * Getter for the row
	 * @return - current row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Getter for the index
	 * @return - current index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Getter for the parent pointer
	 * @return - pointer to parent Node
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * Constructor with no parent pointer, used for starting and ending maze
	 * instances
	 * @param r - row of current location
	 * @param i - index of current location
	 */
	public Node(int r, int i) {
		this.row = r;
		this.index = i;
	}

	/**
	 * Constructor with a parent pointer, used when performing the BFS
	 * @param r - row of current location
	 * @param i - index of current location
	 * @param parent - pointer to parent Node (how the Agent got to the current Node)
	 */
	public Node(int r, int i, Node parent) {
		this.row = r;
		this.index = i;
		this.parent = parent;
	}

}
