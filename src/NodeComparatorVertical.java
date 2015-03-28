import java.util.Comparator;

public class NodeComparatorVertical implements Comparator<Node> {

	int y;
	
	NodeComparatorVertical(int y){
		this.y = y;
	}
	@Override
	public int compare(Node o1, Node o2) {
		int distance1 = Math.abs(o1.position.pos.y-y);
		int distance2 = Math.abs(o2.position.pos.y-y);
		return distance1-distance2;
	}

	



}
