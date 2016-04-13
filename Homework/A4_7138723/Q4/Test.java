public class Test {

    public static void main(String[] args) {
        StudentInfo.display();
        SinglyLinkedList<Integer> listeA = new SinglyLinkedList<Integer>();
        listeA.addFirst(5);
        listeA.addFirst(4);
        listeA.addFirst(3);
        listeA.addFirst(2);
        listeA.addFirst(1);

        // The list should now be {1, 2, 3, 4, 5}
        System.out.println("Starting tests with list: " + listeA);
        System.out.println("Test 00: Find two elements" + listeA.take(2));
        System.out.println("Test 01: Find n > size of list (should print all the elements of the list) " + listeA.take(7));
        System.out.println("Test 02: n = 0, should print an empty list: " + listeA.take(0));
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Testing exceptions:");
        System.out.println("Test 03: n < 0. Should throw IllegalArgumentException.");

        try {
            listeA.take(-1);
            System.out.println("Exception not thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught.");
        }

    }
}
