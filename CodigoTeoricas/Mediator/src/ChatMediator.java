import java.util.ArrayList;
import java.util.List;

class ChatMediator {
    private List<Colleague> colleagues;

    public ChatMediator() {
        this.colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        this.colleagues.add(colleague);
    }

    public void sendMessage(String message) {
        for (Colleague colleague : colleagues) {
            colleague.receiveMessage(message);
        }
        // Print the received message for each colleague
        for (Colleague colleague : colleagues) {
            System.out.println("(Received message: " + message + ")");
        }
    }
}
