import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem {
	
	//TODO ici : définir les variables globales du probleme
	int nbLignes;
	int nbColonnes;
	int nbAltitudes;
	
	int nbCibles;
	int rayon;
	int nbBallons;
	int nbTours;
	
	Position2D depart;
	
	boolean[][] cibles; // (colonne, ligne)
	Vent[][][] vents; // (colonne, ligne, altitude)
	
	Problem(String filename) throws IOException{
		load(filename);
	}
	
	private void load(String filename) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		String firstLine = br.readLine();
		String[] globalConstants = firstLine.split(" ");
		nbLignes=Integer.parseInt(globalConstants[0]);
		nbColonnes=Integer.parseInt(globalConstants[1]);
		nbAltitudes=Integer.parseInt(globalConstants[2]);

		cibles = new boolean[nbColonnes][nbLignes];
		vents = new Vent[nbColonnes][nbLignes][nbAltitudes];
		
		String secondLine = br.readLine();
		globalConstants = secondLine.split(" ");
		nbCibles=Integer.parseInt(globalConstants[0]);
		rayon=Integer.parseInt(globalConstants[1]);
		nbBallons=Integer.parseInt(globalConstants[2]);
		nbTours=Integer.parseInt(globalConstants[3]);
		
		String thirdLine = br.readLine();
		String[] pos = thirdLine.split(" ");
		depart=new Position2D(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
		
		
		//TODO : read each line, change NUMBER_OF_LINES
		//int NUMBER_OF_Targets = 0;
		// Initialisation of the cibles array
		cibles=new boolean[nbLignes][nbColonnes];
		for (int i=0; i < nbLignes; i++){
			for (int j=0; j < nbColonnes; j++){
				cibles[i][j]=false;
			}
		}
		
		for (int i=0; i < nbCibles; i++){
			String line = br.readLine();
			String[] parsedline= line.split(" ");
			int y = Integer.parseInt(parsedline[0]);
			int x = Integer.parseInt(parsedline[1]);
			cibles[x][y]=true;
		}
		
		// Initialisation of the  array "vents"
		vents=new Vent[nbLignes][nbColonnes][nbAltitudes];
		
		for (int i=0; i < nbAltitudes; i++){
			for (int j=0; j < nbLignes; j++){
				String line = br.readLine();
				String[] parsedline= line.split(" ");
				for (int t = 0 ; t < parsedline.length ; t += 2) {
					vents[j][t/2][i]=new Vent(Integer.parseInt(parsedline[t]),Integer.parseInt(parsedline[t+1]));
				}
			}
			
			
			
			
		}
		br.close();
	}
	
	public void print() {
		//TODO : make sure that the input data has been read correctly
		System.out.println("Print problem : not implemented");
		
		for (int y = 0 ; y < nbLignes ; ++y) {
			for (int x = 0 ; x < nbColonnes ; ++x) {
				System.out.print(cibles[x][y] ? "*" : ".");
			}
			System.out.print("\n");
		}
	}

}
