import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CafeTest {

  @Test
  void canBrewEspresso() {
    
	// The Given Clause (setting up the environment for the test)
	Cafe cafe = new Cafe();
    cafe.restockBeans(7);
    cafe.restockMilk(2);
    
    // The When clause (What we want test)
    Coffee coffee = cafe.brew(CoffeeType.Esspresso); // The coffee has been brewed but we need to test that the brewing behaviour is correct
    
    // The Then clause (What we expect to happen)
    // Test1
    // Check the returned object is an espresso
    // It should'nt have any milk in it
    // We have the correct amount of coffee 
    Assert.assertEquals(CoffeeType.Esspresso, coffee.getType()); // Checks the type of coffee brewed by the brew method
    Assert.assertEquals(0, coffee.getMilk()); // Checks that there isn't any milk in the brewed coffee
    Assert.assertEquals(7, coffee.getBeans()); // Checks that the number of coffee beans is 7 as is required by an espresso
    
    // If there is an error in the test the exact issue is highlighted in the JUnit terminal
    // Assert.assertEquals(1, coffee.getMilk()); 
    // This test fails as the amount of milk an espresso takes is 0 and the terminal prints "java.lang.AssertionError: expected:<1> but was:<0>"
  }
  
  // A test to check that after an espresso has been brewed that the stock levels of the coffee beans have been updated correctly
  @Test
  void brewingEspressoConsumesBeans() {
	// The Given Clause (setting up the environment for the test)
	Cafe cafe = new Cafe();
	cafe.restockBeans(7);
	cafe.restockMilk(2);
	    
    // The When clause (What we want test)
	cafe.brew(CoffeeType.Esspresso); // The coffee has been brewed but we need to test that the restock behaviour is correct
	
	// The Then clause (What we expect to happen)
	// Test to check that the number of coffee beans after brewing the espresso is 0
	Assert.assertEquals(0, cafe.getBeansInStock());
  }

  // A test thats is expected to throw and Exception when we brew an latte and the stock of milk is lower than the required amount.
  // This test shows how to handle exceptions in your code
  @Test
  void latterRequiresMilk() {
	// The Given Clause (setting up the environment for the test)
	Cafe cafe = new Cafe();
	cafe.restockBeans(7);
	//cafe.restockMilk(2);
	

	// The When clause (What we want test)
	//cafe.brew(CoffeeType.Latte);
	 
    //The Then clause (What we expect to happen)
    // Test to check that the we an exception is thrown when brewing a latte because the stock of milk is 0
	Assertions.assertThrows(IllegalStateException.class, () -> {
		cafe.brew(CoffeeType.Latte);
    });
	
  }
  
}
