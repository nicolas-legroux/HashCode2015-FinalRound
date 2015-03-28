import java.util.HashSet;
import java.util.Set;


public class Cible {
	
	Position2D position;
	Set<Position3D> positionsCouvrantes;
	
	Cible(Position2D pos){
		position = pos;
		positionsCouvrantes = new HashSet<Position3D>();
	}
	
	Set<Position3D> couvrant(Graph g){
		Set<Position3D> positions = new HashSet<Position3D>();
		for(Position3D position : g.getPositions()){
			if(true){
				positions.add(position);
			}
		}
		return null;
	}

}
