public class ProductSold implements ProductState{
    private Product product;
    private Double winningBid;
    private Client winner;

    private ProductSold(Product product, Double winningBid, Client winner) {
        this.product = product;
        this.winningBid = winningBid;
        this.winner = winner;
    }

    public static ProductSold create(Product product, Double winningBid, Client winner) {
        return new ProductSold(product, winningBid, winner);
    }

    @Override
    public void newBid(Client client, Double amount) {
        System.out.println("Product " + product.getId() + " is already sold.");
    }

    @Override
    public String curState() {
        return "Product " + product.getId() + " is sold. Winning bid: " + winningBid + " from client " + winner.getName();
    }

    @Override
    public Double checkCurBid() {
        return 0.0;
    }

    @Override
    public void nextState() {
        System.out.println("Product " + product.getId() + " is already sold.");
    }
}
