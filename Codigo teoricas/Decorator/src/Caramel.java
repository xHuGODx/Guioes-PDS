public class Caramel extends CoffeeDecorator {
    public Caramel(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.20; // Adding cost for caramel
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Caramel";
    }
}