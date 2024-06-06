public class CurrentConditionsDisplay extends Display {
    public CurrentConditionsDisplay() {
        super("Current Conditions");
    }

    @Override
    public void update(float temperature, float humidity) {
        System.out.println(name + ": " + temperature + "C degree and " + humidity + "% humidity.");
    }
}