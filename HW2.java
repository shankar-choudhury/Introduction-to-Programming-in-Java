// Shankar Choudhury
// This class is the entire HW2 that contains different methods that take strings
public class HW2 {

  // Creates a new string that capitalizes the first letter of every sentence
  public static String capitalizeSentences(String s) {
    StringBuilder newString = new StringBuilder();// New string to append to 
    boolean capitalize = true; // If char is first letter of sentence and lower case
    
    // Loop to go through string s one char at a time, and append characters to newString
    for(int i = 0; i < s.length(); i++) {
      // Check if letter is upper case and first letter of sentence
      if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') && capitalize) {
        capitalize = false; // Next letter is not first letter of sentence, so not capitalizing said letter
        newString.append(s.charAt(i));
      }
      
      // Check if letter is lower case and first letter of sentence
      else if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') && capitalize) { 
        capitalize = false; // Next letter is not first letter of sentence, so not capitalizing them
        newString.append((char)(s.charAt(i) - 32)); // Make letter upper case
      }
      
      // Check if char is a '.', '!', or '?' which implies end of sentence 
      else if(s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?') {
        capitalize = true; // We are at end of sentence, so first letter encountered will be first letter of next sentence
        newString.append(s.charAt(i));
      }
      
      else
        newString.append(s.charAt(i));
    }
    // Return new string
    return newString.toString();
  }
  
  // Reads if characters in sequence are in same order as they first appear in string
  public static boolean subSequence(String sequence, String string) {
    int stringIndex = 0; // Place in string comparison begins at
    boolean isSubSequence = false; // Final truth value of whether sequence is subsequence of string or not
    
    // Find where char in sequence first appears in string
    for(int j = 0; j < sequence.length(); j++) {
      boolean found = false; // If letter found, we stop looking through string
      
      // Look through string for char in sequence 
      while(!found && stringIndex < string.length()) {
        // Update method variables if letter in string that is same as current char of sequence is found
        if (string.charAt(stringIndex) == sequence.charAt(j)) {
          found = true; // Indicate letter was found so that we look for next letter of sequence in string
        }
        stringIndex++;
      }
      // Update statues of whether sequence is subsequence of string or not
      isSubSequence = found;
    }
    
    return isSubSequence;
  }
  
  // Removes extra spaces in string
  public static String removeExtraSpaces(String s) {
    StringBuilder newString = new StringBuilder(); // New string with no extra spaces
    int stringIndex = 0; // Index in input string
    boolean appendSpace = false; // Let us know that we need to append a space after char
    
    // Go through string
    while(stringIndex < s.length()) {
      int lookingIndex = stringIndex; // Index in string to begin looking for next char if we're inserting a space between words
      
      // Append character if not a space
      if (s.charAt(stringIndex) != ' ') {
        newString.append(s.charAt(stringIndex));
        appendSpace = true; // Will append a space  to newString after char if space is encountered
      }
      // Append the space char only if there is another char later on 
      else if(s.charAt(stringIndex) == ' ' && appendSpace) {
        boolean lookForChar = true; // Look for char is a go
        
        // Look for another non-space while staying in bounds of string
        while(lookForChar && lookingIndex < s.length()) {
          // If non-space char is found, then append a space at stringIndex
          if(s.charAt(lookingIndex) != ' ') {
            lookForChar = false; // Turn off search because we found a non-space char
            newString.append(s.charAt(stringIndex)); // Append char to newString
          }
          // If non-space char is not found, increment to keep looking
          else
            lookingIndex++;
        }
        // Reset appendSpace since we won't append another space after one space
        appendSpace = false;
      }
                 
      // Look at next char                   
      stringIndex++;
    }
    
    return newString.toString();
  }
  
  // Find a word from wordList in string s
  public static boolean containsWord(String s, String wordList) {
    
    int wordCount = 0; // Number of words in wordList
    // Count words in wordList
    for (int i = 0; i < wordList.length(); i++) {
      if(wordList.charAt(i) != ' '){
        wordCount++;
        // Skip ahead to index with space to look for next word
        while (wordList.charAt(i) != ' ' && i < wordList.length() - 1) {
            i++;
        }
      }
    }
    
    boolean isWord = false; // Final value to return if word in wordlist was found in string s
    boolean wordFound = false; // Value to indicate when word has been found in wordList
    boolean lookForEndOfWord = false; // Value to indicate whether we look for last char of word
    int wordListIndex = 0; // Place in wordList
    int wordBeginsIndex = 0; // Place where word begins 
    int wordEndsIndex = 0; // Place where word ends
    
    // Look for each word in wordList in string s, if found then break out of loop
    for (int i = 0; i < wordCount && !isWord; i++) {
      
      // Look through wordList and find where word begins and ends 
      while (wordListIndex < wordList.length() && !wordFound) {
        // If char found, record where it was found and then look for end of word
        if(wordList.charAt(wordListIndex) != ' ' && !lookForEndOfWord) {
          lookForEndOfWord = true;
          wordBeginsIndex = wordListIndex;
        }
        // If space is found, record last char as index where word ends, and stop looking for end of word
        if(wordList.charAt(wordListIndex) == ' ' && lookForEndOfWord) {
          lookForEndOfWord = false;
          wordFound = true;
          wordEndsIndex = wordListIndex - 1;
        }
        // If word goes until at end of wordList
        else if (wordListIndex + 1 == wordList.length() && lookForEndOfWord) {
          lookForEndOfWord = false;
          wordFound = true;
          wordEndsIndex = wordListIndex;
        }
        wordListIndex++;
      }
      
      wordFound = false; // Reset wordFound so we can find index of next word in wordList on iteration to look for next word in s
      
      boolean isMatch = false; /* If current word in wordlist matches series of chars in string, 
                                  then this is true and updates isWord accordingly */
      int stringIndex = 0; // Place in String, reset to 0 if looking for next word in wordList
      // Look for word in string s compared to word in wordList one char at a time
      for (int j = wordBeginsIndex; j <= wordEndsIndex; j++) {
        boolean off = false; // Trigger to turn off looking through string s if word is found
        // Look through string s
        while (stringIndex < s.length() && !off) {
          // If char of string s matches char of current word, advance to the next char in word, stop looking for current char, and update isMatch
          if (wordList.charAt(j) == s.charAt(stringIndex)) {
            off = true;
            isMatch = true; 
          }
          else 
            isMatch = false;
          stringIndex++;
        }
        isWord = isMatch; // Update truth value of isWord
      }
    }
    
    System.out.println(wordBeginsIndex);
    System.out.println(wordEndsIndex);
    return isWord;
  }
  
  // Search for words of wordList in array of strings called board
  public static String wordSearch(String[] board, String wordList) {
    StringBuilder wordsFound = new StringBuilder(); //  
    int wordCount = 0; // Number of words in wordList
    // Count words in wordList
    for (int i = 0; i < wordList.length(); i++) {
      if(wordList.charAt(i) != ' '){
        wordCount++;
        // Skip ahead to index with space to look for next word
        while (wordList.charAt(i) != ' ' && i < wordList.length() - 1) {
            i++;
        }
      }
    }
    
    // Variables used to determine beginning and ending indixes of current word in wordList
    boolean wordFound = false; // Value to indicate when word has been found in wordList
    boolean lookForEndOfWord = false; // Value to indicate whether we look for last char of word
    int wordListIndex = 0; // Place in wordList
    int wordBeginsIndex = 0; // Place where word in wordList begins 
    int wordEndsIndex = 0; // Place where word in wordList ends
    
    // Look for word of wordList in board one word at a time
    for (int i = 0; i < wordCount; i++) {
      // Look through wordList and find where current word begins and ends 
      while (wordListIndex < wordList.length() && !wordFound) {
        // If char found, record where it was found and then look for end of word
        if(wordList.charAt(wordListIndex) != ' ' && !lookForEndOfWord) {
          lookForEndOfWord = true;
          wordBeginsIndex = wordListIndex;
        }
        // If space is found, record last char as index where word ends, and stop looking for end of word
        if(wordList.charAt(wordListIndex) == ' ' && lookForEndOfWord) {
          lookForEndOfWord = false;
          wordFound = true;
          wordEndsIndex = wordListIndex - 1;
        }
        // If word goes until at end of wordList
        else if (wordListIndex + 1 == wordList.length() && lookForEndOfWord) {
          lookForEndOfWord = false;
          wordFound = true;
          wordEndsIndex = wordListIndex;
        }
        wordListIndex++;
      }
      
      wordFound = false; /* Reset wordFound so we can find index of next word in wordList on next 
                          * iteration to look for next word in board */
      // Look for current word of wordList in string of board one board index at a time
      for (int j = 0; j < board.length; j++) {
        // Go through words in string and compare each word to current word of wordList
        boolean isMatch = false; // Value whether word read in string of current board index matches current wordList word
        boolean isMatch2 = false; // 
        // Look through string at current board index and look for 
        for(int k = 0; k < board[j].length(); k++) {
          // Loop through current word in wordList and compare  word in string of current board index
          for(int l = wordBeginsIndex; l <= wordEndsIndex; l++) {
            if(wordList.charAt(l) == board[j].charAt(k))
              isMatch = true;
            else
              isMatch = false;
          }
          // Loop through current word in wordList backwards and 
          for (int l = wordEndsIndex; l >= wordBeginsIndex; l--) {
            if(wordList.charAt(l) == board[j].charAt(k))
              isMatch2 = true;
            else
              isMatch2 = false;
          }
        }
        for (int l = wordBeginsIndex; l <= wordEndsIndex && isMatch; l++){
          wordsFound.append(wordList.charAt(l));
        }
        for (int l = wordEndsIndex; l >= wordBeginsIndex && isMatch2; l--){
          wordsFound.append(wordList.charAt(l));
        }
      } 
      wordsFound.append(' ');
    }
    return wordsFound.toString();
  }
    
}