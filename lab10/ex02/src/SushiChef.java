/**
 * The SushiChef class represents a chef specializing in sushi.
 * It extends the Chef class and sets the specialty to "sushi".
 */
public class SushiChef extends Chef{
    
    /**
     * Private constructor for the SushiChef class.
     * Sets the specialty to "sushi".
     */
    private SushiChef(){
        setEspecialidade("sushi");
    }
 
    /**
     * Creates and returns a new instance of the SushiChef class.
     * @return a new instance of the SushiChef class
     */
    public static SushiChef createSushiChef(){
        return new SushiChef();
    }

}
