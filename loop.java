//Shankar Choudhury pre-lab 5
//This class calculates the sum of the first 10 positive integers
public class loop {

  public int whileLoop() {
    // Store calculated amount
    int x = 0;
    int y = 0;
    while (x < 10) {
      x += 1;
      y += x;
    }
    return y;
  }
  
  public int forLoop() {
    int y = 0;
    for(int x = 0; x < 11; x++)
      y += x;
    return y;
  }
      
}