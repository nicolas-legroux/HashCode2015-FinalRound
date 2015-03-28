import java.util.LinkedList;
import java.util.List;

public class DivisionSolver {

	Problem problem;
	Solution solution;
	Graph graph;
	
	private final int NPARALLELBALON = 5;
	private final int LOOKINGFORWARD = 5;
	private final int SALVEEVERY = 10;
	
	int[][] ygoal;
	
	DivisionSolver(Problem problem) {
		this.problem = problem;
		GraphBuilder gb = new GraphBuilder(problem);
		graph = gb.build();
		ygoal = new int[problem.nbColonnes][NPARALLELBALON];
		computeGoals();
		System.out.println("Goals built");
	}
	
	public void computeGoals() {
		for(int x = 0; x < problem.nbColonnes; x++) {
			int ymin = Integer.MAX_VALUE;
			int ymax = 0;
			
			
			boolean found = false;
			for(int lookingx = x + LOOKINGFORWARD; !found; lookingx++) {
				for(int y=0; y < problem.nbLignes; y++) {
					int realx = (lookingx + problem.nbColonnes)%problem.nbColonnes;
					Node n = graph.getNode(new Position3D(realx, y, 1));
					if(n.getScore() > 0) {
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
			
			System.out.println("For x = " + x + " max y = " + ymax);
			int delta = (ymax - ymin) / NPARALLELBALON;
			
			for(int b = 0; b < NPARALLELBALON; b++)
				ygoal[x][b] = ymin + b * delta;
			
		}
	}
	
	public Solution solve() {
		Solution solution = new Solution(problem);

		// TODO : solve problem
		Configuration start = new Configuration(problem.nbBallons);
		
		int nsalve = (int) Math.ceil(problem.nbBallons / NPARALLELBALON);
		
		for (int i = 0 ; i < problem.nbBallons ; ++i) {
				start.setPosition(i, new Position3D(problem.depart, 0));
		}
		solution.initiale = start;
		
		solution.configurations = new Configuration[problem.nbTours];
		
		Configuration last = solution.initiale;
		
		
		for (int i = 0 ; i < problem.nbBallons ; ++i) {
			int tour = 0;
			List<Position3D> listpos = new LinkedList<Position3D>();
			int isalve = (int) Math.floor(i / NPARALLELBALON);
			int iinsalve = i%NPARALLELBALON;
			
			while(tour < problem.nbTours) {
				
				while(isalve * SALVEEVERY <= tour) {
					listpos.add(new Position3D(problem.depart, 0));
					tour++;
				}
				
				
			}
		}
			
		for (int tour = 0 ; tour < problem.nbTours ; ++tour) {
			Configuration config = new Configuration(problem.nbBallons);
			
			for (int i = 0 ; i < problem.nbBallons ; ++i) {
				int isalve = (int) Math.floor(i / NPARALLELBALON);
				
				if(isalve * SALVEEVERY < tour) { //les ballons suivant ne partent pas encore partis
					config.setPosition(i, last.posBallons[i]);
					continue; 
				}
				
				Node node = graph.getNode(last.posBallons[i]);
				
				List<Node> x = node.getNeighbors();
				if (x.size() > 0) {
					int next = generator.nextInt(x.size());
					config.setPosition(i, x.get(next).position);
				} else
					config.setPosition(i, last.posBallons[i]);
			}
			
			solution.configurations[tour] = config;
			last = config;
		}
		
		return solution;
	}
	//Fonction qui pour un ballon décide où il va aller au prochain tour
	Node nextStep(Node currentNode){
		
		Node nextNode = null;
		List<Node> neighbors = currentNode.getNeighbors();
		//TODO update score
		
		return nextNode;		
	}
	
	void simulateRound(){

	}
	
	
}
