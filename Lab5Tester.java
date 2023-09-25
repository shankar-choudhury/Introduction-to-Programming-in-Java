// This class tests everything "with a single click"
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Lab5Tester {
  
  @Test
  public void testCountSpaces() {
    assertEquals(3, Lab5.countSpaces("I love you daddy"));
    assertEquals(4, Lab5.countSpaces(" I love you Connor"));
    assertEquals(0, Lab5.countSpaces("I"));
    assertEquals(13, Lab5.countSpaces("I          love you daddy "));
  }

  @Test
  public void testRemoveSpaces() {
    assertEquals("This Test Failed Failed", "Hellofather,Ihateyou.", Lab5.removeSpaces("Hello father, I hate you."));
    assertEquals("Hellofather,Ihateyou.", Lab5.removeSpaces(" Hello father, I hate you."));
    assertEquals("Hellofather,Ihateyou.", Lab5.removeSpaces("Hello father, I hate you. "));
    assertEquals("Hellofather,Ihateyou.", Lab5.removeSpaces("Hello father             , I hate you."));
  }
  
  @Test
  public void testEveryNthChar(){
    assertEquals("LvC", Lab5.everyNthChar("ILoveCS", 2));
  }
  
    
  
}