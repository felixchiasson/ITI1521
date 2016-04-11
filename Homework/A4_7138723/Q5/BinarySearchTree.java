public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<T> {

        private final T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value) {
            this.value = value;
        }

    }

    private Node<E> root;

    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param obj item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add(E obj) {

        // pre-condtion:
        if (obj == null) {
            throw new NullPointerException("Illegal Argument");
        }

        // special case:
        if (root == null) {
            root = new Node<E>(obj);
            return true;
        }

        // general case:
        return add(obj, root);
    }

    private boolean add(E obj, Node<E> current) {

        boolean result;
        int test = obj.compareTo(current.value);

        if (test == 0) {
            result = false; // already exists, not added
        } else if (test < 0) {
            if (current.left == null) {
                current.left = new Node<E>(obj);
                result = true;
            } else {
                result = add(obj, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node<E>(obj);
                result = true;
            } else {
                result = add(obj, current.right);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node<E> p) {
        if (p == null) {
            return "null";
        } else {
            return "(" + toString(p.left) + "," + p.value + "," + toString(p.right) + ")";
        }
    }
    
    public int count ( E low, E high){
      int s=0;
      if (low.compareTo(high)>0)
        throw new IllegalArgumentException();
      Node<E> current = root;
      return countt(current,s,low,high);}
      
      
    
    
    
    private int countt (Node<E> current, int s,E low, E high)   {
      
      if(current!= null ) {
   /*if (current.value.compareTo (high)>1)
     s=countt(current.left,s,low,high);
  else 
  { if (current.value.compareTo(low)<1)
     s=countt(current.right,s,low,high);
  else {
    s=1+countt(current.left,s,low,high);
    s=1+countt(current.right,s,low,high);
  */
        if ((current.value.compareTo(low)>=0)&&(current.value.compareTo(high)<=0)){
         
          s=1+countt(current.left,s,low,high)+countt(current.right,s,low,high);}
           else {
             
             s=countt(current.right,s,low,high)+countt(current.left,s,low,high);
        
  } }

  return s;  }}