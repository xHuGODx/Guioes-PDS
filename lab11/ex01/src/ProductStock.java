public class ProductStock implements ProductState {
    private Product product;

    private ProductStock(Product product) {
        this.product = product;
    }

    public static ProductStock create(Product product) {
        return new ProductStock(product);
    }

    @Override
    public void newBid(Client client, Double amount) {
        System.out.println("Product is not available for bids.");
    }

    @Override
    public String curState() {
        return "In Stock.";
    }

    @Override
    public Double checkCurBid() {
        return 0.0;
    }

    public void startBidding(Integer maxBidInterval) {
        this.product.setProductState(ProductBid.create(this.product, this.product.getBasePrice(), maxBidInterval));
    }

    @Override
    public void nextState() {
        this.startBidding(10);
    }
    
}
