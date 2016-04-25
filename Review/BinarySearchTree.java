/*************************************************************************************************
*     File Name           :     BinarySearchTree.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-04-24 23:01]
*     Last Modified       :     [2016-04-25 00:27]
*     Description         :     Review of binary search tree with comments
**************************************************************************************************/

public class BinarySearchTree<E extends Comparable<E>> {

    // the node sub-class is always private and static
    private static class Node<T> {

        private T value;

        private Node<T> leftChild;
        private Node<T> rightChild;

        private Node(T value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }

        private String toString() {
            return "Value is " +  value + " ";
        }

   }
        private Node<E> root;

    /**
     * Add a node to the tree
     **/

    public void addNode(E element) {
        Node<E> newNode;
        newNode = new Node<E>(element);

        if (root == null) {
            root = newNode;
        } else {
            Node<E> focusNode = root;
            Node<E> parent;

            // Create an infinite loop that we will have to get out of

            while(true) {

                // parent is the root at the start of this loop
                parent = focusNode;

                // If our key is less than the focused node's, we change our
                // focus to the left child.
                int test = element.compareTo(focusNode.value);

                if (test < 0) {
                    focusNode = focusNode.leftChild;

                    // If there is no left children to this node, we add
                    // newNode to the left of our currently focused node.

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        // The function has done its job, we return out of it.
                        return;
                    }

                } else {

                    // However, if the key is greater than the focused node's,
                    // we change our focus to the right child.
                    focusNode = focusNode.rightChild;

                    // We check if this right child exists. If it does, we loop
                    // back and continue to the next rightChild. If it doesn't
                    // (focusNode == null), we add the newNode there.

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * In Order Traversal (Pre-Order selon les notes de cours)
     * We aim for the smallest value first (start at first left child)
     * When Null is reached, then move up a value.
     **/

    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            System.out.print(focusNode);
            inOrderTraverseTree(focusNode.leftChild);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree t = new BinarySearchTree();

        t.addNode(25);
        t.addNode(3);
        t.addNode(37);
        t.addNode(1);
        t.addNode(19);
        t.addNode(48);

        t.inOrderTraverseTree(t.root);

    }

}


