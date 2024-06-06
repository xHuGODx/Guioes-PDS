public class StatisticsDisplay extends Display {
    public StatisticsDisplay() {
        super("Statistics");
    }

    private int count = 0;
    private float sumTemperature = 0;
    private float sumHumidity = 0;

    @Override
    public void update(float temperature, float humidity) {
        count++;
        sumTemperature += temperature;
        sumHumidity += humidity;
        System.out.println(name + ": Average temperature = " + sumTemperature / count + "C, Average humidity = " + sumHumidity / count + "%");
    }
}