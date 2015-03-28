import java.util.HashMap;
import java.util.Map;


public class GraphBuilder {
	private Problem pb;
	
	Map<Position3D, Node> nodes;
	
	GraphBuilder(Problem pb) {
		this.pb = pb;
		nodes = new HashMap<Position3D, Node>(); //TODO IMPORTANT HASHCODE 3D WORKING
	}
	
	public Graph build() {
		
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
		Node startingpoint = nodes.get(new Position3D(pb.depart.x, pb.depart.y, 0));
		
		Graph graph = new Graph(nodes, startingpoint);
		
		/*
		Node nodehere;
		Node nodethere;

		//*/
		
		//now adding the edges
		for(int x = 0; x < pb.nbColonnes; x++) {
			for(int y = 0; y < pb.nbLignes; y++) {
				for(int z = 0; z < pb.nbAltitudes; z++){
					Node src = nodes.get(new Position3D(x,y,z));
					
					for (int newz = z-1 ; newz <= z+1 ; ++newz) {
						if (newz <= 0 || newz >= pb.nbAltitudes) 
							continue;
						Position3D newpos = src.position.move(newz, pb.vents[x][y][newz], pb.nbLignes, pb.nbColonnes);
						if (newpos != null)
							src.addNeighbor(nodes.get(newpos));
					}
					/*
					for(int newz = z-1; newz <= z+1; newz++) {
						if(newz < 0 || newz >= pb.nbAltitudes) 
							continue;
						
						int newx = (x+pb.vents[x][y][newz].ventx + pb.nbColonnes)%pb.nbColonnes;
						int newy = y+pb.vents[x][y][newz].venty;
						
						if(newy < 0 || newy >= pb.nbLignes) 
							continue;
						
						nodethere = nodes.get(new Position3D(newx,newy,newz));
						nodehere.addNeighbor(nodethere);
					}
					//*/
				}
			}
		}

		
		return graph;
	}
	
	private int computeScoreForPosition(int x, int y) {
		int score = 0;
		for(int brutep = x - pb.rayon; brutep <= x + pb.rayon; brutep++) {
			for(int q = y - pb.rayon; q <= y + pb.rayon; q++) {
				if(q < 0 || q >= pb.nbLignes)
					continue;
				
				int p = (brutep + pb.nbColonnes)%pb.nbColonnes;
				
				if((y - q)*(y - q) + columndist(x,p)*columndist(x,p) <= pb.rayon*pb.rayon 
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
