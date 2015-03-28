
public class Position2D {
	
	int x;
	int y;

	public Position2D(int x, int y) {
		this.x = x;
		this.y = y;
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
