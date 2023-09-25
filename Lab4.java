public class Lab4 {
  // Find numbers that are between smallest and greatest input values
  public static double maxDouble(double x, double y, double z) {
    if ((x > y && x < z) || (x > z && x < y))
      return x;
    else if ((y > x && y < z) || (y > z && y < x))
      return y;
    else if ((z > x && z < y) || (z > y && z > x))
      return z;
    else
      return 0;
  }
  
  // Return the value that is rounded up to next int if decimal is more than .5
  public static int roundDouble (double value) {
    return (int)(value + .5); // Add .5 to double value, making it >= next whole current value, and then typecast to int so it rounds down again.
  }
  // Return unbiased rounding of value
  public static int unbiasedRound (double value) {
    // If value is even, round down
    if ((int)(value) % 2 == 0)
      return (int)(value - .5);
    // If value is odd, round up
    else 
      return (int)(value + .5);
  }
  
  /**
   * Return true of the given date/time is daylight savings.
   * Daylight savings time begins 2am the second Sunday of March and ends 2am the first Sunday of November.
   *
   * @param month - represents the month with 1 = January, 12 = December
   * @param date - represents the day of the month, between 1 and 31
   * @param day -  represents the day of the week with 1 = Sunday, 7 = Saturday
   * @param hour - represents the hour of the day with 0 = midnight, 12 = noon
   *
   * Precondition: the month is between 1 and 12, the date is between 1 and 31, the day is between 1 and 7
   *                and the hour is between 0 and 23.
   */  
  public static boolean isDayLightSavings(int month, int date, int day, int hour) {
    if (month == 1 || month == 2 || month == 12)
      return true;
    else if (month == 4 || month == 5 || month == 6 || month == 7 || month == 8 || month == 9 || month == 10)
      return false;
    else if (month == 11) {
      if (date <= 1 && day == 1 && hour < 2)
        return true;
      else
        return false;
    }
    else if (month == 3) {
      if (date >= 8 && day >= 1 && hour >= 2)
        return true;
      else
        return false;
    }
    else
      return false;
  }
    

}