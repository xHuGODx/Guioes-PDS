public class Milk extends CoffeeDecorator {
    
    public Milk(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.30; 
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}