import java.util.LinkedList;
import java.util.List;

public class Path {
	
	LinkedList<Position3D> path;
	
	Path(){
		path = new LinkedList<Position3D>();
	}
	
	void add(Position3D pos){
		path.add(pos);
	}
	
	void addFirst(Position3D pos){
		path.addFirst(pos);
	}
	
	Position3D getLast(){
		return path.get(path.size()-1);
	}
	
	Position3D pollFirst(){
		return path.pollFirst();
	}

	public boolean isEmpty() {
		return path.isEmpty();
	}
	
	public List<Position3D> getPath() {
		return path;
	}
	
	void print(){
		for(Position3D pos : path){
			System.out.print("(" + pos.pos.x + ", " + pos.pos.y + ", " + pos.z + ") " );
		}
		System.out.println("");		
	}
	
	Path copy(){
		LinkedList<Position3D> cp = new LinkedList<Position3D>();
		for(Position3D pos : path){
			cp.add(pos);
		}	
		Path p = new Path();
		p.path = cp;
		return p;
	}
}
