import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		try {
			Problem pb = new Problem("data/final_round.in");

			//GraphBuilder gb = new GraphBuilder(pb);
			//Graph g = gb.build();			
			
			/*
			pb.printCibles();

			
			/*
			Position3D start = new Position3D(30, 30, 2);
			
			FindCycle findCycle = new FindCycle(start, g);
			findCycle.findCycles(12);
			//*/

			
			//Solver solver = new Solver(pb);
			//pb.print();

			//DijkstraSolver solver = new DijkstraSolver(pb);
			//BadSolver solver = new BadSolver(pb);
			//Solver solver = new Solver(pb);
			DivisionSolver solver = new DivisionSolver(pb);

			
			Solution solution = solver.solve();
			//solution.print();
			solution.save("data/output.txt");
			
		} catch (IOException e) {
			System.err.println("Error while doing IO stuff : " + e.getMessage());
		}
		
	}

}