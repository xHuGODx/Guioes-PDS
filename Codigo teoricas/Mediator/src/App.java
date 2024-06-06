public class App {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        Colleague c1 = new Colleague(mediator);
        Colleague c2 = new Colleague(mediator);

        mediator.addColleague(c1);
        mediator.addColleague(c2);

        c1.sendMessage("Hello");
        c2.sendMessage("Hi");

        c1.sendMessage("How are you?");
        c2.sendMessage("I'm good, thanks!");

        mediator.sendMessage("Important announcement!");
    }
}
