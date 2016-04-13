public class Test {

    public static void main(String[] args) {

        StudentInfo.display();

        LinkedList<Integer> listeA = new LinkedList<Integer>();
        listeA.addLast(1);
        listeA.addLast(2);
        listeA.addLast(3);
        LinkedList<Integer> listeOther= new LinkedList<Integer>();
        listeOther.addLast(10);
        listeOther.addLast(20);
        listeOther.addLast(30);
        LinkedList<Integer> listeOtherB = new LinkedList<Integer>();
        listeOtherB.addLast(-1);
        listeOtherB.addLast(-2);
        listeOtherB.addLast(-3);
        LinkedList<Integer> emptyList = new LinkedList<Integer>();

        listeA.printList();
        System.out.println("\n------------------------");
        // Test adding listeOther to listeA, should print "1 2 10 20 30 3"
        listeA.insertAfter(2,listeOther);
        listeA.printList();
        System.out.println("\n------------------------");
        // Add another list to listeA, should print "1 -1 -2 -3 2 10 20 30 3"
        listeA.insertAfter(1,listeOtherB);
        listeA.printList();
        System.out.println("\n------------------------");

        // Test for exceptions
        try {
            listeA.insertAfter(999, listeOther);
        } catch (IllegalArgumentException e) {
            System.err.println("An IllegalArgumentException has been thrown.");
        }

        try {
            listeA.insertAfter(null, listeOther);
        } catch (NullPointerException e) {
            System.err.println("A NullPointerException has been thrown");
        }

        try {
            emptyList.insertAfter(1, listeOther);
        } catch (IllegalArgumentException e) {
            System.err.println("An IllegalArgumentException has been thrown.");
        }
    }
}
