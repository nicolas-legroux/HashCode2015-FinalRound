import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello World");
		
		Problem pb = new Problem("data/input");
		pb.print();
		
		Solver solver = new Solver(pb);
		
		Solution solution = solver.solve();
		solution.print();
		solution.save("data/output.txt");		
	}

}