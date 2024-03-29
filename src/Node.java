import java.util.*;



public class Node {
	public int score;
	public List<Node> neighbors;
	public List<Node> predecessors;
	private int bruteScore;
	public Position3D position;
	
	boolean visited;
	
	Node(Position3D position, int score) {
		neighbors = new LinkedList<Node>();
		predecessors = new LinkedList<Node>();
		this.bruteScore = score;
		this.score = score;
		this.position = position;
		this.visited = false;
	}
	
	public void addNeighbor(Node node) {
		neighbors.add(node);
		node.predecessors.add(this);
	}
	
	public void removeNeighbor(Node node) {
		neighbors.remove(node);
	}
	
	public List<Node> getNeighbors() {
		return neighbors;
	}
	
	public List<Node> getPredecessors() {
		return predecessors;
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
		/*
		System.out.println("Neighbors : ");
		for(Node n : neighbors){
			System.out.print("\t " + n.position + "\n");
		}
		*/
	}
	
	public void setVisited(){
		visited = true;
	}
	
	public boolean isVisited(){
		return visited;
	}
	
	public void resetVisited(){
		visited = false;
	}
	
}
