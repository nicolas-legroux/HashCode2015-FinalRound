import java.util.Map;
import java.util.Set;


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
	

	public Set<Position3D> getPositions(){
		return map.keySet();
	}
	
	public void print() {
		for(Node node : map.values()) 
			node.print();
	}
}
