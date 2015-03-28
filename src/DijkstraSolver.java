import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class DijkstraSolver {
	
	Problem problem;
	Random generator;
	
	public DijkstraSolver(Problem problem) {
		this.problem = problem;
		generator = new Random(123456789);
	}
	
	public void remove(HashSet<Position3D> cibles, Position3D where) {
		LinkedList<Position3D> toremove = new LinkedList<Position3D>();
		for (Position3D pos : cibles) {
			int dx = pos.pos.x - where.pos.x;
			int dy = pos.pos.y - where.pos.y;
			if (dx * dx + dy * dy <= 25)
				toremove.add(pos);
		}
		
		for (Position3D pos : toremove)
			cibles.remove(pos);
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
		
		for (int tour = 0 ; tour < problem.nbTours ; ++tour) {
			Configuration config = new Configuration(problem.nbBallons);

			HashSet<Position3D> cibles = (HashSet<Position3D>)problem.setCibles.clone();
			for (int i = 0 ; i < problem.nbBallons ; ++i) {
				if (targets[i] != null && !targets[i].isEmpty()) {
					remove(cibles, targets[i].getLast());
				}
			}
			
			System.out.println("Tour = " + tour + " ; cibles = " + cibles.size());
			
			for (int i = 0 ; i < problem.nbBallons ; ++i) {
				Position3D lastPos = last.posBallons[i];
				
				if (i > 2 * tour) {
					config.setPosition(i, lastPos);
					continue;
				}
			
				Path myPath = targets[i];
				
				if (myPath != null && myPath.isEmpty()) {
					/*
					cibles.add(lastPos);
					System.out.println("Add :");
					graph.getNode(lastPos).print();
					//*/
					myPath = null;
				}
				
				if (myPath == null) {
					if (cibles.isEmpty())
						cibles = (HashSet<Position3D>)problem.setCibles.clone();
					
					Path path = dijkstra.findFirst(graph.getNode(lastPos), cibles);
					remove(cibles, path.getLast());
					/*
					cibles.remove(path.getLast());
					System.out.println("Remove :");
					graph.getNode(path.getLast()).print();
					//*/
					path.pollFirst();
					targets[i] = path;
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
