
public class Position2D {
	
	int x;
	int y;

	public Position2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position2D move(Vent vent, int nbLignes, int nbColonnes) {
		int xx = x + vent.ventx;
		int yy = y + vent.venty;
		
		while (xx < 0)
			xx += nbColonnes;
		xx %= nbColonnes;
		
		if (yy >= 0 && yy < nbLignes)
			return new Position2D(xx, yy);
		else
			return null; // Out of map
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position2D)) return false;
        Position2D other = (Position2D) o;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 75 * result + y;
        return result;
    }

}
