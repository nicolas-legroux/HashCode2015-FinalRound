public class Test {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		Problem pb = new Problem("data/input");
		pb.print();
		
		Solution solution = new Solution();
		solution.save("output.txt");
		
	}

}