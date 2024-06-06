class Colleague {
    private String name;
    private ChatMediator mediator;

    public Colleague(ChatMediator mediator) {
        this.mediator = mediator;
        this.name = "Student";
    }

    public void sendMessage(String message) {
        System.out.println(this.name + ": Sending message - " + message);
        mediator.sendMessage(message);
    }

    public void receiveMessage(String message) {
        System.out.println(this.name + ": Received message - " + message);
    }
}
