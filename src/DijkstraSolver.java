import java.util.List;
import java.util.Random;


public class DijkstraSolver {
	
	Problem problem;
	Random generator;
	
	public DijkstraSolver(Problem problem) {
		this.problem = problem;
		generator = new Random(123456789);
	}
	
	public Solution solve() {
		Solution solution = new Solution(problem);

		GraphBuilder builder = new GraphBuilder(problem);
		Graph graph = builder.build();
		
		Dijkstra dijkstra = new Dijkstra();
		Path path = dijkstra.findFirst(graph.startingpoint, problem.setCibles);
		path.print();
		
		// TODO : solve problem
		Configuration start = new Configuration(problem.nbBallons);
		for (int i = 0 ; i < problem.nbBallons ; ++i) {
			start.setPosition(i, new Position3D(problem.depart, 0));
		}
		solution.initiale = start;
		
		solution.configurations = new Configuration[problem.nbTours];
		
		Configuration last = solution.initiale;
		
		for (int tour = 0 ; tour < problem.nbTours ; ++tour) {
			Configuration config = new Configuration(problem.nbBallons);
			
			for (int i = 0 ; i < problem.nbBallons ; ++i) {
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

}
