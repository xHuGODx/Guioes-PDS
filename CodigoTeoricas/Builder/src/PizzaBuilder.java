import java.util.ArrayList;
import java.util.List;
public class PizzaBuilder {

    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();
  
    public PizzaBuilder setDough(String dough) {
      this.dough = dough;
        return this;
    }
  
    public String getDough() {
        return dough;
    }
    
    public String getSauce() {
        return sauce;
    }
    
    public List<String> getToppings() {
        return toppings;
    }

    public PizzaBuilder setSauce(String sauce) {
      this.sauce = sauce;
      return this;
    }
  
    public PizzaBuilder addTopping(String topping) {
      toppings.add(topping);
      return this;
    }
  
    public Pizza build() {
      return Pizza.createPizza(this);
    }
  }
  