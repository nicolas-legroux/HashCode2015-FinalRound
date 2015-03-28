import java.util.HashMap;
import java.util.Map;


public class GraphBuilder {
	private Problem pb;
	
	Map<Position3D, Node> nodes;
	
	GraphBuilder(Problem pb) {
		this.pb = pb;
		nodes = new HashMap<Position3D, Node>(); //TODO IMPORTANT HASHCODE 3D WORKING
	}
	
	public void build() {
		
		//Creating the nodes
		Position3D pos;
		
		for(int x = 0; x < pb.nbColonnes; x++) {
			for(int y = 0; y < pb.nbLignes; y++) {
				for(int z = 0; z < pb.nbAltitudes; z++){
					pos = new Position3D(x,y,z);			
					nodes.put(pos, new Node(pos, computeScoreForPosition(x,y)));
				}
			}
		}
		
		Node nodehere;
		Node nodetherebehind;
		Node nodetheresame;
		Node nodethereabove;
		
		for(int x = 0; x < pb.nbColonnes; x++) {
			for(int y = 0; y < pb.nbLignes; y++) {
				for(int z = 0; z < pb.nbAltitudes; z++){
					nodehere = nodes.get(new Position3D(x,y,z));
					
					int newx = (x+pb.vents[x][y][z].ventx)%pb.nbColonnes;
					int newy = y+pb.vents[x][y][z].venty;
					if(newy >= 0 && newy < pb.nbLignes) 
					
					if(z-1 >= 0) {
						nodetherebehind = nodes.get(new Position3D(newx,newy,z-1));
					}
					
					nodetheresame = nodes.get(new Position3D(newx,newy,z));
					
					if(z+1 < pb.nbAltitudes) {
						nodethereabove = nodes.get(new Position3D(newx,newy,z+1));
					}
			
				}
			}
		}
		
		Vent[][][] vents; // (colonne, ligne, altitude)
	}
	
	private int computeScoreForPosition(int x, int y) {
		int score = 0;
		for(int p = x - pb.rayon; p <= x + pb.rayon; p++) {
			for(int q = y - pb.rayon; q <= y + pb.rayon; q++) {
				if((x - p)*(x - p) + columndist(y,q)*columndist(y,q) <= pb.rayon*pb.rayon 
						&& pb.cibles[p][q]) {
					score++;
				}
			}
		}
		
		return score;
	}
	
	private int columndist(int y, int q) {
		int a = Math.abs(y-q);
		return Math.min(a, pb.nbColonnes - a);
	}
	
}
