import java.util.Set;

public class Client implements ProductObserver {
    private String name;
    private BiddingManager biddingManager;

    private Client(String name) {
        this.name = name;
    }

    public BiddingManager getBiddingManager() {
        return biddingManager;
    }

    public static Client create(String name) {
        return new Client(name);
    }

    public String getName() {
        return name;
    }

    public void setBiddingManager(BiddingManager biddingManager) {
        this.biddingManager = biddingManager;
    }

    public void newBid(Product product, Double amount) {
        biddingManager.newBid(this, product, amount);
    }

    public void newBidNotify(Product product, Client client, Double amount) {
        System.out.println("Client " + this.name + " notified of new bid on product " + product.getDescription() + " with amount " + String.format("%.2f", amount) + "€ from client " + client.getName());
    }

    public void bidOverNotify(Product product, Client winner) {
        System.out.print("Client " + name + " notified that bidding is over for product " + product.getDescription() + " ");
        if (this.equals(winner)) {
            System.out.println("This client was the winner.");
        } else if (winner != null) {
            System.out.println("This client was not the winner.");
        } else {
            System.out.println("There was no bidder, therefore this product is back in the stock.");
        }
    }

    public Set<Product> getAuctionList() {
        Set<Product> auctionList = biddingManager.getAuctionList();
        System.out.println("Client " + name + " has requested the products in auction:");
        for (Product product : auctionList) {
            System.out.println(product + " with current bid " + String.format("%.2f", product.getCurrentBid()) + "€");
        }

        return auctionList;
    }


    @Override
    public String toString() {
        return "Client: " + name;
    }
}
