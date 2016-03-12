public class LinkedQueue<E> implements Queue<E> {

    private static class Elem<T> {

        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    public E peek() {
      if (this.isEmpty()) {
        throw new EmptyQueueException("Queue is empty");
      } else {
        return front.value;
      }
    }

    public void enqueue(E value) {
      if (value == null) {
        throw new NullPointerException("enqueue() cannot be used with a null value");
      }
        Elem<E> newElem;
        newElem = new Elem<E>(value, null );

        if (rear == null) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
    }

    public E dequeue() {
        E result;
        result = front.value;
        if (front != null & front.next == null) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return result;
    }

    public boolean isEmpty() {
        return front == null;
    }

}
