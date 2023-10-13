/**
 * This class instantiates a floating point number
 * @author Shankar Choudhury
 */
public abstract class FloatNum extends ArbitraryNumber {
  /**
   * Constructor to initialize digits, isNegative, and precision for a floating point number
   * @param digits The array of digits representing number
   * @param isNegative The sign of the number being represented
   * @param isReal Whether a number is real or not
   * @param precision The precision of the number being represented 
   */
  public FloatNum(byte[] digits, boolean isNegative, boolean isReal, int precision) {
    super(digits, isNegative, isReal, precision);
  }
}