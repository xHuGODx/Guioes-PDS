import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BiddingManager implements ProductObserver{
    private String name;
    private ArrayList<Product> stockList;
    private TreeMap<Product, ArrayList<Client>> curBidders;
    private ArrayList<Product> soldList;
    private final ScheduledExecutorService scheduler;
    

    private BiddingManager(String name) {
        this.name = name;
        stockList = new ArrayList<>();
        soldList = new ArrayList<>();
        curBidders = new TreeMap<>();
        System.out.println("A new auction site is open! I'm your host: " + name);
        this.scheduler = Executors.newScheduledThreadPool(5);
        this.scheduler.scheduleAtFixedRate(this::startNextBidding, 0, 1, TimeUnit.MINUTES);
    }


    private void startNextBidding() {
        if (!stockList.isEmpty()) {
            System.out.println("Starting next bidding.");
            Product product = null;
            try {
                product = stockList.remove(0);
                ArrayList<Client> bidders = new ArrayList<>();
                curBidders.put(product, bidders);
                startBidding(product, 10);
            } catch (Exception e) {
                e.printStackTrace();
                // If an exception is caught, add the product back to the stock list
                if (product != null) {
                    stockList.add(0, product);
                }
            }
        }
        else{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startNextBidding();
        }
    }

    public static BiddingManager create(String name) {
        return new BiddingManager(name);
    }

    public void startBidding(Product product, Integer maxBiddingInterval) {
        product.startBidding(maxBiddingInterval);
    }

    public Set<Product> getAuctionList() {
        return curBidders.keySet();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        stockList.add(product);
    }

    public void newBid(Client client, Product product, Double amount) {
        if (curBidders.keySet().contains(product)){
            if (amount > product.getCurrentBid()){
                product.newBid(client, amount);
                ArrayList<Client> bidders = curBidders.get(product);
                synchronized (bidders) {
                    if (!bidders.contains(client)) bidders.add(client);
                }
                curBidders.put(product, bidders);
                System.out.println("New bid on product " + product.getDescription() + " with amount " + String.format("%.2f", amount) + "€ from client " + client.getName());
            } else {
                System.out.println("Bid on product " + product.getDescription() + " with amount " + String.format("%.2f", amount) + "€ from client " + client.getName() + " is too low.");
            }
        } else {
            System.out.println("Product " + product.getDescription() + " is not in auction.");
        }
    }

    public Double getCurrentBid(Product product) {
        return product.getCurrentBid();
    }

    @Override
    public void newBidNotify(Product product, Client client, Double amount) {
        for (Client c : curBidders.get(product)){
            if (!c.equals(client)){
                c.newBidNotify(product, client, amount);
            }
        }
    }

    @Override
    public void bidOverNotify(Product product, Client winner) {
        for (Client c : curBidders.get(product)){
            c.bidOverNotify(product, winner);
        }

        if (winner != null){
            soldList.add(product);
            if (soldList.size() >= 10) {
                scheduler.shutdown();
            }
        }
        else{
            stockList.add(product);
        }
        curBidders.remove(product);
    }

    
}
