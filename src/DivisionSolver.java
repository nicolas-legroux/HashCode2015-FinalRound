import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DivisionSolver {

	Problem problem;
	Solution solution;
	Graph graph;
	Random generator;
	
	private final int NPARALLELBALON = 6;
	private final int LOOKINGFORWARD = 10;
	private final int SALVEEVERY = 5;
	
	Position2D[][] ygoal;
	
	DivisionSolver(Problem problem) {
		this.problem = problem;
		GraphBuilder gb = new GraphBuilder(problem);
		graph = gb.build();
		//graph.print();
		ygoal = new Position2D[problem.nbColonnes][NPARALLELBALON];
		computeGoals();
		generator = new Random(123456789);
		System.out.println("Goals built");
	}
	
	public void computeGoals() {
		for(int x = 0; x < problem.nbColonnes; x++) {
			int ymin = 0;
			int ymax = 74;
			
			int realx = (x + LOOKINGFORWARD + problem.nbColonnes)%problem.nbColonnes;
			
			if(realx <= 120) {
				ymin = 0;
				ymax = 74;
			} else {
				ymin = 0;
				ymax = 40;
			}
			
			
			System.out.println("For x = " + x + " min y = " + ymin + " and max y = " + ymax);
			double delta = (double)(ymax - ymin) / (NPARALLELBALON + 1); //TODO AMELIORER CIBLE
			
			for(int b = 0; b < NPARALLELBALON; b++) {
				int ny = (int)(ymin + (b+1) * delta);
				ygoal[x][b] = new Position2D(realx, ny);
				System.out.println("Ballon " + b + " at x " + x + " goes at y " + ny);
			}
			
			
		}
	}
	
	public Solution solve() {
		Solution solution = new Solution(problem);

		Configuration start = new Configuration(problem.nbBallons);
		
		solution.initiale = start;
		for (int i = 0 ; i < problem.nbBallons ; ++i) {
			start.setPosition(i, new Position3D(problem.depart, 0));
		}
		solution.configurations = new Configuration[problem.nbTours];
	
		
		Map<Integer, List<Position3D>> posbalons = new HashMap<Integer, List<Position3D>>();
		
		for (int i = 0 ; i < problem.nbBallons ; ++i) {
			System.out.println("Done with ballon " + i);
			int tour = 0;
			List<Position3D> listpos = new LinkedList<Position3D>();
			int isalve = (int) Math.floor(i / NPARALLELBALON);
			int iinsalve = i%NPARALLELBALON;
			Position3D actual = new Position3D(problem.depart,0);
			
			tourcounter : while(tour < problem.nbTours) {
				
				while(isalve * SALVEEVERY >= tour) {
					listpos.add(new Position3D(problem.depart, 0));
					tour++;
				}
				
				List<Position3D> betternextsteps = null;
				int leaststeps = Integer.MAX_VALUE;
				
				
				Position2D goal = ygoal[actual.pos.x][iinsalve];
				boolean foundpath = false;
				
				startsearchgoal : for(int brutep = goal.x - 1; brutep <= goal.x + 1; brutep++) {
					for(int q = goal.y - 1; q <= goal.x + 1; q++) {
						if(q < 0 || q >= problem.nbLignes)
							continue;
						
						int p = (brutep + problem.nbColonnes)%problem.nbColonnes;
						
						
						
						for(int z = 1; z < problem.nbAltitudes; z++) {
							Path path = Dijkstra.run(graph.getNode(actual), 
									graph.getNode(new Position3D(p, q, z)));
							
							if(path == null)
								continue;
							
							List<Position3D> nextsteps = path.getPath();
							
							foundpath = true;
							int cost = nextsteps.size();
							if(cost < leaststeps) {
								leaststeps = cost;
								betternextsteps = nextsteps;
							}
						}
						
						if(foundpath)
							break startsearchgoal;
						
					}
				}
				
				
				if(betternextsteps != null)
					betternextsteps.remove(0);
				
				if(!foundpath) {
					betternextsteps = new LinkedList<Position3D>();
					
					Node node = graph.getNode(actual);
					List<Node> x = node.getNeighbors();
					if (x.size() > 0) {
						int next = generator.nextInt(x.size());
						betternextsteps.add(x.get(next).position);
						System.out.println("Random");
					} else {
						betternextsteps.add(actual);
						
					}
				}
				

				for(Position3D pos : betternextsteps) {
			
					listpos.add(pos);
					actual = pos;
					
					if(tour + 1 > problem.nbTours)
						break tourcounter;
					
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
