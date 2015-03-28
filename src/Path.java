import java.util.LinkedList;
import java.util.List;

public class Path {
	
	List<Position3D> path;
	
	Path(){
		path = new LinkedList<Position3D>();
	}
	
	void add(Position3D pos){
		path.add(pos);
	}
	
	Position3D getLast(){
		return path.get(path.size()-1);
	}
	
	void print(){
		for(Position3D pos : path){
			System.out.print("(" + pos.pos.x + ", " + pos.pos.y + ", " + pos.z + ") " );
		}
		System.out.println("");		
	}
}
