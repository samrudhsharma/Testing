// Implementation of the Triangulation Method
// The only spec given is that it is a method that breaks words in the specified space with a new line. Like a word processor would.
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordWrapTest {
  public static final int LINE_LENGTH =5;
  
  // If a line is bigger than our specified line length, it should require a new line
  @Test
  public void lineShouldWrapIfOverLineLength() {
	String result = WordWrap.wrap("The Sleepy", LINE_LENGTH);
	assertEquals("The S\nleepy", result);
  }
  
  // A second test to check if lines under the specified line length are affected by the implementation
  @Test
  public void shortLinesShouldNotWrap() {
	String result = WordWrap.wrap("The", LINE_LENGTH);
    assertEquals("The", result);
  }
  
  // If a line is much larger than our specified line length, it should require 2 new line
  @Test
  public void longerLineShouldWrapTwice() {
	String result = WordWrap.wrap("The Sleepy Brow", LINE_LENGTH);
	assertEquals("The S\nleepy\n Brow", result);
  }
  
  // If a line is much larger than our specified line length, it should require 2 new line
  @Test
  public void evenLongerLineShouldWrapThrice() {
	String result = WordWrap.wrap("The Sleepy Brown Fox", LINE_LENGTH);
	assertEquals("The S\nleepy\n Brow\nn Fox", result);
  }
  
  @Test
  public void longLineDontHaveToBeAMultipleOfLineLength() {
	String result = WordWrap.wrap("The Sleepy Brown Fox.", LINE_LENGTH);
	assertEquals("The S\nleepy\n Brow\nn Fox\n.", result);
  }
}
