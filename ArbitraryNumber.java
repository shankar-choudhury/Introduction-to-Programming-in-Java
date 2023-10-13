import java.util.Arrays;
/**
 * This abstract class holds the values of the digits in an array, sign, whether it is real or not, and precision
 * @author Shankar Choudhury
 */
public abstract class ArbitraryNumber {
  // Array of digits that represent number
  private byte[] digits; 
  // Sign of number being represented
  private boolean isNegative; 
  // Whether number is real or imaginary
  private boolean isReal;
  // Amount of decimal places the number takes up right of decimal point. If whole number, precision = 0;
  private int precision; 
  // Whether number is a whole number or not, determines
  private boolean isWhole;
  
  /**
   * Constructor to initialize digits, isNegative, and precision for a floating point number
   * @param digits The array of digits representing number
   * @param isNegative The sign of the number being represented
   * @param isReal Whether a number is real or not
   * @param precision The precision of the number being represented 
   */
  public ArbitraryNumber(byte[] digits, boolean isNegative, boolean isReal, int precision) {
    this.digits = digits;
    this.isNegative = isNegative;
    this.isReal = isReal;
    this.precision = precision;
    this.isWhole = false;
  }
  
  /**
   * Constructor to initialize digits and isNegative for a whole number
   * @param digits The array of digits representing number
   * @param isNegative The sign of the number being represented
   * @param isReal Whether a number is real or not
   */
  public ArbitraryNumber(byte[] digits, boolean isNegative, boolean isReal) {
    this.digits = digits;
    this.isNegative = isNegative;
    this.isReal = isReal;
    this.precision = 0;
    this.isWhole = true;
  }
  
  /**
   * Getter method for digits 
   * @return Byte array of digits
   */
  public byte[] getDigits() {
    return digits;
  }
  
  /**
   * Getter method for isNegative 
   * @return isNegative
   */
  public boolean getIsNegative() {
    return isNegative;
  }
  
   /**
   * Getter method for isReal 
   * @return isReal
   */
  public boolean getIsReal() {
    return isReal;
  }
  
  /**
   * Getter method for precision
   * @return precision
   */
  public int getPrecision() {
    return precision;
  }
  
  /**
   * Getter method for isWhole
   * @return isWhole
   */
  public boolean getIsWhole() {
    return isWhole;
  }
  
  /**
   * Convert number to a string and print it in the interactions panel if number exists or is non-zero
   * @return newString The string that the number has been converted to
   */
  @Override
  public String toString() {
    StringBuilder newString = new StringBuilder(); // StringBuilder to append to 
    byte[] zeroDigitCompare = new byte[]{0}; // Array of a singular zero to compare with this digits array for comparison's sake

    // Check if digits array exists or if digits array is zero
    if (getDigits() != null && !Arrays.equals(getDigits(), zeroDigitCompare)) {
      // Conditions to check if specific things need to be appended at beginning
      // If number is an imaginary number
      if (!getIsReal()) {
        // If negative, append a minus sign 
        if (getIsNegative())
          newString.append(" - ");
        // If positive, append a plus sign 
        else
          newString.append(" + ");
      }
      // If the number is real and negative, append a minus sign
      else if (getIsReal() && getIsNegative())
        newString.append('-');
      // Find index where first nonzero is encountered
      int lastIndex = 0;
      boolean nonZeroFound = false;
      int lookingIndex = getDigits().length - 1;
      while (!nonZeroFound && lookingIndex > -1) {
        if (getDigits()[lookingIndex] != 0) {
          lastIndex = lookingIndex;
          nonZeroFound = true;
        }
        else
          lookingIndex--;
      }
      // If precision is greater than length of array 
      if (getDigits().length - (getDigits().length - lastIndex) < getPrecision()  && !getIsWhole()) {
        newString.append("0.");
        // Append a zero difference times 
        for (int i = 0; i < getPrecision() - 1; i++) 
          newString.append('0');
      }
      /**
       * Go through imaginary whole number's digits array and append to newString appropriately 
       * @precondition imaginary part of number is not null 
       * @precondition imaginary digits array is not {0}
       */
      for (int i = lastIndex; i > -1 ; i--) {
        newString.append(getDigits()[i]);
        // If this is a floating point number, append a "." at the appropriate precision
        if (i - getPrecision() == 0 && !getIsWhole())
          newString.append('.');
      }
      // If number is imaginary, append an i at the end of newString
      if (!getIsReal()) 
        newString.append('i');
    }
      return newString.toString();
  }
  
