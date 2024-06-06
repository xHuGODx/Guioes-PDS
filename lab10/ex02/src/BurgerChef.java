/**
 * The BurgerChef class represents a chef specialized in making burgers.
 * It extends the Chef class and inherits its properties and methods.
 */
public class BurgerChef extends Chef{
        
    /**
     * Private constructor for the BurgerChef class.
     * Sets the specialty of the chef to "burger".
     */
    private BurgerChef(){
        setEspecialidade("burger");
    }

    /**
     * Creates and returns a new instance of the BurgerChef class.
     * @return a new instance of the BurgerChef class
     */
    public static BurgerChef createBurgerChef(){
        return new BurgerChef();
    }

}
