public class Lab5 {
  public static int countSpaces(String s) {
    int numSpace = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ')
        numSpace++;
    }
    
    return numSpace;
  }
  
  public static String removeSpaces(String s) {
    StringBuilder newString = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ')
        newString.append(s.charAt(i));
    }
    return newString.toString();
  }
  
  public static String everyNthChar(String s, int n) {
    StringBuilder newString = new StringBuilder();
    boolean appendSpace = true;
    for (int i = 0; i < s.length(); i++) {
      // check to see if we're near end of string, if so then we won't append space
      if (i + n > s.length())
        appendSpace = false;
      // append every n'th char
      if (i % n == 0) {
        newString.append(s.charAt(i));
        if (appendSpace)
          newString.append(' ');
      } 
    }
    
    return newString.toString();
  }
  
  public static String allDigits(int i) {
    StringBuilder newString = new StringBuilder();
    boolean appendSpaceComma = true;
    
    while (i/10 != 0 && appendSpaceComma) {
      newString.append(i % (i/10));
      i = i/10;
      if (i/10 == 0)
        appendSpaceComma = false;
      if(appendSpaceComma)
        newString.append(", ");
    }
    return newString.toString();
  }
    
                         
}