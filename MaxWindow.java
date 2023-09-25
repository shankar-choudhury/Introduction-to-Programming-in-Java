import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;


public class MaxWindow extends JFrame {
  Toolkit kit = Toolkit.getDefaultToolkit();
  Dimension d = kit.getScreenSize();
  
  private boolean heightMaximized = false;
  private int originalHeight = 0;
  private boolean widthMaximized = false;
  private int originalWidth = 0; 
  private boolean atTop = false;
  private int originalY = 0;
  private boolean atLeft = false; 
  private int originalX = 0;

// This method changes the y-coordinate to 0 to bring it tothe top of the screen
  public void snapToTop() {
    setLocation(getX(), 0);
  }
  
  // This method moves window to left edge of screen
  public void snapToLeft() {
    setLocation(0, getY());
  }
  
  // This method sets the height of the window to be equal to the height of the screen.
  public void maximizeHeight(boolean x) {
                   
    if ( x == true && heightMaximized == false) {
      originalHeight = getHeight();
      setLocation(getX(), 0);
      originalX = getX();
      originalY = getY();
      setSize(getWidth(), d.height);
      heightMaximized = true;
    }
    
    else if (x == false && heightMaximized == true) {
      setSize(getWidth(), originalHeight);
      heightMaximized = false;
      setLocation(originalX, originalY);
    }
  }
  
    // This method moves the window to the left side of the screen
    // and sets the width of the window to be equal to the width of the screen.
  public void maximizeWidth(boolean y) {
    if ( y == true && widthMaximized == false) {
      originalWidth = getWidth();
      setLocation(0, getY());
      setSize(d.width, getHeight());
      widthMaximized = true;
    }
    
    else if (y == false && widthMaximized == true) {
      setSize(originalWidth, getHeight());
      widthMaximized = false;
    }    
  }
}