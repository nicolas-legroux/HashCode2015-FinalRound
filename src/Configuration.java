
public class Configuration {
	
	Position3D[] posBallons;
	
	public Configuration(int nbBallons) {
		posBallons = new Position3D[nbBallons];
	}
	
	public void setPosition(int idBallon, Position3D position) {
		posBallons[idBallon] = position;
	}

}
