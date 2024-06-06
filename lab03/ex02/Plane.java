package lab03.Voos;

public abstract class Plane implements PlaneInterface{
    public int numberOfTouristQueues;
    public int sitsPerTouristQueue;
    public int[][] touristSits;

    Plane(int nOTQ, int sPTQ){
        this.numberOfTouristQueues = nOTQ;
        this.sitsPerTouristQueue = sPTQ;
        this.touristSits = new int[nOTQ][sPTQ];
    }
    public int checkEmptyTouristSits(){
        return checkEmptySitsInAClasse(this.touristSits, this.numberOfTouristQueues, this.sitsPerTouristQueue);
    }
    public int getEmptyTouristQueue(){
        return getEmptyQueueInAClasse(this.touristSits, this.numberOfTouristQueues, this.sitsPerTouristQueue);
    }
    public boolean addTouristReservation(int numberOfSits, int reservationNumber){
        int queueNumber = getEmptyTouristQueue();
        if (checkEmptyTouristSits() < numberOfSits){
            System.err.printf("Não foi possível obter lugares para a reserva: T %d\n", numberOfSits);
            return false;
        }
        return addReservationInAClasse(this.touristSits, this.numberOfTouristQueues, this.sitsPerTouristQueue, numberOfSits, reservationNumber, queueNumber);
    }



    // Static methods;
    public static int checkEmptySitsInAClasse(int[][] classSits, int numberOfQueues, int sitsPerQueue){
        int emptySits = 0;

        for (int i = 0; i < numberOfQueues; i++){
            for (int j = 0; j < sitsPerQueue; j++){
                if (classSits[i][j] == 0){
                    emptySits++;
                }
            }
        }
        return emptySits;
    }
    public static int getEmptyQueueInAClasse(int[][] classSits, int numberOfQueues, int sitsPerQueue){
        // Devolve o número da primeira fila que for encontrada vazia.
        // Devolve 0 se não encontrar nenhuma fila vazia.
        
        int emptySitsInAQueue = 0;

        for (int i = 0; i < numberOfQueues; i++){
            for (int j = 0; j < sitsPerQueue; j++){
                if (classSits[i][j] == 0){
                    emptySitsInAQueue++;
                }
                if (emptySitsInAQueue == sitsPerQueue)
                    return i;
            }
        }
        return 0;
    }
    public static boolean addReservationInAClasse(int[][] classSits, int numberOfQueues, int sitsPerQueue, int numberOfSits, int reservationNumber, int queueNumber){
        if (queueNumber != 0){ // Ou seja, existe uma fila vazia:
            for (int i = 0; i < numberOfSits; i++){
                classSits[queueNumber][i] = reservationNumber;
            }
        }
        else{ // Reservar sequencialmente:
            int numberOfSitsChosen = 0;
            for (int i = 0; i < numberOfQueues; i++){
                for (int j = 0; j < sitsPerQueue; j++){
                    if (classSits[i][j] == 0){
                        classSits[i][j] = reservationNumber;
                        numberOfSitsChosen++;
                    }
                    if (numberOfSitsChosen == numberOfSits)
                        return true;
                }
            }
        }
        return false;
    }

    public abstract String toString();
}

