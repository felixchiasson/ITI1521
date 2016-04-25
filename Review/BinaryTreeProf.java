/*************************************************************************************************
*     File Name           :     BinaryTreeProf.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-04-25 00:27]
*     Last Modified       :     [2016-04-25 00:50]
*     Description         :     This is the prof's version of the tree
**************************************************************************************************/
public class BinaryTreeProf<E extends Comparable<E>> {

    // Static nested class used to store elements of the tree (nodes)

    private static class Node<E> {
        private E value;
        private Node<E> leftChild;
        private Node<E> rightChild;
        // We start a new node making sure it has no leftChild or rightChild
        // and also set its value from the constructor.
        private Node( E value ) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }
    }

    // We initialize a root node and make it null for now. We will add a value
    // to it later.
    private Node<E> root = null;

    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param obj item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add( E obj ) {

        // We must go through pre-conditions first :
        // Is obj null? What's the point of adding a null value to the tree?
        //
        // Then we check special cases:
        // Is root empty? As in: is this tree empty? If so, we add the value as
        // root.
        //
        // General Case (this is recursive)
        // We add the value using a private function.

        if ( obj == null) {
            throw new IllegalArgumentException( "null" );
        }

        if (root == null) {
            root = new Node<E>( obj );
            return true; // we added the element, we can now return True
        }

        return add( obj, root );
    }

    // This is our private function used for recursivity.
    // Our first argument is the obj from the public add.
    // Our second argument is the focused Node (the one we're looking at)

    private boolean add( E obj, Node<E> current ) {

        boolean result; // what we will return

        // Comparison tests.
        // A value of 0 means they are equal.
        // A value < 0 means obj is smaller than the focused node's value.
        // A value of > 0 means obj is greater than the focused node's value.

        int test = obj.compareTo( current.value );

        if ( test == 0 ) {
            result = false;
        } else if ( test < 0 ) {
            // First we check if there is a node to the left of our focused
            // node. If there isn't, we add the new node.
            if ( current.leftChild == null ) {
                current.leftChild = new Node<E>( obj );
                result = true;
            } else {
                // If there is indeed a node at the left of our currently
                // focused node, we run add() again, but with the left node
                // instead. (We change focus to the left child.)
                result = add(obj, current.leftChild);
            }

        } else {
            if ( current.rightChild == null) {
                current.rightChild = new Node<E>( obj );
                result = true;
            } else {
                result = add(obj, current.rightChild);
            }
        }

        return result;
    }
}
