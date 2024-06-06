public class PlasticBottle implements Container{
    
    private Portion portion;
    private String name;

    public PlasticBottle(String name, Portion portion){
        this.name = name;
        this.portion = portion;
    }
    
    public Portion getPortion(){
        return portion;
    }
    
    public String toString(){
        return  this.name + " with portion = " + portion.toString();
    }
}
