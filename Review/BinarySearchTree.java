/*************************************************************************************************
*     File Name           :     BinarySearchTree.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-04-24 23:01]
*     Last Modified       :     [2016-04-24 23:41]
*     Description         :     Review of binary search tree with comments
**************************************************************************************************/

public class BinarySearchTree {

    Node root;

    /**
     * Add a node to the tree
     **/

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            // Create an infinite loop that we will have to get out of

            while(true) {

                // parent is the root at the start of this loop
                parent = focusNode;

                // If our key is less than the focused node's, we change our
                // focus to the left child.

                if (key < focusNode.key) {
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
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree t = new BinarySearchTree();

        t.addNode(25, "Boss");
        t.addNode(3, "Vice President");
        t.addNode(37, "Office Manager");
        t.addNode(1, "Secretary");
        t.addNode(19, "Sales Manager");
        t.addNode(48, "Salesman 1");

        t.inOrderTraverseTree(t.root);

    }

}

class Node {
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has a key " + key;
    }
}
