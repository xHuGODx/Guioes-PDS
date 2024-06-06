public class Waiter {

    private final PizzaBuilder builder = new PizzaBuilder();
  
    public void takeOrder(String pizzaType) {
      switch (pizzaType) {
        case "Hawaiian":
          builder.setDough("Massa grossa")
                 .setSauce("Marinara")
                 .addTopping("Fiambre")
                 .addTopping("Ananas");
          break;
        case "Spicy":
          builder.setDough("Massa fina")
                 .setSauce("Marinara")
                 .addTopping("Pepperoni")
                 .addTopping("Bacon")
                 .addTopping("Pimentoes")
                 .addTopping("Queijo");
          break;
        default:
          System.out.println("Sorry, we don't have " + pizzaType + " pizza.");
      }
    }
  
    public void preparePizza() {
      Pizza pizza = Pizza.createPizza(builder);
      pizza.composicao();
    }
  }
  