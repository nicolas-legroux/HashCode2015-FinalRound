import java.util.*;



public class Node {
	public int score;
	public List<Node> neighbors;
	private int bruteScore;
	public Position3D position;
	
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
	
	public int getScore() {
		return score;
	}
	
	public void setScoreNul() {
		score = 0;
	}
	
	public void setRealScore() {
		score = bruteScore;
	}
	
	public void print() {
		System.out.println("Node at " + position + " has a score of " + getScore() + " and has " + getNeighbors().size() +" neighbors");
	}
	
}
