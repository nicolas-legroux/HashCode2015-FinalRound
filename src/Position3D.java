public class Position3D {

    private final int x;
    private final int y;
    private final int z;

    public Position3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position3D)) return false;
        Position3D key = (Position3D) o;
        return x == key.x && y == key.y && key.z == z;
    }

    @Override
    public int hashCode() {
    	
    	//TODO correct
        int result = x;
        result = 75 * result + y;
        result = 300 * result + z;
        return result;
    }

}