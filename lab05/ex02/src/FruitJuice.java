public class FruitJuice implements Portion{
    
    private String name;
    private String fruit;
    private State state;
    private Temperature temperature;

    public FruitJuice(String name, String fruit, State state, Temperature temperature){
        this.name = name;
        this.fruit = fruit;
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
        return this.name + " : " + this.fruit + " , " + "Temperature " + this.temperature + " , State " + this.state; 
    }
}