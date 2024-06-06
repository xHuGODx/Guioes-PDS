public class LowSpeed implements State {
    @Override
    public String getStateName() {
        return "Low Speed";
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the fan...");
    }

    @Override
    public void pull() {
        System.out.println("Switching to Medium Speed");
    }

    @Override
    public State nextState() {
        return new MediumSpeed();
    }
}