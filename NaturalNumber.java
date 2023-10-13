/** 
 * This class represents a Natural Number
 * @author Shankar Choudhury
 */
public class NaturalNumber extends IntegerNumber {
  /**
   * Constructor to create a natural number object
   * @param number An arbitrary number with a precision of zero
   */
  public NaturalNumber (RealWhole number) {
    super(number);
  }
  
  public NaturalNumber add (NaturalNumber number) {
    NaturalNumber newNum = new NaturalNumber((RealWhole)getRealPart().add(number.getRealPart()));
    return newNum;
  }
}