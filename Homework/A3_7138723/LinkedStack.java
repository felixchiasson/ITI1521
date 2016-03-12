public class LinkedStack<E> implements Stack<E> {

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
      if (info == null) {
        throw new NullPointerException("push() cannot be called with a null value as parameter");
      }
        top = new Elem<E>(info, top);
    }

    public E peek() {
      if (this.isEmpty()) {
        throw new EmptyStackException("Stack is empty");
      } else {
        return top.info;
      }
    }

    public E pop() {
      if (this.isEmpty()) {
        throw new EmptyStackException("Stack is empty");
      } else {
        E savedInfo;
        savedInfo = top.info;

        top = top.next;

        return savedInfo;
      }
    }
}
