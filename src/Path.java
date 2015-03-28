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
	
	Path copy(){
		List<Position3D> cp = new LinkedList<Position3D>();
		for(Position3D pos : path){
			cp.add(pos);
		}	
		Path p = new Path();
		p.path = cp;
		return p;
	}
}
