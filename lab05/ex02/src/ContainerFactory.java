public class ContainerFactory {
    public static Container create(Portion portion) {
        Temperature temperature = portion.getTemperature();
        State state = portion.getState();
        switch (state) {
            case Solid:
                switch (temperature) {
                    case WARM:
                        return new Tupperware("Tupperware", portion);
                    case COLD:
                        return new PlasticBag("PlasticBag", portion);
                }
            case Liquid:
                switch (temperature) {
                    case WARM:
                        return new TermicBottle("TermicBottle", portion);
                    case COLD:
                        return new PlasticBottle("PlasticBottle", portion);
                }
            default:
                System.out.println("Invalid state");
                return null;
        }

    }
    
}
