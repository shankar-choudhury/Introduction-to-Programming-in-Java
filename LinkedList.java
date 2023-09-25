import java.util.NoSuchElementException;
/**
 * This class represents a linked list of nodes storing a T and the address of the next card
 * @author Shankar Choudhury
 */
public class LinkedList<T> {
  // First node of linked list
  private LLNode<T> firstNode;
  
  /**
   * Return first node of linked list
   * @return firstNode The first node of linked list
   */
  public LLNode<T> getFirstNode() {
    return firstNode;
  }
  
  /**
   * Assign node to be first node
   * @param node The node to be added to list
   */
  public void setFirstNode(LLNode<T> node) {
    firstNode = node;
  }
  
  /**
   * Constructor for LinkedList
   */
  public LinkedList() {
    firstNode = null;
  }
  
  /**
   * Return whether first node is empty or not
   * @return whether first node is empty or not
   */
  public boolean isEmpty() {
    return getFirstNode() == null;
  }
  
  /**
   * Add node to front of linked list that contains parameter element
   * @param element The element to be added to front of linked list
   */
  public void addToFront(T element) {
    setFirstNode(new LLNode<T>(element, getFirstNode()));
  }
  
  /**
   * Calculate length of linked list from first node
   * @return The number of nodes in linked list
   */
  public int length() {
    try {
      return getFirstNode().length();
    }
    catch (NullPointerException e) {
      return 0;
    }
  }
  
  /**
   * Remove first node from front of list and return element if list is not empty
   * This will be used as player "takes" the front card of the LinkedList and stores it in their pile
   * @return removedElement The element of the first node that was removed
   */
  public T removeFromFront() throws NoSuchElementException {
    if (!isEmpty()) {
      // Save element from node to be removed
      T removedElement = getFirstNode().getElement();
      // "remove" first node by setting the second node to be first node
      setFirstNode(getFirstNode().getNext());
      return removedElement;
    }
    else
      throw new NoSuchElementException();
  }
  
  /**
   * Move first node backwards in list by an amount specified by number of button corresponding to "Move back by x", and modify linked list accordingly
   * @param moveBackBy The amount of spaces to move card backwards
   */
  public void moveBack(int moveBackBy) {
    // Only move back if user input is an acceptable number
    if (moveBackBy <= length() - 1) {
      LLNode<T> nodeToBeMoved = getFirstNode(); // Save first node before list is modified
      LLNode<T> nodeptr = getFirstNode(); // Place in linked list
      setFirstNode(getFirstNode().getNext()); // Reassign first node 
      // Find n'th node
      for (int i = 0; i <moveBackBy; i++) 
        nodeptr = nodeptr.getNext();
      // Adjust pointers for nodeToBeMoved and the current node
      nodeToBeMoved.setNext(nodeptr.getNext());
      nodeptr.setNext(nodeToBeMoved);
    }
  }
  
  /**
   * Move first node to last place
   */
  public void moveFirstToLast() {
    // Only do this if list is not empty and if the length of list is greater than 1
    if (!isEmpty() && length() > 1) {
      // Save first node
      LLNode<T> nodeToBeMoved = getFirstNode();
      LLNode<T> nodeptr = getFirstNode();
      // Reassign first node
      setFirstNode(getFirstNode().getNext());
      // Find last node
      while (nodeptr.getNext() != null)
        nodeptr = nodeptr.getNext();
      // Set last node to be "second to last"
      nodeptr.setNext(nodeToBeMoved);
      // Set previous node to be "last"
      nodeToBeMoved.setNext(null);
    }
  }
  
  /**
   * Move last node to first place
   */
  public void moveLastToFirst() {
    if (!isEmpty() && length() > 1) {
      // Save first node
      LLNode<T> prevFirstNode = getFirstNode();
      LLNode<T> nodeptr = getFirstNode();
      LLNode<T> secondToLastNode = null;
      // Find last node
      while (nodeptr.getNext() != null) {
        // Assign 2ndToLastNode the address of the second to last node 
        if (nodeptr.getNext().getNext() == null)
          secondToLastNode = nodeptr;
        nodeptr = nodeptr.getNext();
      }
      // Assign nodeptr to be first node
      setFirstNode(nodeptr);
      // Set nodeptr's next to be previous first node
      nodeptr.setNext(prevFirstNode);
      // Set previous second-to-last node's next to null, effectively making it the last node
      secondToLastNode.setNext(null);
    }
  }
  
  /**
   * Reverse the linked list
   */
  public void reverseList() {
    if (!isEmpty() && length() > 1) {
      LLNode<T> prevNode = null;
      LLNode<T> nodeptr = getFirstNode();
      LLNode<T> nextNode = null;
      /**
       * Go through linked list and reverse pointers
       * Step 1: assign nextNode the next node of nodeptr
       * Step 2: assign the next node of nodeptr to be the previous node
       * Step 3: assign prevNode the current node of nodeptr
       * Step 4: "move" nodeptr to the next node
       * @precondition This linked list is not empty
       */
      while (nodeptr != null) {
        nextNode = nodeptr.getNext();
        nodeptr.setNext(prevNode);
        prevNode = nodeptr;
        nodeptr = nextNode;
      }
      // Assign prevNode to be the first node
      setFirstNode(prevNode);
    }
  }
  
  /**
   * Reverse the first nodes of the linked list determined by user input
   * @param numNodes Number of nodes from front to reverse
   */
  public void reverseFirstK(int numNodes) {
    if (!isEmpty() && length() > 1) {
      LLNode<T> afterNode = getFirstNode();
      LLNode<T> prevNode = null;
      LLNode<T> nodeptr = getFirstNode();
      LLNode<T> nextNode = null;
      // Only reverse user input amount of nodes if it is less than or equal to the length of the list
      if (numNodes <= length()) {
        // Find node after numNodes nodes
        for(int i = 0; i < numNodes; i++) {
          afterNode = afterNode.getNext();
        }
        // Reverse the first numNodes nodes
        for(int i = 0; i < numNodes; i++) {
          nextNode = nodeptr.getNext();
          nodeptr.setNext(prevNode);
          prevNode = nodeptr;
          nodeptr = nextNode;
        }
        // Assign prevNode to be the first node
        setFirstNode(prevNode);
        // Reset nodeptr
        nodeptr = getFirstNode();
        // Find the last node of the first numNodes nodes
        while (nodeptr.getNext() != null) 
          nodeptr = nodeptr.getNext();
        // Reconnect linked list at that point
        nodeptr.setNext(afterNode);
      }
    }
  }
 
}
    
      
    
      
    
  