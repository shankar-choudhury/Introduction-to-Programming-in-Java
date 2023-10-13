/**
 * This class creates an integer that can only be positive, requiring the user to input a natural number into NaturalNumber's constructor
 * @author Shankar Choudhury
 */
public class NaturalNum extends RealWhole {
  public NaturalNum(byte[] digits) {
    super(digits, false);
  }
}