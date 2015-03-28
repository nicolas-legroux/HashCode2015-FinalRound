import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCycle {
	
	Position3D start;
	Set<Path> currentPaths;
	Path cycle = null;
	Graph g;

	FindCycle(Position3D start, Graph g) {
		this.start = start;
		this.g = g;

		currentPaths = new HashSet<Path>();		
		Path firstPath = new Path();
		firstPath.add(start);
		currentPaths.add(firstPath);
	}

	boolean nextStep(int i) {
		Set<Path> nextPaths = new HashSet<Path>();
		for (Path p : currentPaths) {
			Position3D lastPos = p.getLast();
			Node n = g.getNode(lastPos);
			List<Node> neighbors = n.neighbors;
			for (Node neighbor : neighbors) {
				if (!neighbor.isVisited() && Math.abs(neighbor.position.pos.y-start.pos.y) < 3) {
					
					Path pathCopy = p.copy();
					pathCopy.add(neighbor.position);
					if (start.equals(neighbor.position)) {
						cycle = pathCopy;
						return true;
					} else {						
						nextPaths.add(pathCopy);
					}
					
					neighbor.setVisited();
				}
			}
		}
		currentPaths = nextPaths;
		System.out.println("Done with step "  + i);
		System.out.println("Current paths is of size " + currentPaths.size());
		return false;		
	}

	void findCycles(int maxProfondeur) {
		for (int i = 0; i < maxProfondeur; i++) {
			boolean b = nextStep(i);
			if(b){
				break;
			}
		}

		System.out.println("Done finding cycle.");		
		if(cycle == null){
			System.out.println("Did not find cycle.");
		}
		else{
			System.out.println("The cycle is of size " + cycle.path.size());
			cycle.print();
		}
	}

}
