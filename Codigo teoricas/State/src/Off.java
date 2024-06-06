public class Off implements State {
    @Override
    public String getStateName() {
        return "Off";
    }

    @Override
    public void turnOff() {
        System.out.println("The fan is already off.");
    }

    @Override
    public void pull() {
        System.out.println("Turning on the fan...");
    }

    @Override
    public State nextState() {
        return new LowSpeed();
    }
}