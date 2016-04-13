public class Test {


    public static void main(String[] args) {
        StudentInfo.display();
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
        System.out.print("Should be '0 2 3', result is: ");
        result = ListUtil.indexOfAll(listeOther, "t");
        result.printList();
        System.out.println("\n-------------------");
        System.out.println("Appel de la fonction avec une liste vide (should be empty): ");
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
