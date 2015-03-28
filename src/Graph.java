import java.util.Map;


public class Graph {
	
	Node startingpoint;
	Map<Position3D, Node> map;
	
	//Todo starting point
	Graph(Map<Position3D,Node> map, Node startingpoint) {
		this.map = map;
		this.startingpoint = startingpoint;
	}
	
	public Node getStartingPoint() {
		return startingpoint;
	}

	public Node getNode(Position3D position) {
		return map.get(position);
	}
	
	public void print() {
		for(Node node : map.values()) {
		}
	}
}
