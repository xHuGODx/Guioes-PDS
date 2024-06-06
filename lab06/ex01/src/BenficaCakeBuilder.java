public class BenficaCakeBuilder implements CakeBuilder{
    
    private Cake benficaCake;
    
    public void setCakeShape(Shape shape) {
        benficaCake.setShape(shape);
    }

    public void addCakeLayer() {
        benficaCake.addLayer();
    }

    public void addCreamLayer() {
        benficaCake.setMidLayerCream(Cream.Red_Berries);
    }

    public void addTopLayer() {
        benficaCake.setTopLayerCream(Cream.Red_Berries);
    }

    public void addTopping() {
        benficaCake.setTopping(Topping.Red_Berries);
    }

    public void addMessage(String m) {
        benficaCake.setMessage(m);
    }

    public void createCake() {
        benficaCake = new Cake("Red Velvet");
        addTopping();
        addTopLayer();
        addCreamLayer();
    }

    public Cake getCake() {
        return benficaCake;
    }
}
