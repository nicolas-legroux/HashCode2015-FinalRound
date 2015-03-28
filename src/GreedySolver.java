
public class GreedySolver {
	
	//Principe de l'algorithme :
	/*
	 * On se balade sur le graphe
	 * On simule tour par tour les mouvements de chaque ballon (au plus 3 choix possibles / ballon)
	 * A la fin de chaque tour : on réinitialise les scores de chaque sommet du graphe
	 * Score = nombre de cellules cibles couvertes par un sommet du graphe
	 * Première idée : on prend le premier ballon, on trouve son voisin qui apporte un score max, on y va
	 * On update les scores 
	 * On refait pour le 2e ballon
	 * etc.	 * 
	 */
	
	//Remarque : pour chaque cellule cible, il faudrait connaitre les noeuds du graphe qui permettent de couvrir la cellule

}
