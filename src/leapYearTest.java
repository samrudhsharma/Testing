// This is an example of TDD development. Where the test has been built first before the implementation of the code that executes it.
// A test to check if an input year is a leap year or not
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class leapYearTest {

  // A year is a leap year if it is divisible by four 
  // but years divisible by 100 are not leap years except years divisible by 400 
  @Test
  public void leapYearsAreDivisibleByFour() {
	assertTrue(LeapYear.isLeapYear(2020));
  }
  
  @Test 
  public void normalYearsAreNotDivisibleByFour() {
	assertFalse(LeapYear.isLeapYear(3));
  }
  
  @Test
  public void leapYearsAreNotDivisibleByOneHundred() {
	assertFalse(LeapYear.isLeapYear(1900));
  }
  
  @Test
  public void leapYearsAreDivisibleByFourHundred() {
	assertTrue(LeapYear.isLeapYear(2000));
  }

}
