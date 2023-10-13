/**
 * This class represents a real floating point number
 * @author Shankar Choudhury
 */
public class RealFloat extends FloatNum {
  /**
   * Constructor to create an imaginary whole number that is positive or negative
   * @param digits The array of digits representing number
   * @param isNegative The sign of the number being represented
   * @param precision The precision of the floating point number
   */
  public RealFloat(byte[] digits, boolean isNegative, int precision) {
    super(digits, isNegative, true, precision);
  }
}