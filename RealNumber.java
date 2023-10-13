/** 
 * This class represents a real number
 * @author Shankar Choudhury
 */
public class RealNumber extends ComplexNumber {
  /**
   * Constructor that passes up boolean isWhole from rational number if rational number is instantiated with a denominator != {1}
   * @param isWhole boolean value of whether number is whole or not
   */
  public RealNumber(boolean isWhole) {
    super(isWhole);
  }
  
  /**
   * Constructor that instantiates a new real number
   * @param number The input number to create a new real number
   */
  public RealNumber(ArbitraryNumber number) {
    super(number);
  }
  
  /**
   * Default constructor that does nothing
   */
  public RealNumber() {
    ;
  }
  
  /**
   * Add a real number to this real number
   * @param number The real number that will be added to this number
   * @return newNum The new Real Number that is the sum of this number and the input number
   * @exception UnsupportedOperationException If signs or denominators of numbers don't match
   */
  public RealNumber add(RealNumber number) {
    if (number instanceof RationalNumber && !getDenomIsOne() && getRealPart().getIsNegative() != number.getRealPart().getIsNegative())
      throw new UnsupportedOperationException();
    RealNumber newNum = new RealNumber(getRealPart().add(number.getRealPart()));
    return newNum;
  }
  
}