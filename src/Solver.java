
public class Solver {
	
	Problem problem;
	
	public Solver(Problem problem) {
		this.problem = problem;
	}
	
	public Solution solve() {
		Solution solution = new Solution(problem);
		
		// TODO : solve problem
		System.out.println("Not implemented");
		
		GraphBuilder builder = new GraphBuilder(problem);
		Graph graph = builder.build();
		System.out.println("graph building done");
		graph.print();
		
		return solution;
	}

}
