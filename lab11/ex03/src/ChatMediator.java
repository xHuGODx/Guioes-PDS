import java.util.ArrayList;

/**
 * The ChatMediator class implements the MediatorInterface and represents a mediator
 * that facilitates communication between colleagues.
 */
public class ChatMediator implements MediatorInterface{
    private ArrayList<Colleague> colleagues = new ArrayList<Colleague>();

    /**
     * Constructs a new ChatMediator object.
     */
    public ChatMediator() {
        colleagues = new ArrayList<Colleague>();
    }

    /**
     * Adds a colleague to the list of colleagues.
     * @param colleague the colleague to add
     * @return true if the colleague was added successfully, false otherwise
     */
    public boolean addColleague(Colleague colleague) {
        if (colleagues.contains(colleague)) {
            return false;
        }
        return colleagues.add(colleague);
    }

    /**
     * Removes a colleague from the list of colleagues.
     * @param colleague the colleague to remove
     * @return true if the colleague was removed successfully, false otherwise
     */
    public boolean removeColleague(Colleague colleague) {
        return colleagues.remove(colleague);
    }

    /**
     * Sends a message from a sender to all other colleagues.
     * @param sender the sender of the message
     * @param message the message to send
     */
    public void sendMessage(Colleague sender, String message) {
        for (Colleague colleague : colleagues) {
            if (colleague != sender) {
                colleague.receiveMessage(sender, message);
            }
        }
    }
}
