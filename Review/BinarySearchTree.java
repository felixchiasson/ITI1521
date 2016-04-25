/*************************************************************************************************
*     File Name           :     BinarySearchTree.java
*     Created By          :     Félix Chiasson (7138723)
*     Creation Date       :     [2016-04-24 23:01]
*     Last Modified       :     [2016-04-24 23:22]
*     Description         :     Review of binary search tree with comments
**************************************************************************************************/

public class BinarySearchTree {

    Node root;

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

    public static void main(String[] args) {

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
