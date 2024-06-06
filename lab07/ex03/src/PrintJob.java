public class PrintJob implements Runnable {
    private final Document doc;
    private Integer id;
    private static int counter = 0;

    private PrintJob(Document doc){
        this.doc = doc;
        this.id = counter++;
    }

    public static PrintJob createPrintJob(Document doc){
        return new PrintJob(doc);
    }

    public Document getDocument(){
        return this.doc;
    }

    public int getID(){
        return this.id;
    }

    @Override
    public void run() {
        System.out.println("Finished " + this);
    }

    @Override
    public String toString() {
        return ("Job " + this.getID() + ": " + this.getDocument());
    }
}