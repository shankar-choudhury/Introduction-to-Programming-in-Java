//// This class tests all methods in HW2
import org.junit.Test;
import static org.junit.Assert.*;

public class HW2Tester {
  
  @Test
  public void testCapitalizeSentences() {
    // Test of string length  of 0
    assertEquals("", HW2.capitalizeSentences(""));
    // Test of string length of 1
    assertEquals("As.D", HW2.capitalizeSentences("as.d"));
    // Test of strings made of many sentences
    assertEquals("     A  sS123. S!D?Da W, a. D", HW2.capitalizeSentences("     a  sS123. s!D?da W, a. d"));
    assertEquals(" A!! Dd?? Fc.....     Ggggg.H", HW2.capitalizeSentences(" a!! dd?? fc.....     ggggg.h"));
    
    // Test if first letter of first sentence is capitalized 
    assertEquals("Aa. 123, 12", HW2.capitalizeSentences("aa. 123, 12"));
    // Test if first letter of middle sentence is capitalized
    assertEquals("12. Bbb, 12", HW2.capitalizeSentences("12. bbb, 12"));
    // Test if first letter of last sentence is capitalized
    assertEquals("12. 123. Cc", HW2.capitalizeSentences("12. 123. cc"));
  }
  
  @Test
  public void testSubSequence() {
    // Test of sequence length of 0 
    assertEquals(false, HW2.subSequence("", "asdj"));
    // Test of string length of 0
    assertEquals(false, HW2.subSequence("sa", ""));
    // Test of sequence length of 1
    assertEquals(true, HW2.subSequence("a", "sdaj"));
    // Test of string length 1
    assertEquals(false, HW2.subSequence("a", "s"));
    // Test of sequence length of many characters
    assertEquals(true, HW2.subSequence("ab!col4te", "abo! ut chocol4ate"));
    assertEquals(false, HW2.subSequence("ab!col4tez", "abo! ut chocol4ate"));
    // Test of string length of many characters
    assertEquals(true, HW2.subSequence("?a-?a$%", "pneum1on?oultra scop--icsi,,!??lico volca#$noco niosis%"));
    assertEquals(true, HW2.subSequence("abc", "acorn abound corn at a axlotl"));
    assertEquals(false, HW2.subSequence("def", "diffuse a bomb tonight"));
    
    // Test if sequence is found at beginning of string
    assertEquals(true, HW2.subSequence("hle", "halloween is spooky"));
    // Test if sequence is found in middle of string
    assertEquals(true, HW2.subSequence("sn't", "Christmas isn't spooky"));
    // Test if sequence is found at end of string
    assertEquals(true, HW2.subSequence("yce", "Cutting meat off the bone is really nice."));
  }
  
  @Test
  public void testRemoveExtraSpaces() {
    // Test of string with length 0
    assertEquals("", HW2.removeExtraSpaces(""));
    // Test of string with length 1
    assertEquals("h", HW2.removeExtraSpaces("h"));
    // Test of string with many sentences and words
    assertEquals("I had a good day making this test report work. Did you have fun grading my project ?", HW2.removeExtraSpaces("                I had a good day          making this test             report          work. Did                        you have fun grading my            project  ?"));
    
    // Test removing extra spaces from beginning of string
    assertEquals("hello", HW2.removeExtraSpaces("          hello"));
    // Test removing extra spaces from middle of string
    assertEquals("hel lo", HW2.removeExtraSpaces("hel      lo"));
    // Test removing extra spaces from end of string
    assertEquals("hello", HW2.removeExtraSpaces("hello             "));
  }
  
