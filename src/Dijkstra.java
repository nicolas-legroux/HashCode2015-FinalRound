import java.util.HashMap;
import java.util.LinkedList;


public class Dijkstra {
	
	// Best path from src to dst
	static public LinkedList<Position3D> run(Node src, Node dst) {
		HashMap<Position3D, Position3D> reverse = new HashMap<Position3D, Position3D>();
		HashMap<Node, Integer> score = new HashMap<Node, Integer>();
		
		reverse.put(src.position, src.position);
		score.put(src, 0);
		
		LinkedList<Node> stack = new LinkedList<Node>();
		stack.add(src);
		
		while (!stack.isEmpty()) {
			Node node = stack.poll();
			int myScore = score.get(node);
			
			for (Node next : node.getNeighbors()) {
				Integer lastScore = score.get(next);
				if (lastScore == null || myScore + 1 < lastScore) {
					reverse.put(next.position, node.position);
					score.put(next, myScore + 1);
					stack.add(next);
				}
			}
		}

		LinkedList<Position3D> path = new LinkedList<Position3D>();
		
		Position3D iter = dst.position;
		for (;;) {
			path.addFirst(iter);
			Position3D newiter = reverse.get(iter);
			if (iter.equals(newiter))
				break;
			iter = newiter;
		}
		
		return path;
	}

}
