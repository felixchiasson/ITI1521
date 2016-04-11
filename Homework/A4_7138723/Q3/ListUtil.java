public class ListUtil{
  
 public static <E> LinkedList<Integer> indexOfAll(E element,LinkedList<E> l){
    
    if (element == null) throw new NullPointerException();
    LinkedList<Integer> result = new LinkedList<Integer>();
    if (l.size()!=0){
    Iterator i1 = l.iterator();
    Iterator i2= result.iterator();
      int pos =0;
    while(i1.hasNext()){
      if (i1.next()==element){
        result.addLast(pos);
      }
      pos++;
    
   }

    }
  return result;}}