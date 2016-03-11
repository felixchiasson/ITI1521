public class LinkedStack<E> implements Stack<E>{

    private static class Elem<T> {
        private T info;
        private Elem<T> next;
        private Elem( T info, Elem<T> next) {
            this.info = info;
            this.next = next;
        }
    }

    private Elem<E> top; // instance variable

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E info) {
        top = new Elem<E>(info, top);
    }

    public E peek() {
        return top.info;
    }

    public E pop() {
        E savedInfo;
	savedInfo = top.info;

	top = top.next;

        return savedInfo;
    }
}
