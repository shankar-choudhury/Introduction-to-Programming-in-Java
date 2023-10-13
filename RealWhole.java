/**
 * This class represents a real whole number
 * @author Shankar Choudhury
 */
public class RealWhole extends WholeNum {
  /**
   * Constructor to create an imaginary whole number that is positive or negative
   * @param digits The array of digits representing number
   * @param isNegative The sign of the number being represented
   */
  public RealWhole(byte[] digits, boolean isNegative) {
    super(digits, isNegative, true);
  }
}