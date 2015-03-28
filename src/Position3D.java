public class Position3D {
	
	Position2D pos;
	int z;
	
	public Position3D(Position2D pos, int z) {
		this.pos = pos;
		this.z = z;
	}
	
	public Position3D(int x, int y, int z) {
		pos = new Position2D(x, y);
		this.z = z;
	}
	
	public boolean isSame(int x, int y) {
		return pos.x == x && pos.y == y;
	}
	
	public Position3D move(int newz, Vent vent, int nbLignes, int nbColonnes) {
		Position2D _pos = pos.move(vent, nbLignes, nbColonnes);
		if (_pos != null)
			return new Position3D(_pos, newz);
		else
			return null;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position3D)) return false;
        Position3D other = (Position3D) o;
        return pos.equals(other.pos) && z == other.z;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = z * 75 * 300 + pos.hashCode();
        return result;
    }

    public String toString() {
    	return "("+pos.x+","+pos.y+","+z+")";
    }
}