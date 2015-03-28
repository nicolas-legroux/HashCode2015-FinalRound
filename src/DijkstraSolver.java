import java.util.HashSet;
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
		
		// TODO : solve problem
		Configuration start = new Configuration(problem.nbBallons);
		for (int i = 0 ; i < problem.nbBallons ; ++i) {
			start.setPosition(i, new Position3D(problem.depart, 0));
		}
		solution.initiale = start;
		
		solution.configurations = new Configuration[problem.nbTours];
		Configuration last = solution.initiale;
		
		Path[] targets = new Path[problem.nbBallons];
		Dijkstra dijkstra = new Dijkstra();

		HashSet<Position3D> cibles = (HashSet<Position3D>)problem.setCibles.clone();
		/*
		for (int i = 0 ; i < problem.nbBallons ; ++i) {
			if (cibles.isEmpty())
				cibles = (HashSet<Position3D>)problem.setCibles.clone();

			Path path = dijkstra.findFirst(graph.startingpoint, cibles);
			if (path != null)
				path.print();
			cibles.remove(path.getLast());
		}
		//*/
		
		for (int tour = 0 ; tour < problem.nbTours ; ++tour) {
			Configuration config = new Configuration(problem.nbBallons);
			
			System.out.println("Tour = " + tour);
			
			for (int i = 0 ; i < problem.nbBallons ; ++i) {
				Position3D lastPos = last.posBallons[i];
				Path myPath = targets[i];
				
				if (myPath != null && myPath.isEmpty()) {
					cibles.add(lastPos);
					myPath = null;
				}
				
				if (myPath == null) {
					Path path = dijkstra.findFirst(graph.getNode(lastPos), cibles);
					cibles.remove(path.getLast());
					path.pollFirst();
					myPath = path;
				}
				
				Position3D next = myPath.pollFirst();
				config.setPosition(i, next);
				/*
				Node node = graph.getNode(lastPos);
				List<Node> x = node.getNeighbors();
				if (x.size() > 0) {
					int next = generator.nextInt(x.size());
					config.setPosition(i, x.get(next).position);
				} else
					config.setPosition(i, lastPos);
				//*/
			}
			
			solution.configurations[tour] = config;
			last = config;
		}
		
		return solution;
	}

}
