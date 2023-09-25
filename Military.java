/**
 * This class represents a Military card and its attributes
 * @author Shankar Choudhury
 */
public class Military extends Card {
  /**
   * Constructor to build Military card and assign it name and points depending on value of card
   * @param cardNumber Number of card corresponding to randomly-drawn card
   */
  public Military(int cardNumber) {
    if (cardNumber == 16 || cardNumber == 15 || cardNumber == 14 || cardNumber == 13 || cardNumber == 12) {
      setName("Palace Guard");
      setPoints(1);
    }
    else if (cardNumber == 11) {
      setName("General");
      setPoints(4);
    }
    else if (cardNumber == 10) {
      setName("Colonel");
      setPoints(3);
    }
    else if (cardNumber == 9) {
      setName("Captain");
      setPoints(2);
    }
    else if (cardNumber == 8 || cardNumber == 7) {
      setName("Lieutenant");
      setPoints(1);
    }
  }
}