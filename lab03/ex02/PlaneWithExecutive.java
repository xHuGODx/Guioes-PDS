package lab03.Voos;

public class PlaneWithExecutive extends Plane{
    private int[][] executiveSits;
    private int numberOfExecutiveQueues;
    private int sitsPerExecutiveQueue;
    
    PlaneWithExecutive(int nOTQ, int sPTQ, int nOEQ, int sPEQ){
        super(nOTQ, sPTQ);
        this.numberOfExecutiveQueues = nOEQ;
        this.sitsPerExecutiveQueue = sPEQ;
        this.executiveSits = new int[numberOfExecutiveQueues][sitsPerExecutiveQueue];
    }
    public int checkEmptyExecutiveSits(){
        return checkEmptySitsInAClasse(executiveSits, numberOfExecutiveQueues, sitsPerExecutiveQueue);
    }
    public int getEmptyExecutiveQueue(){
        return getEmptyQueueInAClasse(executiveSits, numberOfExecutiveQueues, sitsPerExecutiveQueue);
    }
    public boolean addExecutiveReservation(int numberOfSits, int reservationNumber){
        int queueNumber = getEmptyExecutiveQueue();
        if (checkEmptyExecutiveSits() < numberOfSits){
            System.err.printf("Não foi possível obter lugares para a reserva: E %d\n", numberOfSits);
            return false;
        }
        return addReservationInAClasse(this.executiveSits, this.numberOfExecutiveQueues, this.sitsPerExecutiveQueue, numberOfSits, reservationNumber, queueNumber);
    }

    public int getNumberOfExecutiveSeats() {
        return this.numberOfExecutiveQueues*this.sitsPerExecutiveQueue;
    }

    public int getNumberOfTouristicSeats() {
        return this.numberOfTouristQueues*this.sitsPerTouristQueue;
    }

    @Override
    public String toString(){
        return "Executive Plane with " + this.numberOfExecutiveQueues*this.sitsPerExecutiveQueue +"executive sits and " + this.numberOfTouristQueues*this.sitsPerTouristQueue + "touristic sits.";
    }
}
