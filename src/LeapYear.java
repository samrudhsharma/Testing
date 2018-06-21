// The development of the implementation of the code responsible for checking whether a year is a Leap year is done using TDD	
// By first writing a test to check if an input year is divisible by 4 and refactoring the empty class with a simple if statement to implement it 
// Then another test was written to check if non multiple of four years passed the test
// The next condition tested was that leap years are not divisible by 100 and the resulting changes were made to the if statement
// The final condition is that years divisible by 400 are leap years which is checked using a test and finally adding the condition to the function
// The last refactoring step includes the initialisation of a function isDivisible(year, denominator) to get rid of the duplication code in the conditional statement.

public class LeapYear {
  
  public static boolean isLeapYear(final int year) {
	if(isDivisible(year, 4) && (!isDivisible(year, 100)) || isDivisible(year, 400))
	  return true;
	return false;
  }

  private static boolean isDivisible(final int year, final int denominator) {
	return year % denominator == 0;
  }
}
