/** 
 * This class represents a rational number
 * @author Shankar Choudhury
 */
public class RationalNumber extends RealNumber {
  // Numerator of the rational number
  private RealWhole numerator;
  // Denominator of the rational number
  private RealWhole denominator;
  
  /**
   * Constructor to create an instance of a rational number with a specified numerator and denominator that doesn't equal {1}
   * Does not pass values up heirarchy and calls constructor of RealNumber that takes a boolean
   * @param numerator The whole numerator part of rational number
   * @param denominator The whole denominator part of rational number
   */
  public RationalNumber(RealWhole numerator, RealWhole denominator) {
    super(false);
    this.numerator = numerator;
    this.denominator = denominator;
  }
  
  /**
   * Constructor to create an instance of a rational number with just a specified numerator and a denominator of 1
   * Used to pass values up heirarchy when creating objects lower on heirarchy such as integer or natural number
   * @param number The whole number part of rational number
   */
  public RationalNumber(RealWhole number) {
    super(number);
    this.numerator = number;
    byte[] digits = new byte[]{1};
    this.denominator = new RealWhole(digits, false);
  }
  
  /**
   * Getter method for numerator
   * @return numerator
   */
  public RealWhole getNumerator() {
    return numerator;
  }
  
  /**
   * Getter method for denominator
   * @return denominator
   */
  public RealWhole getDenominator() {
    return denominator;
  }
  
  /**
   * Return a string of the numerator and the denominator of this rational number
   * @return denominator
   */
  public String toString() {
    if (this instanceof IntegerNumber)
      return super.toString();
    else
      return getNumerator().toString() + '/' + getDenominator().toString();
  }
  
  /**
   * Return boolean value of whether this rational number is equal to the input rational number
   * @param number The number that this number is being compared to
   * @return boolean value of equality between this number and input number
   */
  public boolean equals(RationalNumber number) {  
    return getNumerator().equals(number.getNumerator()) && getDenominator().equals(number.getDenominator());
  }
                                 
  /**
   * Create new rational number that is the sum of this and the input number
   * @param a rational number to be added to
   * @return newNum a new rational number
   * @exception UnsupportedOperationException if signs of this number's numerator 
   * or denominator don't equal the input number's numerator and denominator respectively
   */
  public RationalNumber add(RationalNumber number) {
    if (!getDenominator().equals(number.getDenominator()) || 
           getNumerator().getIsNegative() != number.getNumerator().getIsNegative()) {
         throw new UnsupportedOperationException();
    }
    RationalNumber newNum = new RationalNumber((RealWhole)getNumerator().add(number.getNumerator()), getDenominator());
    return newNum;
  }
  
}