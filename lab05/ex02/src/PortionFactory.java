public class PortionFactory {
    public static Portion create(String type, Temperature temperature){
        switch(type) {
            case "Beverage":
                if (temperature == Temperature.WARM) return new Milk("Milk", State.Liquid, temperature);
                else return new FruitJuice("Fruit Juice", "Orange", State.Liquid, temperature);
            case "Meat":
                if (temperature == Temperature.WARM) return new Pork("Pork", State.Solid, temperature);
                else return new Tuna("Tuna", State.Solid, temperature);
            default:
                System.out.println("Invalid type");
                return null;
        }
    }
}