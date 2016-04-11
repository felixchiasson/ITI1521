public class Q5Test {
  
  
public static void main(String[] args) {
 
 BinarySearchTree tr= new BinarySearchTree();
 tr.add(1);
 tr.add(2);
 tr.add(3);
 tr.add(4);
 tr.add(5);
 tr.add(6);
 tr.add(7);
 tr.add(8);
 System.out.println("Le resultat suite a l'appelle avec (1,5) "+ tr.count(1,5)); // va rechercher le nombre de valeur entre 1 et 5 (inclusivement ) (5 valeurs)
 System.out.println("Le resultat suite a l'appelle avec (4,7) "+ tr.count(4,7));// va rechercher le nombre de valeur entre 4 et 7 (inclusivement ) (4 valeurs)
 System.out.println("Le resultat suite a l'appelle avec (10,15) "+ tr.count(10,15));// va rechercher le nombre de valeur entre 10 et 15 (inclusivement ) (0 valeurs) car le max est 8 ici
 System.out.println("Le resultat suite a l'appelle avec (5,5) "+ tr.count(5,5)); // ici vu que le max=min donc il va simplement rechercher combien de chiffre sont egaux a 5! ( equivalent a la methode Contains.
 System.out.println("Le resultat suite a l'appelle avec (5,15) "+ tr.count(5,15));// va rechercher le nombre de valeur entre 5 et 15 (inclusivement ) (4 valeurs)
 System.out.println("Le resultat suite a l'appelle avec (6,5) "+ tr.count(6,5)); //  va rechercher le nombre de valeur entre 6 et 5 (inclusivement ) ( va generer une exception de type illegalArgumentException car ici min > max 
 
 
 }}