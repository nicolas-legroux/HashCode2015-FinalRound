import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;


public class Dijkstra {
	
	// Best path from src to dst
	static public Path run(Node src, Node dst) {
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

		Path path = new Path();
		
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
	
	class NodeAndScore {
		Node node;
		int score;
		
		public NodeAndScore(Node node, int score) {
			this.node = node;
			this.score = score;
		}
	}
	
	class NodeAndScoreComparator implements Comparator<NodeAndScore> {

		@Override
		public int compare(NodeAndScore arg0, NodeAndScore arg1) {
			// TODO Auto-generated method stub
			return arg0.score - arg1.score;
		}
	}
	
	// Best path from src to dst
	public Path findFirst(Node src, HashSet<Position3D> dst) {
		HashMap<Position3D, Position3D> reverse = new HashMap<Position3D, Position3D>();
		HashMap<Node, Integer> score = new HashMap<Node, Integer>();
		
		reverse.put(src.position, src.position);
		score.put(src, 0);
		
		PriorityQueue<NodeAndScore> queue = new PriorityQueue<NodeAndScore>(1, new NodeAndScoreComparator());
		queue.add(new NodeAndScore(src, 0));
		
		Position3D first = null;
		while (!queue.isEmpty()) {
			NodeAndScore elem = queue.poll();
			Node node = elem.node;
			int myScore = elem.score;
			
			/*
			node.print();
			System.out.println("score = " + myScore);
			//*/
			
			if (dst.contains(node.position) && myScore > 0) {
				first = node.position;
				/*
				node.print();
				System.out.println("score = " + myScore);
				//*/
				break;
			}
			
			if (myScore == score.get(node)) {
				for (Node next : node.getNeighbors()) {
					Integer lastScore = score.get(next);
					if (lastScore == null || myScore + 1 < lastScore) {
						reverse.put(next.position, node.position);
						score.put(next, myScore + 1);
						queue.add(new NodeAndScore(next, myScore + 1));
					}
				}
			}
		}

		if (first == null)
			return null;
			
		Path path = new Path();
		
		Position3D iter = first;
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
