/**
 * The DessertChef class represents a chef specializing in desserts.
 * It extends the Chef class and inherits its properties and methods.
 */
public class DessertChef extends Chef{
    
    /**
     * Private constructor for the DessertChef class.
     * Sets the specialty of the chef to "dessert".
     */
    private DessertChef(){
        setEspecialidade("dessert");
    }

    /**
     * Creates and returns a new instance of the DessertChef class.
     * @return A new instance of the DessertChef class.
     */
    public static DessertChef createDessertChef(){
        return new DessertChef();
    }

}
