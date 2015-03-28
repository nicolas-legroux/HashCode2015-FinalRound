import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem {
	
	//TODO ici : définir les variables globales du probleme
	int nbLignes;
	int nbColonnes;
	int nbAltitudes;
	
	int nbCibles;
	boolean[][] cibles; // (colonne, ligne)
	Vent[][][] vents; // (colonne, ligne, altitude)
	
	Problem(String filename) throws IOException{
		
		//TODO ici : initialiser les variables globales		
		
		load(filename);
	}
	
	private void load(String filename) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		String firstLine = br.readLine();
		String[] globalConstants = firstLine.split(" ");
		
		//TODO : process globalConstants
		// constant = Integer.parseInt(globalConstants[i]);
		
		//TODO : redéfinir éventuellement les variables globales en fonction des données
		
		//TODO : read each line, change NUMBER_OF_LINES
		int NUMBER_OF_LINES = 0;
		
		for (int i=0; i < NUMBER_OF_LINES; i++){
			String line = br.readLine();
			
			//TODO : process the line
			//String[] temp = line.split(" ");
			//value = Integer.parseInt(temp[k]);
		}
		
		br.close();
	}
	
	public void print() {
		//TODO : make sure that the input data has been read correctly
		System.out.println("Print problem : not implemented");
	}

}
