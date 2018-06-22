
public class WordWrap {

  public static String wrap(final String inputLine, final int lineLength) {
	// The first implementation of the word wrapper executes the first test which simply checks if after a specified line length the input string has been 
	// added to a new line. This is done by using a string builder, adding in it the characters of the input string from the start upto the specified line length
	// adding a new line and the continuing adding the rest
	  
	// The second implementation executes the second test of checking if lines shorter that the specified length get affected 
	// This is done by using Math.min(inputLine.length(), lineLength) to break the line at what ever value is smaller out of the two
	// And also including a conditional statement to add the line break only if the line length is smaller than the specified length to break at
	final StringBuilder accumulator = new StringBuilder();
	final int length = inputLine.length(); 
	accumulator.append(inputLine, 0, Math.min(length, lineLength));
	// Test case 1, 2 &3
//	if(length > lineLength) {
//	  accumulator.append("\n");
//	  accumulator.append(inputLine, lineLength, length);
//	}
	
//	// To implement the test case of what happens when we have a line more than twice the specified length
//	// We do this by using a variable split with initially its value being the specified line length, adding in the string builder upto there
//	// adding a new line. Then doubling the split var value to focus on the other half the string that has'nt been added to the string builder. 
//	int split = lineLength;
//	if(length > split ) {
//	  accumulator.append("\n");
//	  accumulator.append(inputLine, split, split + lineLength);
//	}
//	split += lineLength;
//	if(length > split) {
//	  accumulator.append("\n");
//	  accumulator.append(inputLine, split, length);
//	}
	
	// Now to implement for n Lines
	// We simply use a while loop with the condition length > split, as we can see that this is the main condition for both if conditions
	// We can also see that the loop incrementor required would be split += lineLength
	// But to accommodate for lines that are not multiples of line length we use Math.min(length, split + lineLength) to make sure that towards the end of the line
	// if the no of characters is not a multiple of lineLength we use the length of the string to complete the string builder
	int split = lineLength;
	while(length > split ) {
	  accumulator.append("\n");
	  accumulator.append(inputLine, split, Math.min(length, split + lineLength));
	  split += lineLength;
	}
	
	
	
	
	return accumulator.toString();
  }
}
