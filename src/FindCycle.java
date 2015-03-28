import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FindCycle {
	
	Position3D start;
	Set<Path> currentPaths;
	Set<Path> cycles;
	Graph g;
	
	FindCycle(Position3D start, Graph g){
		this.start = start;
		this.g = g;
		
		currentPaths = new HashSet<Path>();
		cycles = new HashSet<Path>();		
		Path firstPath = new Path();
		firstPath.add(start);
		currentPaths.add(firstPath);
	}
	
	void nextStep(){
		Set<Path> nextPaths = new HashSet<Path>();
		for(Path p : currentPaths){
			Position3D lastPos = p.getLast();
			Node n = g.getNode(lastPos);
			List<Node> neighbors = n.neighbors;
			for(Node neighbor : neighbors){
				Path pathCopy = p.copy();
				pathCopy.add(neighbor.position);
				if(start.equals(neighbor.position)){
					//System.out.println("Found Cycle");
					cycles.add(pathCopy);
				}
				else{
					//System.out.println("Did not find cycle");
					nextPaths.add(pathCopy);
				}
			}			
		}		
		currentPaths = nextPaths;	
	}
	
	void findCycles(int maxProfondeur){
		for(int i=0; i<maxProfondeur; i++){
			nextStep();
		}
		
		System.out.println("Done finding cycles.");
		System.out.println("Found " + cycles.size() + " cycles.");
		System.out.println("Printing paths : ");
		for(Path p : currentPaths){
			//p.print();
		}
	}

}
