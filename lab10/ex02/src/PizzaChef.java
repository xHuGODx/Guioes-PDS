/**
 * The PizzaChef class represents a chef specializing in making pizzas.
 * It extends the Chef class and inherits its properties and methods.
 */
public class PizzaChef extends Chef{
    
    /**
     * Private constructor for the PizzaChef class.
     * Sets the specialty of the chef to "pizza".
     */
    private PizzaChef(){
        setEspecialidade("pizza");
    }

    /**
     * Creates a new instance of the PizzaChef class.
     * @return A new PizzaChef object.
     */
    public static PizzaChef createPizzaChef(){
        return new PizzaChef();
    }
}
