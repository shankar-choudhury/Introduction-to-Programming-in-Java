import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;

/**
 * A window with a text area that works as a simple text editor.
 * @author Shankar Choudhury
 * @author Connor Fant
 */
public class Lab9JFrame extends JFrame {

  /** Text area, in the center. */
  private JTextArea textArea;

  /**
   * Create a window with a 40x80-character text area in the center.
   */
  public Lab9JFrame() {
    // Create the text area.
    this.textArea  = new JTextArea("An Editor Window", 40, 80); // 40 lines high, 80 chars wide.

    // Add the text area to this window.
    this.getContentPane().add(this.textArea, "Center");
    
    // Set the window size to automatically fit the center text area
    this.pack();
  }
  
  /**
   * Returns the text area of the window
   * @return the text area of the window
   */
  public JTextArea getTextArea() {
    return textArea;
  }
  
  public void fileDisplay(String s) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(s));
    textArea.setText("");
    for (int i = 0; i < textArea.getLineCount(); i++) {
      textArea.append(br.readLine());
      textArea.append("\n");
    }
  }
}
