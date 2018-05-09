import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Maze class that works with the Agent to find the shortest path through a
 * maze. The maze here is hardcoded as a list of Strings with 'X' being a wall
 * and ' ' being open space. Instances of the Maze class are differentiated by
 * the current location of the Agent.
 * 
 * @author Jasmine Roebuck, Quinn Masters, Alec Lunn, Brandon Arenas
 *
 */
public class Maze {

	private List<String> grid; // Maze representation
	private Node location; // Current location of the Agent
	private static HashSet<String> visited = new HashSet<String>(); // Set of visited nodes, must be static

	/**
	 * Maze instance constructor
	 * @param grid - maze representation as a list of Strings
	 * @param location - current location as a Node
	 */
	public Maze(List<String> grid, Node location) {
		this.grid = grid;
		this.location = location;
	}

	/**
	 * Getter method for the location Node
	 * @return - the location for this maze instance as a Node
	 */
	public Node getLocation() {
		return this.location;
	}

	/**
	 * Finds the valid moves given the current location. Calls isValid to validate
	 * @return - an ArrayList of Mazes representing possible moves
	 */
	public ArrayList<Maze> moves() {
		ArrayList<Maze> moves = new ArrayList<Maze>();
		Node[] list = new Node[4];
		list[0] = new Node(location.getRow() - 1, location.getIndex(), location); // North tile
		list[1] = new Node(location.getRow(), location.getIndex() + 1, location); // East tile
		list[2] = new Node(location.getRow() + 1, location.getIndex(), location); // South tile
		list[3] = new Node(location.getRow(), location.getIndex() - 1, location); // West tile

		for (int i = 0; i < 4; i++) {
			if (isValid(list[i])) {
				visited.add("" + list[i].getRow() + list[i].getIndex()); // Mark it as visited
				moves.add(new Maze(grid, list[i])); // Add to list of possible moves
			}
		}
		return moves;
	}

	/**
	 * Given a possible move Node, checks to see if the move is valid
	 * @param move - the move Node to be checked
	 * @return - true if the move is valid, false otherwise
	 */
	public boolean isValid(Node move) {
		if (move.getRow() < 0 || move.getRow() >= grid.size()) {
			if (move.getIndex() < 0 || move.getIndex() >= grid.size()) {
				return false; // Move is outside the border
			}
		}
		if (grid.get(move.getRow()).charAt(move.getIndex()) == 'X') {
			return false; // Move is into a wall
		}

		if (visited.contains("" + move.getRow() + move.getIndex())) {
			return false; // Location visited previously
		}
		return true;
	}

	/**
	 * Returns a new Maze instance with a move made
	 * @param move - the new location
	 * @return - the Maze instance with the new location Node
	 */
	public Maze neighbor(Node move) {
		Maze neighbor = new Maze(grid, move);
		return neighbor;
	}

	/**
	 * Builds a String representation of the Maze, with a '*' to mark the current
	 * location
	 * @return - the String representation of the maze
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < grid.size(); row++) {
			for (int index = 0; index < grid.get(row).length(); index++) {
				if (location.getRow() == row && location.getIndex() == index) {
					sb.append("*");
				} else {
					sb.append(grid.get(row).charAt(index));
				}
			}
			sb.append("\n");
		}
		sb.append("\n");
		String res = sb.toString();
		return res;
	}

	/**
	 * Main method that builds the maze and prints the results of the search
	 */
	public static void main(String[] args) {

		List<String> grid = new ArrayList<String>();

		// Hardcoded maze
		grid.add("XXXXXXXXXXXXXXXXXXXX");
		grid.add("X     X    X       X");
		grid.add("X XXXXX XXXX XXX XXX");
		grid.add("X       X      X X X");
		grid.add("X X XXX XXXXXX X X X");
		grid.add("X X   X        X X X");
		grid.add("X XXX XXXXXX XXXXX X");
		grid.add("X XXX    X X X     X");
		grid.add("X    XXX       XXXXX");
		grid.add("XXXXX   XXXXXX     X");
		grid.add("X   XXX X X    X X X");
		grid.add("XXX XXX X X XXXX X X");
		grid.add("X     X X   XX X X X");
		grid.add("XXXXX     XXXX X XXX");
		grid.add("X     X XXX    X   X");
		grid.add("X XXXXX X XXXX XXX X");
		grid.add("X X     X  X X     X");
		grid.add("X X XXXXXX X XXXXX X");
		grid.add("X X                X");
		grid.add("XXXXXXXXXXXXXXXXXX X");

		Maze maze = new Maze(grid, new Node(1, 1)); // Starting maze instance
		System.out.println(maze);
		Agent agent = new Agent();
		Maze goal = new Maze(grid, new Node(19, 18)); // Goal maze instance

		Stack<Node> path = agent.bfs(maze, goal); // Stack of final move Nodes

		// Print the stack of moves
		while (!path.empty()) {
			Node move = path.pop();
			maze = maze.neighbor(move);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(maze);
		}
	}
}
