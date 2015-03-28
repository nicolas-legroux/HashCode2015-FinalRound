import java.util.List;

public class DivisionSolver {

	Problem problem;
	Solution solution;
	
	DivisionSolver(Problem problem) {
		this.problem = problem;
		solution = new Solution(problem);
	}
	
	//Fonction qui pour un ballon décide où il va aller au prochain tour
	Node nextStep(Node currentNode){
		
		Node nextNode = null;
		List<Node> neighbors = currentNode.getNeighbors();
		//TODO update score
		
		return nextNode;		
	}
	
	void simulateRound(){

	}
	
	public Solution solve() {
		//Boucle sur les tours
		for(int i=0; i<problem.nbTours; i++){
			simulateRound();
		}	
		
		
		return solution;
	}
}
