public class Product implements Comparable<Product> {
    private BiddingManager biddingManager;
    private String description;
    private Double basePrice;
    private ProductState state;
    private Integer id;
    private static Integer counter = 0;

    private Product(String description, Double basePrice) {
        this.id = counter++;
        this.description = description;
        this.basePrice = basePrice;
        // initialize state to ProductStock
        state = ProductStock.create(this);
    }

    public Integer getId() {
        return id;
    }  

    public String curState() {
        return state.curState();
    }  

    public void startBidding(Integer maxBiddingInterval) {
        if (this.state.curState().equals("In Stock.") == false) {
            System.out.println("Product " + this.id + " is already in auction.");
            return;
        }
        this.setProductState(ProductBid.create(this, basePrice, maxBiddingInterval));
    }

    public static Product create(String description, Double basePrice) {
        return new Product(description, basePrice);
    }

    public String getDescription() {
        return description;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBiddingManager(BiddingManager biddingManager) {
        this.biddingManager = biddingManager;
    }

    public Double getCurrentBid() {
        return state.checkCurBid();
    }

    public void setProductState(ProductState state) {
        this.state = state;
    }

    public void newBid(Client client, Double amount) {
        this.state.newBid(client, amount);
    }

    public void bidOverNotify(Client winner) {
        this.biddingManager.bidOverNotify(this, winner);
    }

    public void newBidNotify(Client client, Double amount) {
        this.biddingManager.newBidNotify(this, client, amount);
    }

    @Override
    public String toString() {
        return "Product " + this.id  + ": " + description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product other = (Product) obj;
            return description.equals(other.description);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }

    public BiddingManager getBiddingManager() {
        return biddingManager;
    }

    @Override
    public int compareTo(Product o) {
        return this.id.compareTo(o.id);
    }
    
}
