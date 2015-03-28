import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

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
	
	HashSet<Position3D> setCibles;
	
	Problem(String filename) throws IOException{
		setCibles = new HashSet<Position3D>();
		
		load(filename);
	}
	
	private void load(String filename) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		String firstLine = br.readLine();
		String[] globalConstants = firstLine.split(" ");
		nbLignes=Integer.parseInt(globalConstants[0]);
		nbColonnes=Integer.parseInt(globalConstants[1]);
		nbAltitudes=Integer.parseInt(globalConstants[2]) + 1;

		cibles = new boolean[nbColonnes][nbLignes];
		for (int x = 0 ; x < nbColonnes ; ++x) {
			for (int y = 0 ; y < nbLignes ; ++y) {
				cibles[x][y] = false;
			}
		}
		
		vents = new Vent[nbColonnes][nbLignes][nbAltitudes];
		
		String secondLine = br.readLine();
		globalConstants = secondLine.split(" ");
		nbCibles=Integer.parseInt(globalConstants[0]);
		rayon=Integer.parseInt(globalConstants[1]);
		nbBallons=Integer.parseInt(globalConstants[2]);
		nbTours=Integer.parseInt(globalConstants[3]);
		
		String thirdLine = br.readLine();
		String[] pos = thirdLine.split(" ");
		int ydepart = Integer.parseInt(pos[0]);
		int xdepart = Integer.parseInt(pos[1]);
		depart = new Position2D(xdepart, ydepart);
		
		for (int i = 0; i < nbCibles; i++){
			String line = br.readLine();
			String[] parsedline= line.split(" ");
			int y = Integer.parseInt(parsedline[0]);
			int x = Integer.parseInt(parsedline[1]);
			cibles[x][y] = true;
			
			for (int a = 1 ; a < nbAltitudes ; ++a) {
				setCibles.add(new Position3D(x, y, a));
			}
		}
		
		for (int a = 1; a < nbAltitudes; ++a){
			for (int y = 0; y < nbLignes; ++y){
				String line = br.readLine();
				String[] parsedline = line.split(" ");
				for (int x = 0 ; x < nbColonnes ; ++x) {
					int venty = Integer.parseInt(parsedline[2*x]);
					int ventx = Integer.parseInt(parsedline[2*x + 1]);
					vents[x][y][a] = new Vent(ventx, venty);
				}
			}
		}
		
		br.close();
	}
	
	public void print() {
		//TODO : make sure that the input data has been read correctly
				
		for (int y = 0 ; y < nbLignes ; ++y) {
			for (int x = 0 ; x < nbColonnes ; ++x) {
				System.out.print(cibles[x][y] ? "C" : ".");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int a = 1; a < nbAltitudes; ++a) {
			for (int y = 0 ; y < nbLignes ; ++y) {
				for (int x = 0 ; x < nbColonnes ; ++x) {
					System.out.print(vents[x][y][a].symbol());
				}
				System.out.println();

				for (int x = 0 ; x < nbColonnes ; ++x) {
					System.out.print(cibles[x][y] ? "*" : ".");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
	}
	
	public void printCibles(){
		for (int y = 0 ; y < nbLignes ; ++y) {
			for (int x = 0 ; x < nbColonnes ; ++x) {
				System.out.print(cibles[x][y] ? "C" : ".");
			}
			System.out.println();
		}			
	}

}
