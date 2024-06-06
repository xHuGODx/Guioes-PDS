public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.10; // Adding cost for sugar
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}