  @Test
  public void testContainsWord() {
    // Test of string with length 0
    assertEquals(false, HW2.containsWord("", ""));
    assertEquals(false, HW2.containsWord(" ", " "));
    assertEquals(false, HW2.containsWord("", "a"));
    // Test of wordList with length 0
    assertEquals(false, HW2.containsWord("asd", ""));
    assertEquals(false, HW2.containsWord("asd ", " "));
    // Test of string with length 1
    assertEquals(true, HW2.containsWord("hello", "hello"));
    assertEquals(true, HW2.containsWord("hello,", "hello"));
    assertEquals(true, HW2.containsWord("hello,", ","));
    assertEquals(false, HW2.containsWord("hello", "god by"));
    assertEquals(false, HW2.containsWord("Violence", "hi kids, do you    like   violence"));
    // Test of wordList with length 1
    assertEquals(true, HW2.containsWord("          Hello grader,   hope        you like this test report", "Hello"));
    assertEquals(true, HW2.containsWord("          Hello grader,   hope        you like this test report", "his"));
    assertEquals(false, HW2.containsWord(" we love the weekend", "Weekend"));
    assertEquals(false, HW2.containsWord("We dont like you", "ew"));
    // Test of string and wordList with many strings
    assertEquals(true, HW2.containsWord("hasldhashkd haslkaldaldl    uqwdijnklc8u12e8009uq2e9u uqwd  awdy w dy      1231,", "kal qw 7799 hashgd"));
    assertEquals(false, HW2.containsWord("hi kids, do you like voilence? Wanna see me rap eminem though this program ad nauseum?", "123ujjj 90812903801 ()_1248-"));
    assertEquals(false, HW2.containsWord("hi kids, do you like voilence? Wanna see me rap eminem though this program ad nauseum?", "h1i ki1ds, d1o yo1u l1ike voile1nce? W1anna se1e m1e r1ap emin1em tho1ugh t1is pro1gram a1d n1auseum?"));
    
    // Test of wordList with word at beginning of string
    assertEquals(true, HW2.containsWord("Please         give me a gre      ate grade!", "ease"));
    // Test of wordList with word at middle of string
    assertEquals(true, HW2.containsWord("Please         give me a gre      ate grade!", "ive"));
    // Test of wordList with word at end of string
    assertEquals(true, HW2.containsWord("Please         give me a gre      ate grade!", "de"));
  }
  
  @Test // Test wordSearch with different boards and wordLists
  public void testWordSearch() {
    String[] zeroBoard = new String[0];
    String emptyWordList = "";
  
    String[] shortBoard = new String[1];
    shortBoard[0] = "hello";
    String shortWordList = "hello";
    String shortWordList2 = "hel";
    String shortWordList3 = "olleh";
    String shortWordList4 = "oll";
  
    String[] medBoard = new String[3];
    medBoard[0] = "hello";
    medBoard[1] = "good";
    medBoard[2] = "bye";
    String medWordList = "hello good bye doog";
    String medWordList1 = "hello goodbye eyb olleh";
    String medWordList2 = "llo oo ye";
  
    String[] longBoard = new String[5];
    longBoard[0] = "Case Boulevard Glass";
    longBoard[1] = "Western yellow Blue";
    longBoard[2] = "Reserve black ^&^D ss";
    longBoard[3] = "University ()()()0909090";
    longBoard[4] = "Cleveland, OH ugh this project took so long! make the next one easier please!";
    String longWordList = "ase stern serve sity land , OH";
    String longWordList2 = "ase esa nret res vres";
    String longWordList3 = "c w r u c";
    String longWordList4 = "C W R U C";
    String longWordList5 = "Case Boulevard Glass yellow ^&^ 090 ugh reisea HO";
    
    // Test of board and wordList of length 0
    assertEquals("", HW2.wordSearch(zeroBoard, emptyWordList));
    // Test of board and wordList of length 1
    assertEquals("hello", HW2.wordSearch(shortBoard, shortWordList));
    assertEquals("hel", HW2.wordSearch(shortBoard, shortWordList2));
    assertEquals("olleh", HW2.wordSearch(shortBoard, shortWordList3));
    assertEquals("oll", HW2.wordSearch(shortBoard, shortWordList4));
    // Test of board and wordList of medium length
    assertEquals("hello good bye doog", HW2.wordSearch(medBoard, medWordList));
    assertEquals("hello eyb olleh", HW2.wordSearch(medBoard, medWordList1));
    assertEquals("llo oo ye", HW2.wordSearch(medBoard, medWordList2));
    // Test of board and wordList with many words
    assertEquals("ase stern serve sity land , OH", HW2.wordSearch(longBoard, longWordList));
    assertEquals("ase esa nret res vres", HW2.wordSearch(longBoard, longWordList2));
    assertEquals(" ", HW2.wordSearch(longBoard, longWordList3));
    assertEquals("C W R U C", HW2.wordSearch(longBoard, longWordList4));
    assertEquals("Case Boulevard Glass yellow ^&^ 090 ugh reisea HO", HW2.wordSearch(longBoard, longWordList4));
  } 
 
 
}