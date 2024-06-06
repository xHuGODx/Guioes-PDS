public interface ProductObserver {
    void newBidNotify(Product product, Client client, Double amount);
    void bidOverNotify(Product product, Client winner);
}
