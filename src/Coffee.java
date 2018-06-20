// A class to represent an individual coffee that has been served to the client.
public class Coffee {
  private final CoffeeType type;
  private final int beans;
  private final int milk;

  @Override
  public String toString() { 
	return "Coffee [type=" + type + ", beans=" + beans + ", milk=" + milk + "]";
  }
  
  public Coffee(CoffeeType type, int beans, int milk) {
	super();
	this.type = type;
	this.beans = beans;
	this.milk = milk;
  }
  
  public CoffeeType getType() {
	return type;
  }
  
  public int getBeans() {
	return beans;  
  }

  public int getMilk() {
	return milk;
  } 
}
