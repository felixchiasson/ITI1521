

public class Q3Test {
   
   
public static void main(String[] args) {
 
LinkedList<Integer> l1 = new LinkedList<Integer>();
l1.addFirst(5);
l1.addFirst(6);
l1.addFirst(7);
l1.addFirst(5);
l1.addFirst(5);
l1.addFirst(5);
// Donc la liste sera de la forme ( 5,5,5,7,6,5) odnc la liste resultant devrait etre (0,1,2,5)
LinkedList<Integer> result=ListUtil.indexOfAll(5,l1);
result.affich();
System.out.println("+++++++++++++++");
LinkedList<String> l2 = new LinkedList<String>();
l2.addFirst("a");
l2.addFirst("b");
l2.addFirst("7");
l2.addFirst("a");
l2.addFirst("b");
l2.addFirst("l"); // liste de la forme ("l","b","a","7","b","a") donc en appalnt la fonction avec a on aura (2,5)
result = ListUtil.indexOfAll("a", l2);
result.affich();
System.out.println("+++++++++++");
//appelle de la fonction avec un element qui n'existe pas dans la liste on aura une liste vide!
result= ListUtil.indexOfAll("", l2);
result.affich();
//appelle de la fonctiona avec element=null, on aura une exception de type nullPointerException;
result=ListUtil.indexOfAll(null, l2);

 
 }}