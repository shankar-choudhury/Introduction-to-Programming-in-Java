/**
 * This class tests all of methods in the Player class for Project 4
 * Methods that are tested are in classes LinkedList, Player, and Guillotine
 *@author Shankar Choudhury
 */
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTester {
  // Create Players
  Player player1 = new Player("Player 1");
  Player player2 = new Player("Player 2");
  
  
  // Test smallest number of cards possible
  LinkedList<Card> listSmall = new LinkedList<Card>();
  
  // Test player single-use methods 
  @Test
  public void test1() {
    player1.setTurn(true);
    listSmall.addToFront(new Royal(40));
    listSmall.addToFront(new Commoner(6));
    
    // Initiate "game" by setting it to be player1's turn
    // Test player1's moveBackFour, moveBackThree, moveBackTwo, and reverseFirstFiveCards for too-large execution 
    assertEquals(-3, player1.moveBackFour(listSmall));
    assertEquals(-3, player1.moveBackThree(listSmall));
    assertEquals(-3, player1.moveBackTwo(listSmall));
    assertEquals(-3, player1.reverseFirstFiveCards(listSmall));
    
    // Test moveBackOne for successful execution
    assertEquals(0, player1.moveBackOne(listSmall));
    // Test moveBackOne for repeated execution
    assertEquals(-1, player1.moveBackOne(listSmall));
    // Test moveBackOne for not-turn execution
    assertEquals(-2, player2.moveBackOne(listSmall));
    
    // Test moveFrontToEnd for successful execution
    assertEquals(0, player1.moveFrontToEnd(listSmall));
    // Test moveFrontToEnd for repeated execution
    assertEquals(-1, player1.moveFrontToEnd(listSmall));
    // Test moveFrontToEnd for not-turn execution
    assertEquals(-2, player2.moveFrontToEnd(listSmall));
    
    // Test moveEndToFront for successful execution
    assertEquals(0, player1.moveEndToFront(listSmall));
    // Test moveEndToFront for repeated execution
    assertEquals(-1, player1.moveEndToFront(listSmall));
    // Test movEndToFront for not-turn execution
    assertEquals(-2, player2.moveEndToFront(listSmall));
    
    // Test reverseCards for successful execution
    assertEquals(0, player1.reverseCards(listSmall));
    // Test reverseCards for repeated execution
    assertEquals(-1, player1.reverseCards(listSmall));
    // Test reverseCards for not-turn execution
    assertEquals(-2, player2.reverseCards(listSmall));
    
    // Test skipTurn for successful execution
    assertEquals(0, player1.skipTurn(player2));
    // Test skipTurn for not-turn execution 
    assertEquals(-2, player1.skipTurn(player2));
    player1.setTurn(true);
    // Test skipTurn for repeated usage
    assertEquals(-1, player1.skipTurn(player2));
    
    player1.setTurn(false);
    // Test drawPlayCard for successful execution
    assertEquals(0, player2.drawPlayCard(listSmall, player1));
    // Test drawPlayCard for not-turn execution
    assertEquals(-2, player2.drawPlayCard(listSmall, player1));
    player1.drawPlayCard(listSmall, player2);
    // Test drawPlayCard for game winner
    assertEquals(2, player2.drawPlayCard(listSmall, player1));
  }
  
  // Test drawPlayCard, checkForSpecialCard, incSpecialCardCount, and adjustCardValue methods for modifying Count, Countess, Lord, and Lady card values in player's hand when appropriate
  @Test
  public void test2() {
    listSmall.addToFront(new Royal(35));
    listSmall.addToFront(new Royal(33));
    listSmall.addToFront(new Royal(34));
    listSmall.addToFront(new Royal(32));
    player1.setTurn(true);
    player1.drawPlayCard(listSmall, player2);
    player2.drawPlayCard(listSmall, player1);
    // Test values of Count, Countess, Lord, and Lady are unmodified for testing 0 and first
    assertEquals(2, player1.getCardsCollected().getFirstNode().getElement().getPoints());
    assertEquals(2, player2.getCardsCollected().getFirstNode().getElement().getPoints());
    
    player1.drawPlayCard(listSmall, player2);
    player2.drawPlayCard(listSmall, player1);
    // Test modified point values of Count, Countess, Lord, Lady for testing 1, many, middle, and last
    assertEquals(4, player1.getCardsCollected().getFirstNode().getElement().getPoints());
    assertEquals(4, player2.getCardsCollected().getFirstNode().getElement().getPoints());
    assertEquals(4, player1.getCardsCollected().getFirstNode().getNext().getElement().getPoints());
    assertEquals(4, player2.getCardsCollected().getFirstNode().getNext().getElement().getPoints());
    // Test drawPlayCard for tie
    assertEquals(3, player1.drawPlayCard(listSmall, player2));
  }
  
  // Test drawPlayCard, checkForSpecialCard, incSpecialCardCount, and adjustCardValue methods for modifying Tax Collector and Heretic's values in player's hand when appropriate
  @Test
  public void test3() {
    player1.setTurn(true);
    listSmall.addToFront(new Church(25));
    listSmall.addToFront(new Civic(19));
    player1.drawPlayCard(listSmall, player2);
    player2.drawPlayCard(listSmall, player1);
    // Test values of Tax Collector and Heretic are unmodified for testing 0 and first
    assertEquals(1, player1.getCardsCollected().getFirstNode().getElement().getPoints());
    assertEquals(1, player2.getCardsCollected().getFirstNode().getElement().getPoints());
    listSmall.addToFront(new Church(31));
    listSmall.addToFront(new Civic(24));
    player1.drawPlayCard(listSmall, player2);
    player2.drawPlayCard(listSmall, player1);
    listSmall.addToFront(new Royal(38));
    player1.drawPlayCard(listSmall, player2);
    // Test values of Tax Collector and Heretic are modified for testing 1 and middle
    assertEquals(2, player1.getCardsCollected().getFirstNode().getNext().getNext().getElement().getPoints());
    assertEquals(2, player2.getCardsCollected().getFirstNode().getNext().getElement().getPoints());
    player1.setTurn(true);
    player2.setTurn(false);
    listSmall.addToFront(new Church(29));
    listSmall.addToFront(new Civic(18));
    player1.drawPlayCard(listSmall, player2);
    player2.drawPlayCard(listSmall, player1);
    // Test values of Tax collector and Heretic are modified for testing many and last
    assertEquals(3, player1.getCardsCollected().getFirstNode().getNext().getNext().getNext().getElement().getPoints());
    assertEquals(3, player2.getCardsCollected().getFirstNode().getNext().getNext().getElement().getPoints());
  }
  
  // Test drawPlayCard, checkForSpecialCard, incSpecialCardCount, and adjustCardValue methods method for modifying Palace Guard and Tragic Figure
  @Test
  public void test4() {
    player1.setTurn(true);
    listSmall.addToFront(new Military(16));
    listSmall.addToFront(new Commoner(6));
    player1.drawPlayCard(listSmall, player2);
    player2.drawPlayCard(listSmall, player1);
    // Test values of Palace Guard and Tragic Figure are unmodified for test 0 and first
    assertEquals(-1, player1.getCardsCollected().getFirstNode().getElement().getPoints());
    assertEquals(1, player2.getCardsCollected().getFirstNode().getElement().getPoints());
    listSmall.addToFront(new Military(14));
    listSmall.addToFront(new Commoner(2));
    player1.drawPlayCard(listSmall, player2);
    player2.drawPlayCard(listSmall, player1);
    // Test values of Palace Guard and Tragic Figure are modified for test 1 and middle
    assertEquals(-2, player1.getCardsCollected().getFirstNode().getNext().getElement().getPoints());
    assertEquals(2, player2.getCardsCollected().getFirstNode().getNext().getElement().getPoints());
    listSmall.addToFront(new Military(15));
    listSmall.addToFront(new Commoner(1));
    player1.drawPlayCard(listSmall, player2);
    player2.drawPlayCard(listSmall, player1);
    // Test values of Palace Guard and Tragic Figure are modified for test many and last
    assertEquals(-3, player1.getCardsCollected().getFirstNode().getNext().getNext().getElement().getPoints());
    assertEquals(3, player2.getCardsCollected().getFirstNode().getNext().getNext().getElement().getPoints());
  }
  
  // Test player1's moveBackFour, moveBackThree, moveBackTwo, and reverseFirstFiveCards with list of sufficient size
  @Test
  public void test5() {
    player1.setTurn(true);
    listSmall.addToFront(new Church(25));
    listSmall.addToFront(new Civic(19));
    listSmall.addToFront(new Military(16));
    listSmall.addToFront(new Commoner(6));
    listSmall.addToFront(new Military(14));
    listSmall.addToFront(new Commoner(2));
    listSmall.addToFront(new Royal(34));
    
    // Test moveBackFour for successful execution
    assertEquals(0, player1.moveBackFour(listSmall));
    // Test moveBackFour for repeated execution
    assertEquals(-1, player1.moveBackFour(listSmall));
    // Test moveBackFour for not-turn execution
    assertEquals(-2, player2.moveBackFour(listSmall));
    
    // Test moveBackThree for successful execution
    assertEquals(0, player1.moveBackThree(listSmall));
    // Test moveBackThree for repeated execution
    assertEquals(-1, player1.moveBackThree(listSmall));
    // Test moveBackThree for not-turn execution
    assertEquals(-2, player2.moveBackThree(listSmall));
    
    // Test moveBackTwo for successful execution
    assertEquals(0, player1.moveBackTwo(listSmall));
    // Test moveBackTwo for repeated execution
    assertEquals(-1, player1.moveBackTwo(listSmall));
    // Test moveBackTwo for not-turn execution
    assertEquals(-2, player2.moveBackTwo(listSmall));
    
    // Test reverseFirstFive for successful execution
    assertEquals(0, player1.reverseFirstFiveCards(listSmall));
    // Test reverseFirstFive for repeated execution
    assertEquals(-1, player1.reverseFirstFiveCards(listSmall));
    // Test reverseFirstFive for not-turn execution
    assertEquals(-2, player2.reverseFirstFiveCards(listSmall));
  }
  
}