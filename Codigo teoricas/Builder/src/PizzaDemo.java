public class PizzaDemo {

    public static void main(String[] args) {
      Waiter waiter = new Waiter();
  
      waiter.takeOrder("Hawaiian");
      waiter.preparePizza();
  
      System.out.println("\n---");
  
      waiter.takeOrder("Spicy");
      waiter.preparePizza();
    }
  }
  