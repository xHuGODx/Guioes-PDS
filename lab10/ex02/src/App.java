public class App {
    public static void main(String[] args) throws Exception {

        // Create the chefs
        Chef sushiChef = SushiChef.createSushiChef();
        Chef pastaChef = PastaChef.createPastaChef();
        Chef burgerChef = BurgerChef.createBurgerChef();
        Chef pizzaChef = PizzaChef.createPizzaChef();
        Chef dessertChef = DessertChef.createDessertChef();

        // Set the Chain of Responsibility
        sushiChef.setNextChef(pastaChef);
        pastaChef.setNextChef(burgerChef);
        burgerChef.setNextChef(pizzaChef);
        pizzaChef.setNextChef(dessertChef);


        // Orders array
        String pedidos[] ={
            "Can I please get a veggie burger?",
            "Can I please get a pasta carbonara?",
            "Can I please get a PLAIN pizza, no toppings?",
            "Can I please get a sushi nigiri and sashimei?",
            "Can I please get a salad with tuna?",
            "Can I please get a strawberry ice cream and waffles dessert?"

        };

        // Cook the orders
        for (int k = 0; k < pedidos.length; k++) {
            System.out.println("\n" + pedidos[k]);
            String order = pedidos[k].split(" a ")[1].split("\\?")[0];
            sushiChef.cook(order);
        }
    }
}
