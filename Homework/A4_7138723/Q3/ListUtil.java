public class ListUtil {

    public static <E> LinkedList<Integer> indexOfAll(List<E> l, E element){

        if (element == null)
            throw new NullPointerException();

        LinkedList<Integer> result = new LinkedList<Integer>();

        if (l.size() != 0) {
            Iterator iter = l.iterator();
            int pos = 0;

            // Look for the next element in the list using the iterator and
            // keep counting to keep track of the index
            while(iter.hasNext()) {
                if (iter.next() == element) {
                    result.addLast(pos);
                }

                pos++;

            }

        }

        return result;
    }
}
