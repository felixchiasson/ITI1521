package itiiiii15211;

public class Q2Test {
	  
public static void main(String[] args) {
  
   
  LinkedList<Integer> l1= new LinkedList<Integer>(); // Crée une liste l1 sur laquelle on fera les test
 l1.addLast(4);
 l1.addLast(5);
 l1.addLast(6);
 LinkedList<Integer> l2= new LinkedList<Integer>(); // crée la liste a inserer en premier
 l2.addLast(-2);
 l2.addLast(-7);
 l2.addLast(-8);
 LinkedList<Integer> l3= new LinkedList<Integer>(); // crée une autre liste a inserer
 l3.addLast(10);
 l3.addLast(12);
 l3.addLast(13);
 LinkedList<Integer> l4 = new LinkedList<Integer>(); // crée une autre liste a inserer
 l4.addLast(-10);
 l4.addLast(-40);
 l4.addLast(-50);
 
 
 l1.affich();
 System.out.println("++++++++++++++++++++");
 l1.insertAfter(4,l2); // ajouté la liste l2 aprés l'element 4 
 l1.affich();
 System.out.println("++++++++++++++++++++");
 l1.insertAfter(5,l3); // ajouté la liste l3 aprés l'element 5
 l1.affich();
 System.out.println("++++++++++++++++++++");
 l1.insertAfter(6, l4); // ajouté lal liste l4 aprés le dernier element 
 l1.affich();
 l1.insertAfter(0, l1); // inserer une liste aprés un element inexsitant ( lance une exception)
}}