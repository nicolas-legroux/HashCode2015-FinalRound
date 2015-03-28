
public class Solver {
	
	Problem problem;
	
	public Solver(Problem problem) {
		this.problem = problem;
	}
	
	public Solution solve() {
		Solution solution = new Solution(problem);
		
		// TODO : solve problem
		System.out.println("Not implemented");
		
		GraphBuilder builder = GraphBuilder(problem);
		builder.build();
		Graph graph = new Graph(builder.nodes, problem.depart);
		
		return solution;
	}

}