   /**
   * Return boolean equality if this number is equal to the input number
   * @param o The arbitrary number that will be compared to this number
   * @return Boolean whether this number equals the input number
   */
  @Override
  public boolean equals (Object o) {
    if (o instanceof ArbitraryNumber) {
      ArbitraryNumber n = (ArbitraryNumber) o;
      // If input is a floating point number, 
      if (n instanceof FloatNum) {
        /**
         * Find index's where this number begins and ends in digits indices while ignoring leading zeroes
         * @precondition the input number is a floating point number
         */
        int thisFrontIndex = 0;
        int thisBackIndex = this.getDigits().length - 1;
        boolean thisFrontNumFound = false;
        boolean thisBackNumFound = false;
        while ((!thisFrontNumFound || !thisBackNumFound) && thisFrontIndex < thisBackIndex) {
          if (getDigits()[thisFrontIndex] != 0 && !thisFrontNumFound) 
            thisFrontNumFound = true;
          else if (getDigits()[thisBackIndex] != 0 && !thisBackNumFound) 
            thisBackNumFound = true;
          if (getDigits()[thisFrontIndex] == 0) 
            thisFrontIndex++;
          else if (getDigits()[thisBackIndex] == 0) 
            thisBackIndex--;
        } 
        int thisFrontIndex2 = thisFrontIndex;
        /**
         * Find index's where n's number begins and ends in digits indices while ignoring leading zeroes
         * @precondition the input number is a floating point number
         */
        int nFrontIndex = 0;
        int nBackIndex = n.getDigits().length - 1;
        boolean nFrontNumFound = false;
        boolean nBackNumFound = false;
        while ((!nFrontNumFound || !nBackNumFound) && nFrontIndex < nBackIndex) {
          if (n.getDigits()[nFrontIndex] != 0 && !nFrontNumFound) 
            nFrontNumFound = true;
          else if (n.getDigits()[nBackIndex] != 0 && !nBackNumFound) 
            nBackNumFound = true;
          if (n.getDigits()[nFrontIndex] == 0) 
            nFrontIndex++;
          else if (n.getDigits()[nBackIndex] == 0) 
            nBackIndex--;
        }
        int nFrontIndex2 = nFrontIndex;
        
        // Calculate actual lengths of either digit arrays not including leading zeroes
        int thisActualLength = 0;
        for (int i = thisFrontIndex; i <= thisBackIndex; i++)
          thisActualLength++;
        int nActualLength = 0;
        for (int i = nFrontIndex; i <= nBackIndex; i++)
          nActualLength++;
        
        // Default boolean value of equality of numbers 
        boolean sameNumber = true;
        // If their lengths are the same, then compare contents
        if (thisActualLength == nActualLength) {
          int counter = 0;
          int maxLength = 0;
          if (thisActualLength > nActualLength)
            maxLength = thisActualLength;
          else
            maxLength = nActualLength;
        /**
         * Compare numbers to see if they are the same one digit at a time, stop comparing if they aren't
         * @precondition if input is a floating number
         */
          while (sameNumber && counter < maxLength) { 
            sameNumber = getDigits()[thisFrontIndex] == n.getDigits()[nFrontIndex];
            if (thisFrontIndex <= thisBackIndex) 
              thisFrontIndex++;
            if (nFrontIndex <= nBackIndex) 
              nFrontIndex++;
            counter++;
          }
        }
        // If the actual lengths are not equal, then they are not same number
        else
          sameNumber = false;
        // If they are same number, check that larger precision equals smaller precision plus number of leading zeroes on left side of array
        if (sameNumber) {
          if (getPrecision() > n.getPrecision()) 
            return getPrecision() == n.getPrecision() + thisFrontIndex2  && getIsNegative() == n.getIsNegative() && getIsReal() == n.getIsReal();
          else
            return getPrecision() + nFrontIndex2 == n.getPrecision() && getIsNegative() == n.getIsNegative() && getIsReal() == n.getIsReal();
        }
        else
          return sameNumber && getIsNegative() == n.getIsNegative() && getIsReal() == n.getIsReal();
      }
      // If input is a whole number
      else if (n instanceof WholeNum) {
        /**
         * Find index's where this number ends in digits indices while ignoring leading zeroes
         * @precondition the input number is a whole number
         */
        int thisBackIndex = getDigits().length - 1;
        boolean thisBackNumFound = false;
        while (!thisBackNumFound && thisBackIndex > -1) {
          if (getDigits()[thisBackIndex] != 0) 
            thisBackNumFound = true;
          else
            thisBackIndex--;
        }
        // Length of this digit array minus leading zeroes
        int thisActualLength = getDigits().length - (getDigits().length - thisBackIndex);
        /**
         * Find index's where n's number ends in digits indices while ignoring leading zeroes
         * @precondition the input number is a whole point number
         */
        int nBackIndex = n.getDigits().length - 1;
        boolean nBackNumFound = false;
        while (!nBackNumFound && nBackIndex > -1) {
          if (n.getDigits()[nBackIndex] != 0)
            nBackNumFound = true;
          else
            nBackIndex--;
        }
        // Length of the input digit array minus leading zeroes
        int nActualLength = n.getDigits().length - (n.getDigits().length - nBackIndex);
        // Default boolean value of equality of numbers
        
        boolean sameNumber = true;
        // If their lengths are the same, then compare contents
        if (thisActualLength == nActualLength) {
          int counter = 0;
          int maxLength = 0;
          if (thisBackIndex > nBackIndex)
            maxLength = thisBackIndex;
          else
            maxLength = nBackIndex;
          int thisFrontIndex = 0;
          int nFrontIndex = 0;
        /**
         * Compare numbers to see if they are the same one digit at a time, stop comparing if they aren't
         * @precondition if input is a whole number
         * @precondition the lengths of both numbers are the same
         */
          while (sameNumber && counter <= maxLength) {
            sameNumber = getDigits()[thisFrontIndex] == n.getDigits()[nFrontIndex];
            if (thisFrontIndex < thisBackIndex) 
              thisFrontIndex++;
            if (nFrontIndex < nBackIndex) 
              nFrontIndex++;
            counter++;
          }
        }
        else
          sameNumber = false;
        return sameNumber && getIsNegative() == n.getIsNegative() 
          && getIsReal() == n.getIsReal();
      }
    }    
    // Default return value
    return false;
  }
  
