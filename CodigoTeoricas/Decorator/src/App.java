public class App {
    public static void main(String[] args) {
        Coffee espresso = new BasicCoffee();
        Coffee milkEspresso = new Milk(espresso);
        Coffee sugarEspresso = new Sugar(espresso);
        Coffee caramelEspresso = new Caramel(espresso);
        Coffee caramelMilkEspresso = new Caramel(milkEspresso);
        Coffee milkmilkEspresso = new Milk(milkEspresso);

        System.out.println(milkEspresso.getDescription() + ": $" + milkEspresso.getCost());
        System.out.println(sugarEspresso.getDescription() + ": $" + sugarEspresso.getCost());
        System.out.println(caramelEspresso.getDescription() + ": $" + caramelEspresso.getCost());
        System.out.println(caramelMilkEspresso.getDescription() + ": $" + caramelMilkEspresso.getCost());
        System.out.println(milkmilkEspresso.getDescription() + ": $" + milkmilkEspresso.getCost());

        System.out.println(caramelMilkEspresso.getDescription());
    
    }
}
