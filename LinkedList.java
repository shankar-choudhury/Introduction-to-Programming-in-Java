//Shankar Choudhury, Connor Fant, Tanisha Nagori

import java.util.NoSuchElementException;

/**
 * A class to represent a linked list of nodes.
 */
public class LinkedList<T> {
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    firstNode = null;
  }
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFirstNode() {
    return firstNode;
  }

  /**
   * Changes the front node.
   * @param node  the node that will be the first node of the new linked list
   */
  protected void setFirstNode(LLNode<T> node) {
    this.firstNode = node;
  }

  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirstNode() == null);
  }
  
  /**
   * Add an element to the front of the linked list
   */
  public void addToFront(T element) {
    setFirstNode(new LLNode<T>(element, getFirstNode()));
  }
  
  /**
   * Removes and returns the element at the front of the linked list
   * @return the element removed from the front of the linked list
   * @throws NoSuchElementException if the list is empty
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFirstNode().getElement();
      setFirstNode(getFirstNode().getNext());
      return save;
    }
  }

  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int length() {
    int lengthSoFar = 0;
    LLNode<T> nodeptr = getFirstNode();
    while (nodeptr != null) {
      lengthSoFar++;
      nodeptr = nodeptr.getNext();
    }
    return lengthSoFar;
  }
  
  /*-------------------------------------------*/
  /* THE NEXT METHODS WILL BE COMPLETED IN LAB */
  /*-------------------------------------------*/
  
  /**
   * Returns a String representation of the list
   * @return a String representing the list
   */
  public String toString() {
   StringBuilder listElements = new StringBuilder();
   LLNode<T> nodePtr = getFirstNode();
   listElements.append("list:");
   
   while( nodePtr!= null){
     listElements.append(" ");
     listElements.append(nodePtr.getElement()); 
     nodePtr=nodePtr.getNext();
   }
   return listElements.toString();
  }
  
  /**
   * Determines whether an element is stored in the list
   * @param element  the element to search for in the list
   * @return true if and only if the parameter element is in the list
   */
  public boolean contains(T element) {
    LLNode<T> nodePtr = getFirstNode();
    while (nodePtr != null) {
      if (nodePtr.getElement() == element)
        return true;
      else 
        nodePtr = nodePtr.getNext();
    }
    return false;
  }
    
  
  /**
   * Deletes the first occurrance of an element in the list.
   * If the element is not in the list, the list is unchanged.
   * @param element  the element to remove
   */
  public void remove(T element) {
    LLNode<T> nodePtr = getFirstNode();
    while (nodePtr != null) {
      if (nodePtr.getNext().getElement() == element)
        nodePtr.deleteNext();
      else 
        nodePtr = nodePtr.getNext();
    }
  }
  
}
