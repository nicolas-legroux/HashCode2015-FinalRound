import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {

	Problem problem;
	// TODO définir variables décrivant la solution

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
		bw.write("Write the solution");
		
		bw.close();
		System.out.println("Done writing the solution");
	}
}
