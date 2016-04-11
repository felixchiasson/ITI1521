package itiiiii15211;

public class LinkedList<E> {
	  
    private static class Node<T> {
    
        private T value;
    
        private Node<T> previous;
        private Node<T> next;
    
        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
  
    private Node<E> head;
    private int size;
  
    public LinkedList() {
        head = new Node<E>(null, null, null);
        head.next = head.previous = head;
        size = 0;
    }
  
    /** Returns the size of this list.
     *
     * @return the size of this list
     */
  
    public int size() {
        return size;
    }
  
    /** 
     * Adds an element at the end of the list.
     *
     * @param element the element to be added.
     * @return true since duplicated values are allowed.
     * @throws NullPointerException if elem is null.
     */
  
    public boolean addLast(E element) {
    
        if (element == null) {
            throw new NullPointerException();
        }
    
        Node<E> before, after;

 before = head.previous;
        after = head;
    
        before.next = new Node<E>(element, before, after);
        after.previous = before.next;
    
        size++;
    
        return true;
    }
    
    public void insertAfter(E element, LinkedList<E> other){
      if (element==null) throw new NullPointerException();
      if (size ==0) throw new IllegalArgumentException();
      
     Node<E> p =head;
     while ((p.next!=head)&&(p.value != element)){
       p=p.next;}
     if ((p.next == head )&& (p.value != element)) throw new IllegalArgumentException();
     Node<E> o = other.head.next;
     Node<E> q= o;
     while(q.next!=other.head){
       q=q.next;}
     p.next.previous=q;
     q.next=p.next;
     p.next= other.head.next;
     p.next.previous=p;
    
      
    }
    
    public void affich(){
    	Node<E> p = head.next;
    	while(p!=head){
    		System.out.println(p.value);
    		p=p.next;
    	}
    }
    
    
    
    
}
