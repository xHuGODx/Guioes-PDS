/**
 * The PastaChef class represents a chef specialized in making pasta dishes.
 * It extends the Chef class and inherits its methods and attributes.
 */
public class PastaChef extends Chef{
        
    /**
     * Private constructor for the PastaChef class.
     * Sets the specialty of the chef to "pasta".
     */
    private PastaChef(){
        setEspecialidade("pasta");
    }

    /**
     * Creates a new instance of the PastaChef class.
     * @return a new PastaChef object.
     */
    public static PastaChef createPastaChef(){
        return new PastaChef();
    }

}
