import java.util.ArrayList;
import java.util.List;

public class BasicToAdvancedAdapter implements AdvancedPrinterInterface {
    private BasicPrinter printer;
    private List<PrintJob> pendingDocs;
    

    private BasicToAdvancedAdapter(BasicPrinter printer){
        this.printer = printer;
        pendingDocs = new ArrayList<PrintJob>();
    }

    public static BasicToAdvancedAdapter createBasicToAdvancedAdapter(BasicPrinter printer){
        return new BasicToAdvancedAdapter(printer);
    }

    @Override
    public int print(Document doc){
        System.out.println("Spooling 1 document.");
        PrintJob newJob = PrintJob.createPrintJob(doc);
        pendingDocs.add(newJob);
        if (this.printer.print(doc.text)) pendingDocs.remove(newJob);
        return newJob.getID();
    }

    @Override
    public List<Integer> print(List<Document> docs){
        System.out.println("Spooling " + docs.size() + " documents.");
        List<Integer> allJobs = new ArrayList<Integer>();
        for (Document doc : docs){
            PrintJob newJob = PrintJob.createPrintJob(doc);
            pendingDocs.add(newJob);
            if (this.printer.print(doc.text)) pendingDocs.remove(newJob);
            allJobs.add(newJob.getID());
        }
        return allJobs;
    }

    @Override
    public void showQueuedJobs() {
        System.out.println("Spooled jobs: ");
        for (PrintJob job : this.pendingDocs) {
            System.out.println("\t* " + job);
        }
        System.out.println();
    }

    @Override
    public boolean cancelJob(int jobId) {
        for (PrintJob job : this.pendingDocs) {
            if (job.getID() == jobId) return this.pendingDocs.remove(job);
        }
        return false;
    }

    @Override
    public void cancelAll() {
        System.out.println("Job rejected by spool: service shutting down?");
        this.pendingDocs.clear();
    }
}