// A class to represents different types of coffees and the beans and milk quantities required to make them
public enum CoffeeType {
  Esspresso(7, 0),
  Latte(7, 227),
  FillterCoffee(10, 0);

  private final int requiredBeans, requiredMilk;

  private CoffeeType(int requiredBeans, int requiredMilk) {
	this.requiredBeans = requiredBeans;
	this.requiredMilk = requiredMilk;
  }

  public int getRequiredBeans() {
	return requiredBeans;
  }

  public int getRequiredMilk() {
	return requiredMilk;
  }	
}
