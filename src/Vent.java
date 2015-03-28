
public class Vent {

	int ventx;
	int venty;
	
	public Vent(int x, int y) {
		ventx = x;
		venty = y;
	}

	static char[] directions = {'<', '>', '^', '_', '/', '\\', '.'};
	
	public void print() {
		System.out.print(this.symbol());
	}
	
	public char symbol() {
		int x = ventx < 0 ? -ventx : ventx;
		int y = venty < 0 ? -venty : venty;
		
		if (x > y) {
			if (ventx < 0)
				return directions[0];
			else
				return directions[1];
		} else if (y > x) {
			if (venty < 0)
				return directions[2];
			else
				return directions[3];
		} else {
			if (x == 0)
				return directions[6];
			else if (x == -y)
				return directions[4];
			else if (x == y)
				return directions[5];
		}
		
		return '#';
	}
	
}
