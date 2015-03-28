import java.util.HashSet;
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
	
	void next

}
