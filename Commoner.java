/**
 * This class represents Commoner cards
 * @author Shankar Choudhury
 */
public class Commoner extends Card {
   /**
   * Constructor to build Commoner card and assign it name and points depending on value of card
   * @param cardNumber Number of card corresponding to randomly-drawn card
   */
  public Commoner(int cardNumber) {
    if (cardNumber == 6) {
      setName("Tragic Figure");
      setPoints(-1);
    }
    else if (cardNumber == 5) {
      setName("Heroic Figure");
      setPoints(-3);
    }
    else if (cardNumber == 4 || cardNumber == 3 || cardNumber == 2 || cardNumber == 1) {
      setName("Student");
      setPoints(-1);
    }
  }
}