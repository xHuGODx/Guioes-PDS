import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ProductBid implements ProductState, ProductObserver {
    private Product product;
    private Double curBid;
    private Client bestBidder;
    private final Integer maxBidInterval;
    private final ScheduledExecutorService scheduler;
    private ScheduledFuture<?> scheduledTask;

    private ProductBid(Product product, Double startingValue, Integer maxBidInterval) {
        this.product = product;
        this.curBid = startingValue;
        this.bestBidder = null;
        this.maxBidInterval = maxBidInterval;
        this.scheduler = Executors.newScheduledThreadPool(1);
        scheduleNextState();
    }

    private void scheduleNextState() {
        if (scheduledTask != null && !scheduledTask.isDone()) {
            scheduledTask.cancel(false);
        }
        scheduledTask = this.scheduler.schedule(this::nextState, maxBidInterval, TimeUnit.SECONDS);
    }

    public static ProductBid create(Product product, Double curBid, Integer maxBidInterval) {
        return new ProductBid(product, curBid, maxBidInterval);
    }

    @Override
    public void newBid(Client client, Double amount) {
        if (amount > curBid) {
            curBid = amount;
            bestBidder = client;
            newBidNotify(this.product, client, amount);
            scheduleNextState();
        }
    }

    @Override
    public String curState() {
        return "Bid in progress. Current bid: " + curBid + " from client " + bestBidder.getName();
    }

    @Override
    public Double checkCurBid() {
        return curBid;
    }

    @Override
    public void nextState() {
        bidOverNotify(product, bestBidder);
        scheduler.shutdown(); // Stop the scheduled task
        if (bestBidder == null) {
            product.setProductState(ProductStock.create(this.product));
            return;
        }
        product.bidOverNotify(bestBidder);
        product.setProductState(ProductSold.create(this.product, curBid, bestBidder));
    }

    @Override
    public void newBidNotify(Product product, Client client, Double amount) {
        product.getBiddingManager().newBidNotify(product, client, amount);
    }

    @Override
    public void bidOverNotify(Product product, Client winner) {
        product.getBiddingManager().bidOverNotify(product, winner);
    }
}
