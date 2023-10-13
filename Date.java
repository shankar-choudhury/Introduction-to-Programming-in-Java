// Shankar Choudhury
// This class represents the date
public class Date {

  // Day of Month (numbers 1 - 31)
  private int day = 0;
  // Month (numbers 1 - 12)
  private int month = 0;
  // Year (numbers 1 - 2022)
  private int year = 0;
  // Boolean value to signal whether writtenDate is in US format, initialized to be false
  private boolean usaFormat = false;  
  
  // Constructor for date, have conditions to ensure valid date for each month, and to assign month name
  // If invalid date is inputted, then values remain as 0
  public Date (int day, int month, int year){
    // Check for valid year, month, and day inputs
    if ((year >= 1 && year <= 2022) && (month >= 1 && month <= 12) && (day >= 1 && day <= 31)){
      // Months January (1), March(3), May(5), July(7), August (8), October(10), and December (12) have 31 days 
      if ((month == 1 || month == 3 || month == 5 || month == 7 
             || month == 8 || month == 10|| month == 12)){
        this.year = year;
        this.month = month;
        this.day = day;  
      }
      // Feburary has max 28 days
      else if (month == 2 && day <= 28){
        this.year = year;
        this.month = month;
        this.day = day;
      }
      // April, June, September, and November have 30 days
      else if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30){
        this.year = year;
        this.month = month;
        this.day = day;
      }
    }
  }
  
  // Enum 
  public enum Month {
    JAN(31), FEB(28), MAR(31), APR(30), MAY(31), JUN(30), JUL(31), AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);
    
    int maxDaysInMonth;
    // Constructor to set maximum days in each month
    Month(int maxDaysInMonth) {
      this.maxDaysInMonth = maxDaysInMonth;
    }
    // Return maximum days in each month
    public int getMaxDay() {
      return maxDaysInMonth;
    }
    public int dayOfYear() {
      // Use constructor
      return 0;
    }
  }
  
  // Accessor methods
  // Return day
  public int getDay(){
    return day;
  }
  
  // Return month
  public int getMonth(){
    return month;
  }
  
  // Return year 
  public int getYear(){
    return year;
  }
  
  // Return if date is in US format
  public boolean isUSFormat(){
    return usaFormat;
  }
  
  // Set US Format for written d
  public void setUSFormat(boolean usaFormat){
    this.usaFormat = usaFormat;
  }
  
  // Class Methods
  // Return difference in number of days from this Date to Jan 1 of same year 
  public int daysFromJan1(){
    // Multipliers for number of months with those days
    // Multiplier of # of months with 28 days (max 1)
    int febDaysMult = 0;
    // Multiplier of # of months with 31 days (max 7); January, March, May, July, August, October, and December 
    int days31Mult = 0;
    // Multiplier of # of months with 30 days (max 4); April, June, September, and November
    int days30Mult = 0;
    // # of days in Febrauary
    int febDays = 28;
    // # of days in month w/ 31 days
    int days31 = 31;
    // # of days in month w/ 30 days
    int days30 = 30;
    
    // Cases depending on what the month is, alters  multipliers accordingly
    if (month == 2) {
      febDaysMult = 0;
      days31Mult = 1;
      days30Mult = 0;
    }
    else if (month == 3){
      febDaysMult = 1;
      days31Mult = 1;
      days30Mult = 0;
    }
    else if (month == 4){
      febDaysMult = 1;
      days31Mult = 2;
      days30Mult = 0;
    }
    else if (month == 5){
      febDaysMult = 1;
      days31Mult = 2;
      days30Mult = 1;
    }
    else if (month == 6){
      febDaysMult = 1;
      days31Mult = 3;
      days30Mult = 1;
    }
    else if (month == 7){
      febDaysMult = 1;
      days31Mult = 3;
      days30Mult = 2;
    }
    else if (month == 8){
      febDaysMult = 1;
      days31Mult = 4;
      days30Mult = 2;
    }
    else if (month == 9){
      febDaysMult = 1;
      days31Mult = 5;
      days30Mult = 2;
    }
    else if (month == 10){
      febDaysMult = 1;
      days31Mult = 5;
      days30Mult = 3;
    }
    else if (month == 11){
      febDaysMult = 1;
      days31Mult = 6;
      days30Mult = 3;
    }
    else if (month == 12){
      febDaysMult = 1;
      days31Mult = 6;
      days30Mult = 4;
    }
    /* Formula to determine total days from beginning of year to listed day date minus one 
     * to account for first day inclusive */
    return getDay() + febDays*febDaysMult + days31*days31Mult + days30*days30Mult - 1;
  }
  
  // Return difference in days between two dates
  public static int difference(Date date1, Date date2){
    /* Calculate difference between dates after converting each date to number of days passed since year 0, 
     * including the first day */
    // Days in year
    int daysYear = 365;
    return (date1.daysFromJan1() + 1 + daysYear * date1.getYear()) - 
      (date2.daysFromJan1() + 1 + daysYear * date2.getYear());
  }
  
  // Overridden methods of Object
  // Override toString so that it returns written date
  @Override
  public String toString(){
    // Name of month
    String monthName = null;
    // Assign appropriate name of month corresponding to month date
    if (month == 1)
      monthName = "January";
    else if (month == 2)
      monthName = "February";
    else if (month == 3)
      monthName = "March";
    else if (month == 4)
      monthName = "April";
    else if (month == 5)
      monthName = "May";
    else if (month == 6)
      monthName = "June";
    else if (month == 7)
      monthName = "July";
    else if (month == 8)
      monthName = "August";
    else if (month == 9)
      monthName = "September";
    else if (month == 10)
      monthName = "October";
    else if (month == 11)
      monthName = "November";
    else if (month == 12)
      monthName = "December";

    if (isUSFormat() == true) 
      return monthName + " " + getDay() + ", " + getYear();
    else 
      return getDay() + " " + monthName + " " + getYear();
  }
  
  // Override equals so that two dates are equal only if their day, month, and year are equal
  @Override 
  public boolean equals(Object o){
    // First check if o is a date, use "instanceof" to ask if we can typecast 
    if (o instanceof Date) {
      // Create copy of Object o for comparison's sake
      Date d = (Date) o;
      // Return truth value of whether o is the same as what it is being compared to
      return this.getDay() == d.getDay() && this.getMonth() == d.getMonth() && this.getYear() == d.getYear();
    }
    // Initialized return value
    return false;
  }
}
        
      
      
