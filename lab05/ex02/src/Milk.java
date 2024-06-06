public class Milk implements Portion {
    private String name;
    private State state;
    private Temperature temperature;

    public Milk(String name, State state, Temperature temperature){
        this.name = name;
        this.state = state;
        this.temperature = temperature;
    }

    public Temperature getTemperature(){
        return temperature;
    }

    public State getState(){
        return state;
    }
    
    public String toString(){
        return this.name + " : " + "Temperature " + this.temperature + " , State " + this.state;
    }
}
