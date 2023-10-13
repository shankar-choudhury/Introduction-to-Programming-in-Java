/** 
 * This class represents an Integer
 * @author Shankar Choudhury
 */
public class IntegerNumber extends RationalNumber {
  /**
   * Constructor to create an Integer Object
   * @param number An arbitrary number with a precision of zero
   */
  public IntegerNumber(RealWhole number) {
    super(number);
  }
  
  /**
   * Adds an integer to this number
   * @param number The integer to be added
   * @return newNum The new integer as the sum of this and the input
   * @exception UnsupportedOperationException if signs of this and input number are different
   */
  public IntegerNumber add (IntegerNumber number) {
    if (getRealPart().getIsNegative() != number.getRealPart().getIsNegative())
      throw new UnsupportedOperationException();
    IntegerNumber newNum = new IntegerNumber((RealWhole)getRealPart().add(number.getRealPart()));
    return newNum;
  }
  
}