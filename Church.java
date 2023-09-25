/**
 * This class represents Church cards
 * @author Shankar Choudhury
 */
public class Church extends Card {
  /**
   * Constructor to build Church card and assign it name and points depending on value of card
   * @param cardNumber Number of card corresponding to randomly-drawn card
   */
  public Church (int cardNumber) {
    if (cardNumber == 31) {
      setName("Cardinal");
      setPoints(5);
    }
    else if (cardNumber == 30) {
      setName("Archbishop");
      setPoints(4);
    }
    else if (cardNumber == 29) {
      setName("Nun");
      setPoints(3);
    }
    else if (cardNumber == 28) {
      setName("Bishop");
      setPoints(2);
    }
    else if (cardNumber == 27 || cardNumber == 26) {
      setName("Priest");
      setPoints(1);
    }
    else if (cardNumber == 25) {
      setName("Heretic");
      setPoints(1);
    }
  }
}