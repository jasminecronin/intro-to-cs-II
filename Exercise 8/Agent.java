import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Agent traverses a given maze with a given goal. It returns a list of Nodes
 * describing the shortest path through the maze found using a BFS.
 *
 * @author Jasmine Roebuck, Quinn Masters, Alec Lunn, Brandon Arenas
 */
public class Agent {

	/**
	 * Return a stack of moves as Node objects to get the maze to match the goal
	 * 
	 * @param maze - the starting maze instance
	 * @param goal - the desired maze instance
	 * @return - the stack of necessary moves
	 */
	public Stack<Node> bfs(Maze maze, Maze goal) {
		Queue<Maze> queue = new LinkedList<Maze>(); // For the BFS
		Stack<Node> path = new Stack<Node>(); // To store the final moveset
		Node parent = null;
		queue.add(maze);

		while (!queue.isEmpty()) {
			Maze current = queue.remove();
			if (current.getLocation().getRow() == goal.getLocation().getRow()) { // If goal is found
				if (current.getLocation().getIndex() == goal.getLocation().getIndex()) {
					path.push(current.getLocation()); // Add goal node to the stack
					parent = current.getLocation().getParent(); // Record the parent
					break; // Stop the search
				}
			} else {
				ArrayList<Maze> moves = current.moves(); // Request valid moves
				for (Maze move : moves) {
					queue.add(move); // Add to the queue
				}
			}
		}

		// Backtracking to record the shortest path
		while (parent != null) {
			path.push(parent);
			parent = parent.getParent();
		}
		return path;
	}
}
