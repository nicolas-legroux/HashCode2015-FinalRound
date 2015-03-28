public class Position3D {
	
	Position2D pos;
	int z;
	
	public Position3D(int x, int y, int z) {
		pos = new Position2D(x, y);
		this.z = z;
	}
	
	public boolean isSame(int x, int y) {
		return pos.x == x && pos.y == y;
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
        result = 61 * result + pos.hashCode();
        result = 61 * result + z;
        return result;
    }

}