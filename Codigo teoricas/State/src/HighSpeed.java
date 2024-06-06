public class HighSpeed implements State {
    @Override
    public String getStateName() {
        return "High Speed";
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the fan...");
    }

    @Override
    public void pull() {
        System.out.println("Turning off the fan...");
    }

    @Override
    public State nextState() {
        return new Off();
    }
}