/*************************************************************************************************
*     File Name           :     BinaryTreeProf.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-04-25 00:27]
*     Last Modified       :     [2016-04-25 01:13]
*     Description         :     This is the prof's version of the tree
**************************************************************************************************/
import java.util.NoSuchElementException;

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

    /**
     * Looks up obj in this BST, returns true if obj is found and false
     * otherwise.
     *
     * @param obj value to look for
     * @return true if the object has been found and false otherwise
     */

    public boolean contains( E obj ) {
        // This is recursive, again.
        // For a recursive function we need:
        // 1. Pre-condition
        // 2. Special cases
        // 3. General case (where the private function comes in handy)

        // 1.

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        // 3.

        return contains( obj, root );
    }

    private boolean contains( E obj, Node<E> current ) {
        boolean result;

        if (current == null) {
            result = false;
        } else {
            int test = obj.compareTo(current.value);
            if (test == 0) {
                result = true;
            } else if (test < 0) {
                result = contains(obj, current.leftChild);
            } else {
                result = contains(obj, current.rightChild);
            }
        }
        return result;
    }

    /**
     * Find the maximum value
     */

    public E max() {
        // Again, recursive. See other comments.

        // 1.

        if (root == null) {
            throw new NoSuchElementException();
        }

        // 3.

        return max(root);
    }

    private E max(Node<E> current) {

        // In a binary search tree, the nodes on the right of the focused nodes
        // are always greater than the focused nodes. This means that if we
        // keep going right we'll hit the maximum value eventually.

        if (current.rightChild == null) {
            return current.value;
        } else {
            return max(current.rightChild);
        }
    }

    public E min() {
        // 1.
        if (root == null) {
            throw new NoSuchElementException();
        }

        // 3.

        return min(root);
    }

    /**
     * Find the minimum value in the BST.
     */

    private E min(Node<E> current) {
        // Same as max(), but to the left since all the small values are on the
        // left most side of the BST.
        if (current.leftChild == null) {
            return current.value;
        } else {
            return max(current.leftChild);
        }
    }

// All the methods above are methods that I deemed "important" for the final
// exam. I have yet to take a look at remove(), which I assume is similar to
// contains, but with a slight twist.


}
