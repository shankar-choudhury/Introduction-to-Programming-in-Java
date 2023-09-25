/**
 * This class represents Civic Cards
 * @author Shankar Choudhury
 */
public class Civic extends Card {
  /**
   * Constructor to build Civic card and assign it name and points depending on value of card
   * @param cardNumber Number of card corresponding to randomly-drawn card
   */
  public Civic(int cardNumber) {
     if (cardNumber == 24) {
      setName("Governor");
      setPoints(4);
    }
    else if (cardNumber == 23) {
      setName("Mayor");
      setPoints(3);
    }
    else if (cardNumber == 22) {
      setName("Councilman");
      setPoints(3);
    }
    else if (cardNumber == 21 || cardNumber == 20) {
      setName("Judge");
      setPoints(2);
    }
    else if (cardNumber == 19) {
      setName("Tax Collector");
      setPoints(1);
    }
    else if (cardNumber == 18 || cardNumber == 17) {
      setName("Sheriff");
      setPoints(1);
    }
  }
}