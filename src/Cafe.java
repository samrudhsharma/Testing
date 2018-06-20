// A class to represent a coffee shop that can make a coffee and keep internal stock of the bean and milk quantities.
public class Cafe {
  private int beansInStock = 0, milkInStock = 0;
  
  public Coffee brew(CoffeeType coffeeType) {
	  return brew(coffeeType, 1);
  }

  public Coffee brew(CoffeeType coffeeType, int quantity) {
	requirePositive(quantity);
	
	int requiredBeans = coffeeType.getRequiredBeans() * quantity;
	int requiredMilk = coffeeType.getRequiredMilk() * quantity;
	if(requiredBeans > beansInStock || requiredMilk > milkInStock) {
	  throw new IllegalStateException("Insufficient milk or beans.");
	}
	beansInStock -= requiredBeans;
	milkInStock -= requiredMilk;
	
	return new Coffee(coffeeType, requiredBeans, requiredMilk);
  }

  public void restockBeans(int weightInGrams) {
	requirePositive(weightInGrams);
	beansInStock += weightInGrams; 
  }
  
  public void restockMilk(int weightInGrams) {
	requirePositive(weightInGrams);
	milkInStock += weightInGrams; 
  }
  
  public void requirePositive(int quantity) {
	if(quantity < 1)
		throw new IllegalArgumentException();
	
  }

  public int getBeansInStock() { 
	return beansInStock;
  }


  public int getMilkInStock() {
	return milkInStock;
  }
}
