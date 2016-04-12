public class Q3Test {


    public static void main(String[] args) {

        LinkedList<Integer> listeA = new LinkedList<Integer>();
        listeA.addFirst(1);
        listeA.addFirst(2);
        listeA.addFirst(2);
        listeA.addFirst(2);
        listeA.addFirst(1);
        System.out.print("Should be '1 2 3', result is : ");
        LinkedList<Integer> result = ListUtil.indexOfAll(listeA, 2);
        result.printList();
        System.out.println("\n-------------------");
        LinkedList<String> listeOther = new LinkedList<String>();
        listeOther.addFirst("t");
        listeOther.addFirst("t");
        listeOther.addFirst("e");
        listeOther.addFirst("t");
        result = ListUtil.indexOfAll(listeOther, "t");
        result.printList();
        System.out.println("\n-------------------");
        //appelle de la fonction avec un element qui n'existe pas dans la liste on aura une liste vide!
        result = ListUtil.indexOfAll(listeOther, "");
        result.printList();

        // Throw a NullPointerException on purpose
        try {
            result = ListUtil.indexOfAll(listeOther, null);
        } catch (NullPointerException e) {
            System.err.println("Exception Test 01: NullPointerException succesfully thrown.");
        }


    }
}
