import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {

	Problem problem;
	// TODO définir variables décrivant la solution
	Configuration[] configurations;

	Solution(Problem problem) {
		this.problem = problem;
		// TODO : Initialiser variables
	}
	
	public void print() {
		//TODO : print other useful info about solution (number of elements, etc...)
		System.out.println("Print solution : not implemented");
	}

	void save(String filename) throws IOException {
		File file = new File(filename);
		if (!file.exists())
			file.createNewFile();

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		// TODO : write solution
		for (int tour = 0 ; tour < problem.nbTours ; ++tour) {
			for (int j = 0 ; j < problem.nbBallons ; ++j) {
				if (j > 0)
					bw.write(" ");
				bw.write(String.valueOf(configurations[tour].posBallons[j]));
			}
			bw.write("\n");
		}
		
		bw.close();
		System.out.println("Done writing the solution");
	}
}
