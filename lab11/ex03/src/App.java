public class App {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        Colleague c1 = new Colleague(mediator);
        Colleague c2 = new Colleague(mediator);
        Colleague c3 = new Colleague(mediator);
        mediator.addColleague(c1);
        mediator.addColleague(c2);
        mediator.addColleague(c3);
        c1.sendMessage("This is a message from c1.");
        c2.sendMessage("Hello from c2.");
        c1.sendMessage("This is another message from c1.");
        c2.sendMessage("Hello again from c2.");
        c3.sendMessage("I received all your messages. Here is a reply.");
    }
}
