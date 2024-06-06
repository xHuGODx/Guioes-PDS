public class Tupperware implements Container{
    
    private Portion portion;
    private String name;
    
    public Tupperware(String name,Portion portion){
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
