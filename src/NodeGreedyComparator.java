import java.util.Comparator;

public class NodeGreedyComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return (o1.getScore()-o2.getScore());
	}

	



}
