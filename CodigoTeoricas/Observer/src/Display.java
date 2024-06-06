public abstract class Display implements Observer {
    protected String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public abstract void update(float temperature, float humidity);
}
