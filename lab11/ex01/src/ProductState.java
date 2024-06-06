public interface ProductState {
    void newBid(Client client, Double amount);
    String curState();
    Double checkCurBid();
    void nextState();
}
