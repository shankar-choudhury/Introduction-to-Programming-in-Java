/**
 * This class tests all of the methods in the LinkedList class for Project 4
 * Methods that are tested are in classes LinkedList, Player, and Guillotine
 *@author Shankar Choudhury
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTester {
  /**
   * Test all methods in LinkedList and LLNode class
   */
  
  LinkedList <Integer> l = new LinkedList<Integer>();
  // Test addToFront(), getFirstNode(), and isEmpty() methods of LinkesList, and getElement() of LLNode
  @Test
  public void testBasicMethods1() {
    assertEquals(true, l.isEmpty());
    l.addToFront(5);
    assertEquals(5, (int)l.getFirstNode().getElement());
    assertEquals(false, l.isEmpty());
    l.addToFront(4);
    assertEquals(4, (int)l.getFirstNode().getElement());
  }
  
  // Test length() and removeFromFront() methods of LinkedList, and getNext() and length() of LLNode 
  @Test
  public void testBasicMethods2() {
    l.addToFront(4);
    l.addToFront(3);
    assertEquals(2, l.length());
    assertEquals(3, (int) l.removeFromFront());
    assertEquals(4, (int) l.getFirstNode().getElement());
    assertEquals(1, l.length());
  }
  
  // Test 0, 1, and many of moveBack() method of LinkedList, and setNext() of LLNode
  @Test
  public void test_moveBack_0_1_Many() {
    // Test list of length 0
    l.moveBack(1);
    assertEquals(null, l.getFirstNode());
    // Test list of length 1
    l.addToFront(5);
    l.moveBack(1);
    assertEquals(5, (int) l.getFirstNode().getElement());
    // Test list of length many
    l.addToFront(4);
    l.addToFront(3);
    l.addToFront(2);
    l.addToFront(1);
    l.moveBack(1);
    // Ensure it moved initial first node to be second node
    assertEquals(2, (int) l.getFirstNode().getElement());
    assertEquals(1, (int) l.getFirstNode().getNext().getElement());
    assertEquals(3, (int) l.getFirstNode().getNext().getNext().getElement());
  }
  
  // Test first, middle, and last of moveBack() method of LinkedList
  @Test
  public void test_moveBack_First_Middle_Last() {
    // Test that second element is first element when initial first element is moved back by one
    l.addToFront(5);
    l.addToFront(4);
    l.addToFront(3);
    l.addToFront(2);
    l.addToFront(1);
    l.moveBack(1);
    assertEquals(2, (int) l.getFirstNode().getElement());
    // Test that middle element is initial first element
    l.removeFromFront();
    l.removeFromFront();
    l.addToFront(2);
    l.addToFront(1);
    l.moveBack(2);
    assertEquals(1, (int) l.getFirstNode().getNext().getNext().getElement());
    // Test that last element is initial first element
    l.moveBack(4);
    assertEquals(2, (int) l.getFirstNode().getNext().getNext().getNext().getNext().getElement());
    // Test that nothing happens if input exceeds the applicable amount (input should be one less than length of list)
    l.moveBack(5);
    assertEquals(2, (int) l.getFirstNode().getNext().getNext().getNext().getNext().getElement());
  }
    
  // Test 0, 1, and many of moveFirstToLast() method of LinkedList
  @Test
  public void test_moveFirstToLast_0_1_Many() {
    // Test list of length 0, nothing should happen and no exceptions thrown
    l.moveFirstToLast();
    // Test list of length 1, nothing should happen and no exceptions thrown
    l.addToFront(5);
    l.moveFirstToLast();
    assertEquals(5, (int) l.getFirstNode().getElement());
    // Test list of length many
    l.addToFront(4);
    l.addToFront(3);
    l.addToFront(2);
    l.addToFront(1);
    l.moveFirstToLast();
    // Check that new first node was initial second node
    assertEquals(2, (int) l.getFirstNode().getElement());
    // Check that new last node was initial first node
    assertEquals(1, (int) l.getFirstNode().getNext().getNext().getNext().getNext().getElement());
  }
  
  // Test first, middle and last of moveFirstToLast() method of LinkedList
  @Test
  public void test_moveFirstToLast_First_Middle_Last() {
    l.addToFront(5);
    l.addToFront(4);
    l.addToFront(3);
    l.addToFront(2);
    l.addToFront(1);
    l.moveFirstToLast();
    // Check that initial second node is now first node
    assertEquals(2, (int) l.getFirstNode().getElement());
    // Check that initial second-to-last node is now middle node
    assertEquals(4, (int) l.getFirstNode().getNext().getNext().getElement());
    // Check that initial first node is now last node
    assertEquals(1, (int) l.getFirstNode().getNext().getNext().getNext().getNext().getElement());
  }
  
  // Test 0, 1, many of moveLastToFirst() method of LinkedList
  @Test
  public void test_moveLastToFirst_0_1_Many() {
    // Test list of length 0, nothing should happen and no exceptions thrown
    l.moveLastToFirst();
    // Test list of length 1, nothing should happen and no exceptions thrown
    l.addToFront(5);
    l.moveLastToFirst();
    assertEquals(5, (int) l.getFirstNode().getElement());
    // Test list of length many
    l.addToFront(4);
    l.addToFront(3);
    l.addToFront(2);
    l.addToFront(1);
    l.moveLastToFirst();
    // Check that initial last node is now first node
    assertEquals(5, (int) l.getFirstNode().getElement());
    // Check that initial first node is now second node
    assertEquals(1, (int) l.getFirstNode().getNext().getElement());
  }
  
  // Test first, middle, and last of moveLastToFirst() method of LinkedList
  @Test
  public void test_moveLastToFirst_First_Middle_Last() {
    l.addToFront(5);
    l.addToFront(4);
    l.addToFront(3);
    l.addToFront(2);
    l.addToFront(1);
    l.moveLastToFirst();
    // Check that initial last node is now first node
    assertEquals(5, (int) l.getFirstNode().getElement());
    // Check that initial second node is now middle node
    assertEquals(2, (int) l.getFirstNode().getNext().getNext().getElement());
    // Check that initial secon-to-last node is now last node
    assertEquals(4, (int) l.getFirstNode().getNext().getNext().getNext().getNext().getElement());
  }
  
  // Test 0, 1, many and first, middle, last of reverseList() method of LinkedList
  @Test
  public void test_reverseList() {
    // Test list of length 0, nothing should happen and no exceptions thrown
    l.reverseFirstK(2);
    // Test list of length 1, nothing should happen and no exceptions thrown
    l.addToFront(5);
    l.reverseList();
    assertEquals(5, (int) l.getFirstNode().getElement());
    // Test list of length many
    l.addToFront(4);
    l.addToFront(3);
    l.addToFront(2);
    l.addToFront(1);
    l.reverseList();
    // Test first, middle, last
    // Check that initial last node is now first node
    assertEquals(5, (int) l.getFirstNode().getElement());
    // Check that initial middle node is  still middle node
    assertEquals(3, (int) l.getFirstNode().getNext().getNext().getElement());
    // Check that initial first node is last node
    assertEquals(1, (int) l.getFirstNode().getNext().getNext().getNext().getNext().getElement());
  }
  
  // Test 0, 1, many and first, middle, last of reverseFirstK() method of LinkedList
  @Test
  public void test_reverseFirstK() {
    // Test list of length 0, nothing should happen and no exceptions thrown
    l.reverseFirstK(2);
    // Test list of length 1, nothing should happen and no exceptions thrown
    l.addToFront(5);
    l.reverseFirstK(1);
    assertEquals(5, (int) l.getFirstNode().getElement());
    // Test list of length many
    l.addToFront(4);
    l.addToFront(3);
    l.addToFront(2);
    l.addToFront(1);
    l.reverseFirstK(3);
    // Test first, middle, last
    // Check that initial middle node is now first node
    assertEquals(3, (int) l.getFirstNode().getElement());
    // Check that initial first node is middle node
    assertEquals(1, (int) l.getFirstNode().getNext().getNext().getElement());
    // Check that initial last node is still last node
    assertEquals(5, (int) l.getFirstNode().getNext().getNext().getNext().getNext().getElement());
    // Check that nothing happens if input exceeds list length
    l.reverseFirstK(6);
    assertEquals(3, (int) l.getFirstNode().getElement());
  }
}