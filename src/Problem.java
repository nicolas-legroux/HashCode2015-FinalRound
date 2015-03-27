import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Problem {
	
	//TODO ici : définir les variables globales du probleme
	
	Problem(String filename){
		
		//TODO ici : initialiser les variables globales		
		
		load(filename);
	}
	
	private void load(String filename){
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String firstLine = null;
		try {
			firstLine = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[] globalConstants = firstLine.split(" ");
		
		//TODO : process globalConstants
		// constant = Integer.parseInt(globalConstants[i]);
		
		//TODO : redéfinir éventuellement les variables globales en fonction des données
		
		//TODO : read each line, change NUMBER_OF_LINES
		int NUMBER_OF_LINES = 0;
		
		for (int i=0; i < NUMBER_OF_LINES; i++){
			String line = null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//TODO : process the line			
		}	
	}
	
	public void print(){
		//TODO : make sure that the input data has been read correctly
		System.out.println("Not implemented");
	}

}
