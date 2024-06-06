/**
 * The Colleague class represents a participant in a chat system.
 * Each colleague has a unique identifier and can send and receive messages through a mediator.
 */
public class Colleague {
    private static int counter = 1;
    private int id;
    private ChatMediator mediator;

    /**
     * Constructs a new Colleague object with the given mediator.
     * The colleague's unique identifier is automatically assigned.
     *
     * @param mediator the chat mediator for sending and receiving messages
     */
    public Colleague(ChatMediator mediator) {
        this.mediator = mediator;
        this.id = counter++;
    }

    /**
     * Sends a message from this colleague to the chat mediator.
     *
     * @param message the message to be sent
     */
    public void sendMessage(String message) {
        mediator.sendMessage(this, message);
    }

    /**
     * Sends a default message from this colleague to the chat mediator.
     * The default message includes the name of the colleague.
     */
    public void sendMessage() {
        mediator.sendMessage(this, "Hello from " + this + "!");
    }

    /**
     * Receives a message from another colleague through the chat mediator.
     *
     * @param sender  the colleague who sent the message
     * @param message the received message
     */
    public void receiveMessage(Colleague sender, String message) {
        System.out.println("Message received from " + sender + " by " + this + ". The message: " + message);
    }

    /**
     * Returns a string representation of this colleague.
     *
     * @return a string representation of this colleague
     */
    public String toString() {
        return "Colleague " + id;
    }
}
