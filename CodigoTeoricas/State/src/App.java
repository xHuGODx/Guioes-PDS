public class App {
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        System.out.println("Current state: " + fan.getState());
        fan.pull();
        System.out.println("Current state: " + fan.getState());
        fan.pull();
        System.out.println("Current state: " + fan.getState());
        fan.pull();
        System.out.println("Current state: " + fan.getState());
        fan.pull();
        System.out.println("Current state: " + fan.getState());
    }
}
