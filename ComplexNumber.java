import java.util.Arrays;
/** 
 * This class represents a complex number
 * @author Shankar Choudhury
 */
public class ComplexNumber {
  // Real number of complex number
  private ArbitraryNumber realPart;
  // Imaginary number of complex number
  private ArbitraryNumber imagPart;
  // Boolean value of whether real part is whole or not, used for comparing rational numbers only
  private boolean denomIsOne = true;
  
  /**
   * Default constructor that takes no inputs
   */
  public ComplexNumber() {
    ;
  }
  
  /**
   * Constructor that takes a boolean value passed up from rational number if denominator is not {1}
   */
  public ComplexNumber(boolean denomIsOne) {
    this.denomIsOne = denomIsOne;
  }
  
  /**
   * Constructor to initialize complex number's realPart attribute when a real number is passed up by RealNumber, RationalNumber if a whole number, Integer, or Natural
   * Because real numbers use this constructor, give the imaginary part a value of 0 instead of null
   * @param realPart The real number part
   */
  public ComplexNumber(ArbitraryNumber realPart) {
    if (realPart instanceof RealWhole)
      this.realPart = (RealWhole) realPart;
    else if (realPart instanceof RealFloat)
      this.realPart = (RealFloat) realPart;
    byte[] imaginaryZero = {0};
    this.imagPart = new ImaginaryWhole(imaginaryZero, false);
  }
  
  /**
   * Constructor to initialize a complex number 
   * @param realPart the real number part
   * @param imagPart the imaginary number part
   */
  public ComplexNumber(ArbitraryNumber realPart, ArbitraryNumber imaginaryPart) {
    if (realPart instanceof RealFloat)
      this.realPart = (RealFloat) realPart;
    else if (realPart instanceof RealWhole)
      this.realPart = (RealWhole) realPart;
    if (imaginaryPart instanceof ImaginaryFloat)
      this.imagPart = (ImaginaryFloat) imaginaryPart;
    else if (imaginaryPart instanceof ImaginaryWhole)
      this.imagPart = (ImaginaryWhole) imaginaryPart;
  }
  
  /**
   * Getter method for realPart
   * @return realPart
   */
  public ArbitraryNumber getRealPart() {
    return realPart;
  }
  
  /**
   * Getter method for imagPart
   * @return imagPart
   */
  public ArbitraryNumber getImaginaryPart() {
    return imagPart;
  }
  
  /**
   * Getter method for denomIsOne value
   * @return denomIsOne
   */
  public boolean getDenomIsOne() {
    return denomIsOne;
  }
  
  /**
   * Return the parts of a number as a string
   * @return String version of number
   */ 
  public String toString() {
    if (getImaginaryPart() != null)
      return getRealPart().toString() + getImaginaryPart().toString();
    else
      return getRealPart().toString();
  }
  
  /**
   * Return boolean value of whether this number is equal to the input number
   * @param number The number that this number is being compared to
   * @return boolean value of equality between this number and input number
   */
  public boolean equals(ComplexNumber number) {
    return getRealPart().equals(number.getRealPart()) && getImaginaryPart().equals(number.getImaginaryPart());
  }
  
  /**
   * Create new number that is the sum of this and input number
   * @param number The input number
   * @return newNum New number
   * @exception UnsupportedOperationException If rational number doesn't have a 
   * denominator of 1, or if this number's sign is different than the input's sign
   */
  public ComplexNumber add (ComplexNumber number) {
    ComplexNumber newNum1 = null;
    if (number instanceof RationalNumber && !number.getDenomIsOne()) 
      throw new UnsupportedOperationException();
    if (getRealPart().getIsNegative() != number.getRealPart().getIsNegative() || getImaginaryPart().getIsNegative() != number.getImaginaryPart().getIsNegative())
      throw new UnsupportedOperationException();
    newNum1 = new ComplexNumber(getRealPart().add(number.getRealPart()), getImaginaryPart().add(number.getImaginaryPart()));
    return newNum1;
  }
}