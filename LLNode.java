/**
 * This class represents the nodes of a linked list
 * @author Shankar Choudhury
 */
public class LLNode<T> {
  // Element of node
  private T element;
  // Pointer to next node
  private LLNode<T> next;
  
  /**
   * Constructor for node
   * @param element The element to store in node
   * @param next The next node
   */
  public LLNode(T element, LLNode<T> next) {
    this.element = element;
    this.next = next;
  }
  
  /**
   * Return value of element of this node
   * @return element Value of element of this node
   */
  public T getElement() {
    return element;
  }
  
  /**
   * Assign the node an input element
   * @param element The element to be assigned to this node
   */
  public void setElement(T element) {
    this.element = element;
  }
  
  /**
   * Return address of next node
   * @return next The next node
   */
  public LLNode<T> getNext() {
    return next;
  }
  
  /**
   * Assign the next node of current node
   * @param next The next node to be assigned
   */
  public void setNext(LLNode<T> next) {
    this.next = next;
  }
  
  /**
   * Calculate length of successive nodes of linked list
   * @return 1 List of nodes has length of 1 if there is only one node
   * @return getNext().length() + 1 List of nodes has length greater than 1, recursively calculating 
   */
  public int length() {
    if (getNext() == null)
      return 1;
    else
      return getNext().length() + 1;
  }
}