  /**
   * Add another number to this number, and create a new number
   * @param n The ArbitraryNumber that is being added to this number
   * @return num A new number whose digits array consists of the sum of both digits arrays
   */
  public ArbitraryNumber add(ArbitraryNumber n) {
    if (getIsNegative() != n.getIsNegative())
      throw new UnsupportedOperationException();
    // If both this number and the intput number is a whole number
    if (n instanceof WholeNum && this instanceof WholeNum) {
      // Length of longest digit array
      int longestLength = 0;
      // Last index of nonzero value from right side of longest array
      int lastIndex = 0;
      boolean nonZeroFound = false;
      // Assign length of new digitsArray and last nonZero indices depending on which digits array is longer
      // If this number's digits array's length is greater than the input's digits array's length
      if (getDigits().length > n.getDigits().length) {
        longestLength = getDigits().length + 1;
        lastIndex = getDigits().length - 1;
        /**
         * Find last nonzero digit of this number's digit array
         * @precondition the length of this digits array is greater than the length of the input's digits array
         * @precondition both this number and input number are whole numbers
         */
        while (!nonZeroFound && lastIndex > -1) {
          if (getDigits()[lastIndex] != 0)
            nonZeroFound = true;
          else
            lastIndex--;
        }
      }
      // If the input's digit array's length is greater than the length of this digit's array
      else {
        longestLength = n.getDigits().length + 1;
        lastIndex = n.getDigits().length - 1;
        /**
         * Find last nonzero digit
         * @precondition the length of the input's digits array is greater than the length of this digits array
         * @precondition both this number and input number are whole numbers
         */
        while (!nonZeroFound && lastIndex > -1) {
          if (n.getDigits()[lastIndex] != 0)
            nonZeroFound = true;
          else
            lastIndex--;
        }
      }
      // New digits array that sums will be added to for new number to be generated with
      byte[] newDigits = new byte[longestLength]; 
      // Remainder of sum if sum is greater than 9
      int carry = 0;
      /**
       * sum the indices of this digit's array and the input's digit array, one inex at a time, and append to new digits array
       * @precondition both this number and input number are whole numbers
       */
      for (int i = 0, thisIndex = 0, nIndex = 0; i < longestLength; i++) {
        int sum = 0;
        sum += carry;
        carry = 0;
        if (thisIndex < getDigits().length) {
          sum += getDigits()[thisIndex];
          thisIndex++;
        }
        if (nIndex < n.getDigits().length) {
          sum += n.getDigits()[nIndex];
          nIndex++;
        }
        if (sum > 9) {
          carry = 1;
          sum -= 10;
        }
        newDigits[i] = (byte) sum;
      }
      
      WholeNum num;
      /**
       * Assign this number a new number a type of either real or imaginary, depending on what type this number is
       * @precondition the numbers added to each other will be the same type
       */
      if (getIsReal()) 
        num = new RealWhole(newDigits, getIsNegative());
      else
        num = new ImaginaryWhole(newDigits, getIsNegative());
      
      return num;
    }
    // If either this number or input number is a floating point number
    else if (this instanceof FloatNum || n instanceof FloatNum) {
      // Length of longest digit array
      int longestLength = 0;
      // Last index of nonzero value from right side of longest array
      int lastIndex = 0;
      boolean nonZeroFound = false;
      // Calculate length of longest digit array and index of first nonzero from right side of array depending on which digits array is longer
      if (getDigits().length > n.getDigits().length) {
        longestLength = getDigits().length + 1;
        lastIndex = getDigits().length - 1;
        /**
         * Find last nonzero digit of this number's digit array
         * @precondition the length of this digits array is greater than the length of the input's digits array
         * @precondition either this number or input number is a floating number
         */
        while (!nonZeroFound && lastIndex > -1) {
          if (getDigits()[lastIndex] != 0)
            nonZeroFound = true;
          else
            lastIndex--;
        }
      }
      else {
        longestLength = n.getDigits().length + 1;
        lastIndex = n.getDigits().length - 1;
        /**
         * Find last nonzero digit of this number's digit array
         * @precondition the length of the input's digits array is greater than the length of this digits array
         * @precondition either this number or input number is a floating number
         */
        while (!nonZeroFound && lastIndex > -1) {
          if (n.getDigits()[lastIndex] != 0)
            nonZeroFound = true;
          else
            lastIndex--;
        }
      }
      // Precision of new number
      int newPrecision = 0;
      // Assign new precision the greatest precision of either numbers
      // If this precision is greater than input's precision
      if (getPrecision() > n.getPrecision())
        newPrecision = getPrecision();
      // If the input precision is greater this precision
      else
        newPrecision = n.getPrecision();
      // Create array of digits for new number
      byte[] newDigits = new byte[newPrecision + longestLength];
      // Add digit array elements of number with greatest precision 
      int i = 0;
      // If this precision is greater than the input's precision
      if (getPrecision() > n.getPrecision()) {
        /**
         * Assign elements of newDigits the elements of this digits array
         * @precondition this precision is greater than the input's precision
         * @precondition either this number or input number is a floating number
         */
        while (i < getDigits().length) {
          newDigits[i] = getDigits()[i];
          i++;
        }
      }
      // If the input precision is greater than this precision
      else {
        /**
         * Assign elements of newDigits the elements of the input's digits array
         * @precondition the input's precision is greater than the this precision
         * either this number or input number is a floating number
         */
        while (i < n.getDigits().length) {
          newDigits[i] = n.getDigits()[i];
          i++;
        }
      }
      
      // Add digit array elements of number with smaller precision
      // Remainder of sum if sum is greater than 9
      int carry = 0;
      // If the input's precision is smaller than this precision
      if ( n.getPrecision() < getPrecision()) {
        /**
         * Add elements of the input's digit arrays one array at a time, beginning at the index equal to the input's precision
         * @precondition the input's precision is smaller than this precision
         */
        for (int j = newPrecision - n.getPrecision(), nIndex = 0; j < newPrecision + longestLength; j++) {
          int sum = 0;
          sum += carry;
          carry = 0;
          if (nIndex < n.getDigits().length) {
            sum += n.getDigits()[nIndex];
            nIndex++;
          }
          sum += newDigits[j];
          if (sum > 9) {
            carry = 1;
            sum -= 10;
          }
          newDigits[j] = (byte) sum;
        }
      }
      // If this precision is greater than or equal to input's precision
      else {
        /**
         * Add elements of thos digit arrays one array at a time, beginning at the index equal to this precision
         * @precondition this precision is smaller than the input's precision
         */
        for (int j = newPrecision - getPrecision(), thisIndex = 0; j < newPrecision + longestLength; j++) {
          int sum = 0;
          sum += carry;
          carry = 0;
          if (thisIndex < getDigits().length) {
            sum += getDigits()[thisIndex];
            thisIndex++;
          }
          sum += newDigits[j];
          if (sum > 9) {
            carry = 1;
            sum -= 10;
          }
          newDigits[j] = (byte) sum;
        }
      }
      
      FloatNum num;
      /**
       * Assign this number a new number a type of either real or imaginary, depending on what type this number is
       * @precondition the numbers added to each other will be the same type
       */
      if (getIsReal())
        num = new RealFloat(newDigits, getIsNegative(), newPrecision);
      else
        num = new ImaginaryFloat(newDigits, getIsNegative(), newPrecision);
      return num;
    }
   // Default return value
   return null;
  }
  
}