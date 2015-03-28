import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		try {
			Problem pb = new Problem("data/final_round.in");
			
			pb.print();

			//BadSolver solver = new BadSolver(pb);
			Solver solver = new Solver(pb);
			
			Solution solution = solver.solve();
			//solution.print();
			solution.save("data/output.txt");
			
		} catch (IOException e) {
			System.err.println("Error while doing IO stuff : " + e.getMessage());
		}
		
	}

}