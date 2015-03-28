
public class BadSolver {
	
	Problem problem;
	
	public BadSolver(Problem problem) {
		this.problem = problem;
	}
	
	public Solution solve() {
		Solution solution = new Solution(problem);
		
		// TODO : solve problem
		Configuration start = new Configuration(problem.nbBallons);
		for (int i = 0 ; i < problem.nbBallons ; ++i) {
			start.setPosition(i, new Position3D(problem.depart, 0));
		}
		solution.initiale = start;
		
		solution.configurations = new Configuration[problem.nbTours];
		
		for (int tour = 0 ; tour < problem.nbTours ; ++tour) {
			Configuration config = new Configuration(problem.nbBallons);
			for (int i = 0 ; i < problem.nbBallons ; ++i) {
				config.setPosition(i, new Position3D(problem.depart, 1));
			}
			
			solution.configurations[tour] = config;
		}
		
		return solution;
	}

}
