/*************************************************************************************************
*     File Name           :     LinkedList.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-04-25 01:26]
*     Last Modified       :     [2016-04-25 01:57]
*     Description         :     This is based on lab 10 QIII
**************************************************************************************************/
public class LinkedList<E> {

    //  -----------------------------------------------------------
    //  Implementing doubly linked nodes (in a nested static class)
    //  -----------------------------------------------------------
    private static class Node<E> {
        private E value;

        // Because this is doubly linked, we have prev and next.

        private Node<E> previous;
        private Node<E> next;

        // Our constructor

        private Node(E value, Node<E> previous, Node<E> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // Instance variables
    // Head is out first element, called noeud factice in French. It is not
    // part of the list.
    private Node<E> head;
    private int size;

    /**
     * Create a new linked list.
     */

    public LinkedList() {
        // We create a dummy node (head)

        head = new Node<E>(null, null, null);

        // We link it to itself
        head.next = head.previous = head;

        // and initialize its size to 0 (because again, the dummy node is not
        // part of the list.

        size = 0;
    }

    //  -----------------------------------------------------------
    //  Linked List Methods
    //  -----------------------------------------------------------

    /**
     * Returns the number of elements currently stored in the list.
     */

    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @return true since duplicated values are allowed
     * @throws IllegalArgumentException is obj is null.
     */

    public boolean addLast(E obj) {

        // Exception case - no point in adding a null value, eh?

        if (obj == null) {
            throw new IllegalArgumentException("null");
        }

        // We set "before" to the last node of the LinkedList
        // We set "after" to the dummy node (because it's the one that comes
        // right after the last element of the list)

        Node<E> before = head.previous;
        Node<E> after = head;

        // We link the new node properly
        // before -n- (before.next) newNode (after.previous) -n- Head --- Other

        before.next = new Node<E>(obj, before, after);
        after.previous = before.next;

        // Don't forget to increment the size!

        size++;

        return true;
    }

    /**
     * Adds an element at the front of the list.
     *
     * @return true since duplicated values are allowed
     * @throws IllegalArgumentException if obj is null
     */

    public boolean addFirst(E obj) {

        if (obj == null) {
            throw new IllegalArgumentException("null");
        }

        // We set the node before the new node to the head, and the one after
        // to head.next (the old "first" element of the LinkedList)

        Node<E> before = head;
        Node<E> after = head.next;

        // We link the nodes properly
        // Other --- Head -n- (before.next) newNode (after.previous) -n- after

        before.next = new Node<E>(obj, before, after);
        after.previous = before.next;

        return true;
    }
// I'm not done
}
