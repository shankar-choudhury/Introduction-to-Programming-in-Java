/**
 * This class represents an imaginary floating point number
 * @author Shankar Choudhury
 */
public class ImaginaryFloat extends FloatNum {
  /**
   * Constructor to create an imaginary floating number that is positive or negative
   * @param digits The array of digits representing number
   * @param isNegative The sign of the number being represented
   * @param precision The precision of the floating point number
   */
  public ImaginaryFloat(byte[] digits, boolean isNegative, int precision) {
    super(digits, isNegative, false, precision);
  }
}