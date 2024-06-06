/**
 * The MediatorInterface interface defines the contract for a mediator object that facilitates communication
 * between colleagues in a system.
 */
public interface MediatorInterface {

    /**
     * Adds a colleague to the mediator.
     *
     * @param colleague the colleague to be added
     * @return true if the colleague was successfully added, false otherwise
     */
    public boolean addColleague(Colleague colleague);

    /**
     * Removes a colleague from the mediator.
     *
     * @param colleague the colleague to be removed
     * @return true if the colleague was successfully removed, false otherwise
     */
    public boolean removeColleague(Colleague colleague);

    /**
     * Sends a message from a sender colleague to all other colleagues in the system.
     *
     * @param sender the colleague sending the message
     * @param message the message to be sent
     */
    public void sendMessage(Colleague sender, String message);
}
