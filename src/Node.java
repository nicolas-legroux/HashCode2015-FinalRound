import java.util.*;



public class Node {
	public int score;
	public List<Node> neighbors;
	private int bruteScore;
	private Position3D position;
	
	Node(Position3D position, int score) {
		neighbors = new LinkedList<Node>();
		this.bruteScore = score;
		this.score = score;
		this.position = position;
	}
	
	public void addNeighbor(Node node) {
		neighbors.add(node);
	}
	
	public List<Node> getNeighbors() {
		return neighbors;
	}
	
}
