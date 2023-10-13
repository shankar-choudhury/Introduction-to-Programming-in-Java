import java.util.Arrays;
/**
 * This class represents an imaginary whole number
 * @author Shankar Choudhury
 */
public class ImaginaryWhole extends WholeNum {
  /**
   * Constructor to create an imaginary whole number that is positive or negative
   * @param digits The array of digits representing number
   * @param isNegative The sign of the number being represented
   */
  public ImaginaryWhole(byte[] digits, boolean isNegative) {
    super(digits, isNegative, false);
  }
  
}