import java.util.*;



public class Node {
	public int score;
	public List<Node> neighbors;
	
	Node() {
		neighbors = new LinkedList<Node>();
	}
	
	public void addNeighbor(Node node) {
		neighbors.add(node);
	}
	
	public List<Node> getNeighbors() {
		return neighbors;
	}
	
}
