import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CafeTest {

  private static final int NO_BEANS = 0;
  private static final int NO_MILK = 0;
  private static final int ESPRESSO_BEANS = CoffeeType.Esspresso.getRequiredBeans();

  @Test
  void canBrewEspresso() {
    
	// The Given Clause (setting up the environment for the test)
	Cafe cafe = cafeWithBeans();
    cafe.restockMilk(2);
    
    // The When clause (What we want test)
    Coffee coffee = cafe.brew(CoffeeType.Esspresso); // The coffee has been brewed but we need to test that the brewing behaviour is correct
    
    // The Then clause (What we expect to happen)
    // Test1
    // Check the returned object is an espresso
    // It should'nt have any milk in it
    // We have the correct amount of coffee 
    assertEquals(CoffeeType.Esspresso, coffee.getType(), "Wrong tyoe of coffee"); // Checks the type of coffee brewed by the brew method
    assertEquals(NO_MILK, coffee.getMilk(), "Wrong amount of milk"); // Checks that there isn't any milk in the brewed coffee
    assertEquals(ESPRESSO_BEANS, coffee.getBeans(), "Wrong number of beans"); // Checks that the number of coffee beans is 7 as is required by an espresso
    
    // If there is an error in the test the exact issue is highlighted in the JUnit terminal
    // Assert.assertEquals(1, coffee.getMilk()); 
    // This test fails as the amount of milk an espresso takes is 0 and the terminal prints "java.lang.AssertionError: expected:<1> but was:<0>"
  }


  
  // A test to check that after an espresso has been brewed that the stock levels of the coffee beans have been updated correctly
  @Test
  void brewingEspressoConsumesBeans() {
	// The Given Clause (setting up the environment for the test)
	Cafe cafe = cafeWithBeans();
	cafe.restockMilk(2);
	    
    // The When clause (What we want test)
	cafe.brew(CoffeeType.Esspresso); // The coffee has been brewed but we need to test that the restock behaviour is correct
	
	// The Then clause (What we expect to happen)
	// Test to check that the number of coffee beans after brewing the espresso is 0
	Assert.assertEquals("Wrong amount of beans left", NO_BEANS, cafe.getBeansInStock());
  }

  // A test thats is expected to throw and Exception when we brew an latte and the stock of milk is lower than the required amount.
  // This test shows how to handle exceptions in your code
  @Test
  void latteRequiresMilk() {
	// The Given Clause (setting up the environment for the test)
	Cafe cafe = cafeWithBeans();
	

	// The When clause (What we want test)
	//cafe.brew(CoffeeType.Latte);
	 
    //The Then clause (What we expect to happen)
    // Test to check that the we an exception is thrown when brewing a latte because the stock of milk is 0
	Assertions.assertThrows(IllegalStateException.class, () -> {
		cafe.brew(CoffeeType.Latte);
    });
	
  }
  
  private Cafe cafeWithBeans() {
		
		Cafe cafe = new Cafe();
	    cafe.restockBeans(ESPRESSO_BEANS);
		return cafe;
	}
  
}
