/** 
 * This class represents a Gaussian Integer
 * @author Shankar Choudhury
 */
public class GaussianInteger extends ComplexNumber {
  /**
   * Constructor to initialize a gaussian integer number
   * @param realPart The whole real number part
   * @param imagPart The whole imaginary number part
   */
  public GaussianInteger(RealWhole realPart, ImaginaryWhole imagPart) {
    super(realPart, imagPart);
  }
  
  /**
   * Create new Gaussian Integer number that is the sum of this and input number
   * @param number The input number
   * @return newNum New number
   */
  public GaussianInteger add (GaussianInteger number) {
    if (getRealPart().getIsNegative() != number.getRealPart().getIsNegative() || getImaginaryPart().getIsNegative() != number.getRealPart().getIsNegative())
      throw new UnsupportedOperationException();
    GaussianInteger newNum = new GaussianInteger((RealWhole)getRealPart().add(number.getRealPart()), (ImaginaryWhole)getImaginaryPart().add(number.getImaginaryPart()));
    return newNum;
  }
  public GaussianInteger add (IntegerNumber number) {
    GaussianInteger newNum = new GaussianInteger((RealWhole)getRealPart().add(number.getRealPart()), (ImaginaryWhole)getImaginaryPart().add(number.getImaginaryPart()));
    return newNum;
  }
  
}