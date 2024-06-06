public class BasicCoffee implements Coffee {
    
    @Override
    public double getCost() {
        return 1.99;
    }

    @Override
    public String getDescription() {
        return "Coffe contains: Espresso";
    }
}