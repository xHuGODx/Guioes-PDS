public class Pizza {

    private final String dough;
    private final String sauce;
    private final String[] toppings;
  
    private Pizza(String dough, String sauce, String[] toppings) {
      this.dough = dough;
      this.sauce = sauce;
      this.toppings = toppings;
    }
  
    public void composicao() {
      System.out.println("Pizza:");
      System.out.println("  Dough: " + dough);
      System.out.println("  Sauce: " + sauce);
      System.out.println("  Toppings: " + String.join(", ", toppings));
    }
  
    // Static factory method que usa o builder
    public static Pizza createPizza(PizzaBuilder builder) {
      return new Pizza(builder.dough, builder.sauce, builder.toppings.toArray(new String[0]));
    }
  }
  