import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class BiddingWarDemo {
    private final ScheduledExecutorService executor;
    private final Random random;
    private final BiddingManager bm;
    private final Client c1, c2, c3, c4;

    public BiddingWarDemo() {
        executor = Executors.newScheduledThreadPool(4); // 4 clients
        random = new Random();
        bm = BiddingManager.create("Auction Site 1");

        c1 = Client.create("Client 1"); 
        c2 = Client.create("Client 2");
        c3 = Client.create("Client 3");
        c4 = Client.create("Client 4");

        c1.setBiddingManager(bm);
        c2.setBiddingManager(bm);
        c3.setBiddingManager(bm);
        c4.setBiddingManager(bm);

        executor.schedule(addRandomProduct(), random.nextInt(10), TimeUnit.SECONDS);
        executor.schedule(makeRandomBid(c1), random.nextInt(10), TimeUnit.SECONDS);
        executor.schedule(makeRandomBid(c2), random.nextInt(10), TimeUnit.SECONDS);
        executor.schedule(makeRandomBid(c3), random.nextInt(10), TimeUnit.SECONDS);
        executor.schedule(makeRandomBid(c4), random.nextInt(10), TimeUnit.SECONDS);

    }

    Runnable addRandomProduct() {
        return () -> {
            String productName = "Product " + (random.nextInt(100) + 1); // Random product name
            double basePrice = 50 + random.nextDouble() * 50; // Random base price between 50 and 100
            Product product = Product.create(productName, basePrice);
            product.setBiddingManager(bm);
            bm.addProduct(product);
    
            long delay = 1 + random.nextInt(10); // Random delay between 1 and 10 seconds
            executor.schedule(addRandomProduct(), delay, TimeUnit.SECONDS);
        };
    }
    
    

Runnable makeRandomBid(Client client) {
    return () -> {
        try{
            Object[] auctionList = client.getBiddingManager().getAuctionList().toArray();
            if (auctionList.length == 0) {
                long delay = 1 + random.nextInt(10); // Random delay between 1 and 10 seconds
                executor.schedule(makeRandomBid(client), delay, TimeUnit.SECONDS); // No products to bid on
                return;
            }

            int randomIndex = random.nextInt(auctionList.length);
            Product product = (Product) auctionList[randomIndex]; // Get a random product from the current bidding list
            double currentHighestBid = bm.getCurrentBid(product);
            double bidIncrement = 1 + random.nextDouble() * 10; // Random increment between 1 and 10
            double newBid = currentHighestBid + bidIncrement;

            // Probability of placing a bid decreases as the price increases
            double basePrice = product.getBasePrice();
            double bidProbability = Math.exp(-(newBid - basePrice) / 50.0); // Adjust the denominator to change the rate of decrease
            if (random.nextDouble() < bidProbability) {
                client.newBid(product, newBid);
            }

            long delay = 1 + random.nextInt(10); // Random delay between 1 and 10 seconds
            executor.schedule(makeRandomBid(client), delay, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
}

    public static void main(String[] args) {
        new BiddingWarDemo();
    }
}