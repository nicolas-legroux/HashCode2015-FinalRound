import java.util.LinkedList;
import java.util.List;


public class Graph {
	
	List<Node> startingpoints;
	
	Graph() {
		startingpoints = new LinkedList<Node>();
	}
	
	public void addStartingPoint(Node node) {
		startingpoints.add(node);
	}
	
}
