/**
 * This class represents Royal cards
 * @author Shankar Choudhury
 */
public class Royal extends Card {
  /**
   * Constructor to build Royal card and assign it name and points depending on value of card
   * @param cardNumber Number of card corresponding to randomly-drawn card
   */
  public Royal (int cardNumber) {
    if (cardNumber == 40) {
      setName("King Louis XIV");
      setPoints(5);
    }
    else if (cardNumber == 39) {
      setName("Marie Antoinette");
      setPoints(5);
    }
    else if (cardNumber == 38) {
      setName("Regent");
      setPoints(4);
    }
    else if (cardNumber == 37) {
      setName("Duke");
      setPoints(3);
    }
    else if (cardNumber == 36) {
      setName("Baron");
      setPoints(3);
    }
    else if (cardNumber == 35) {
      setName("Count");
      setPoints(2);
    }
    else if (cardNumber == 34) {
      setName("Countess");
      setPoints(2);
    }
    else if (cardNumber == 33) {
      setName("Lord");
      setPoints(2);
    }
    else if (cardNumber == 32) {
      setName("Lady");
      setPoints(2);
    }
  }
}