/**
 * This class represents a card and its attributes
 * @author Shankar Choudhury
 */
public abstract class Card {
  // Name of card
  private String name;
  // Value of card
  private int points;
  
  /**
   * Return name of card
   * @return name Name of card
   */
  public String getName() {
    return name;
  }
  
  /**
   * Set name of card
   * @param name Name to be assigned to card
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Return value of card
   * @return points Value of card
   */
  public int getPoints() {
    return points;
  }
  
  /**
   * Set value of card
   * @param points Value to be assigned to card
   */
  public void setPoints(int points) {
    this.points = points;
  }
  
}