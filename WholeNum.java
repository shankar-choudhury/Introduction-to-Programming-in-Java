
/**
 * This class instantiates a whole number
 * @author Shankar Choudhury
 */
public abstract class WholeNum extends ArbitraryNumber {
  /**
   * Constructor to initialize digits, isNegative, and precision for a floating point number
   * @param digits The array of digits representing number
   * @param isNegative The sign of the number being represented
   * @param isReal Whether a number is real or not
   */
  public WholeNum(byte[] digits, boolean isNegative, boolean isReal) {
    super(digits, isNegative, isReal);
  }
  
}