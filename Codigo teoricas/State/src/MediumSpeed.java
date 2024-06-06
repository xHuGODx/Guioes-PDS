public class MediumSpeed implements State {
    @Override
    public String getStateName() {
        return "Medium Speed";
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the fan...");
    }

    @Override
    public void pull() {
        System.out.println("Switching to High Speed");
    }

    @Override
    public State nextState() {
        return new HighSpeed();
    }
}
