import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> { // Need to specify Iterator's generic type
  private LLNode<T> nodeptr;
  
  public LinkedListIterator(LLNode<T> firstNode) {
    nodeptr = firstNode;
  }
  
  public boolean hasNext() {
    return nodeptr != null;
  }
  
  public T next() {
    if (!hasNext())
      throw new NoSuchElementException();
    T save = nodeptr.getElement(); // Saving the next element so we can return it later on without stopping method
    nodeptr = nodeptr.getNext();
    return save;
  }
}