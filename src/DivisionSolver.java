import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DivisionSolver {

	Problem problem;
	Solution solution;
	Graph graph;
	
	private final int NPARALLELBALON = 20;
	private final int LOOKINGFORWARD = 2;
	private final int SALVEEVERY = 50;
	
	Position2D[][] ygoal;
	
	DivisionSolver(Problem problem) {
		this.problem = problem;
		GraphBuilder gb = new GraphBuilder(problem);
		graph = gb.build();
		//graph.print();
		ygoal = new Position2D[problem.nbColonnes][NPARALLELBALON];
		computeGoals();
		System.out.println("Goals built");
	}
	
	public void computeGoals() {
		for(int x = 0; x < problem.nbColonnes; x++) {
			int ymin = Integer.MAX_VALUE;
			int ymax = 0;
			int realx = 0;
			
			boolean found = false;
			for(int lookingx = x + LOOKINGFORWARD; !found; lookingx++) {
				for(int y=0; y < problem.nbLignes; y++) {
					realx = (lookingx + problem.nbColonnes)%problem.nbColonnes;
					Node n = graph.getNode(new Position3D(realx, y, 1));
					if(n == null)
						continue;
					if(n.getScore() >= 30) {
						found = true;
						if(y <= ymin)
							ymin = y;
						
						if(y >= ymax)
							ymax = y;
					}
					
					if(ymax <= 5)
						found = false;
				}
			}
			
			System.out.println("For x = " + x + " min y = " + ymin + " and max y = " + ymax);
			int delta = (ymax - ymin) / (NPARALLELBALON + 1); //TODO AMELIORER CIBLE
			
			for(int b = 0; b < NPARALLELBALON; b++)
				ygoal[x][b] = new Position2D(realx, ymin + (b+1) * delta);
			
		}
	}
	
	public Solution solve() {
		Solution solution = new Solution(problem);

		Configuration start = new Configuration(problem.nbBallons);
		
		solution.initiale = start;
		
		solution.configurations = new Configuration[problem.nbTours];
	
		
		Map<Integer, List<Position3D>> posbalons = new HashMap<Integer, List<Position3D>>();
		
		for (int i = 0 ; i < problem.nbBallons ; ++i) {
			int tour = 0;
			List<Position3D> listpos = new LinkedList<Position3D>();
			int isalve = (int) Math.floor(i / NPARALLELBALON);
			int iinsalve = i%NPARALLELBALON;
			Position3D actual = new Position3D(problem.depart,0);
			
			while(tour < problem.nbTours) {
				
				while(isalve * SALVEEVERY >= tour) {
					listpos.add(new Position3D(problem.depart, 0));
					tour++;
				}
				
				List<Position3D> betternextsteps = null;
				int leaststeps = Integer.MAX_VALUE;
				
				for(int z = 1; z <= problem.nbAltitudes; z++) {
					List<Position3D> nextsteps = Dijkstra.run(graph.getNode(actual), 
							graph.getNode(new Position3D(ygoal[actual.pos.x][iinsalve], z))).getPath();
					int cost = nextsteps.size();
					if(cost < leaststeps) {
						leaststeps = cost;
						betternextsteps = nextsteps;
					}
				}
				
				betternextsteps.remove(0);
				
				for(Position3D pos : betternextsteps) {
					listpos.add(pos);
					actual = pos;
					tour++;
				}
			}
			
			posbalons.put(i, listpos);
		}
			
		for (int tour = 0 ; tour < problem.nbTours ; ++tour) {
			Configuration config = new Configuration(problem.nbBallons);
			
			for (int i = 0 ; i < problem.nbBallons ; ++i) 
				config.setPosition(i, posbalons.get(i).get(tour));	
					
			solution.configurations[tour] = config;
		}
		
		return solution;
	}
	
}
