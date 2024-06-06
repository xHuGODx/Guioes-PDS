public class Plane {
    private Integer[][] executiveSeats, touristicSeats;
    private int availableTouristicSeats, availableExecutiveSeats;

    // Constructors
    // Executive is optional
    public Plane( int numSeatsT, int numRowsT ) {
        this.touristicSeats = new Integer[numRowsT][numSeatsT];
        this.availableTouristicSeats = numSeatsT * numRowsT;

        fillSeats(this.touristicSeats);
    }

    public Plane(int numSeatsT, int numRowsT, int numSeatsE, int numRowsE) {
        this(numSeatsT, numRowsT);
        this.executiveSeats = new Integer[numRowsE][numSeatsE];
        this.availableExecutiveSeats = numSeatsE * numRowsE;
        fillSeats(this.executiveSeats);
    }

    private void fillSeats(Integer[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 0;
            }
        }
    }

    // Getters 
    public Integer[][] getExecutiveSeats() {
        return executiveSeats;
    }

    public Integer[][] getTouristicSeats() {
        return touristicSeats;
    }
    
    public boolean hasExecutiveClass() {
        return this.executiveSeats != null;
    }

    public boolean reserveSeats(int numSeats, TravelClass type, Reservation reservation){
        if (type == TravelClass.EXECUTIVE) {
            if (executiveSeats == null) {
                System.out.println("Classe Executiva não disponivel neste voo");
                return false;
            }

            if (numSeats > availableExecutiveSeats) {
                System.out.println("Não foi possivel obter lugares para a reserva: E "+numSeats);
                return false;
            }

            getSeats(numSeats, reservation, this.executiveSeats);
            availableExecutiveSeats = availableExecutiveSeats - numSeats;
            return true;
        }

        if (numSeats > availableTouristicSeats) {
            System.out.println("Não foi possivel obter lugares para a reserva: T "+numSeats);
            return false;
        }

        getSeats(numSeats, reservation, this.touristicSeats);
        availableTouristicSeats = availableTouristicSeats - numSeats;
        return true;

    }

    private void getSeats(int numSeats, Reservation reservation, Integer[][] seatArray) {
        int maxSeatPerRow = seatArray[0].length;
        String reservationCode = reservation.getReservationCode();
        int reserveID = Integer.parseInt(reservationCode.split(":")[1]);

        // First Pass to find empty rows:
        for (int row = 0; row < seatArray.length && 0 < numSeats; row++) {
            // if Empty row, seat passangers
            if (seatArray[row][0] == 0) {
                int seatsToAdd = Math.min(maxSeatPerRow, numSeats);
                
                for (int i = 0; i < seatsToAdd; i++) {   
                    seatArray[row][i] = reserveID;
                    reservation.addPassengerPosition(row, i);
                    numSeats--;
                }
            }
        }

        // Seat remaining passangers
        for (int row = 0; row < seatArray.length && 0 < numSeats; row++) {
            for (int seat = 0; seat < maxSeatPerRow && 0 < numSeats; seat++) {
                if (seatArray[row][seat] == 0) {
                    seatArray[row][seat] = reserveID;
                    reservation.addPassengerPosition(row, seat);
                    numSeats--;
                }
            }
        }
    }

    public void freeSeats(int rowNumber, int seatNumber, TravelClass travelClass) {
        // Reservations is made by system
        // row and seat can be assumed always as valid

        if (travelClass == TravelClass.EXECUTIVE) {
            executiveSeats[rowNumber][seatNumber] = 0;
        } else {
            touristicSeats[rowNumber][seatNumber] = 0;
        }
    }

    public void printPlaneConfiguration() {
        int numRows;
        if (hasExecutiveClass()){
            numRows = executiveSeats.length + touristicSeats.length;
        } else {
            numRows = touristicSeats.length;
        }

        /* Print first line */
        System.out.printf("  ");
        for (int i = 1; i <= numRows; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        char seatLetter = 'A';
        /* Print posterior lines */
        // In a real world scenario, num of seats per row of touristic seats
        // should always be lower than executive class
        int numTurSeats = touristicSeats[0].length;
        
        if (hasExecutiveClass()) {
            int numExecRows = executiveSeats.length;
            int numExecSeats = executiveSeats[0].length;

            for (int seat = 0; seat < numTurSeats; seat++) {
                System.out.printf("%-2c", seatLetter);

                // Print executive classes on current line
                // if there isnt executive seats on that line:
                // print whitespaces
                if (seat < numExecSeats) {
                    printline(executiveSeats, seat);
                } else {
                    for(int spaces = 0; spaces < numExecRows; spaces++)
                        System.out.printf("   ");
                }
                printline(touristicSeats, seat);
    
                System.out.println();
                seatLetter++;
            }
        } else {
            for (int seat = 0; seat < numTurSeats; seat++) {
                System.out.printf("%-2c", seatLetter);
                printline(touristicSeats, seat);
    
                System.out.println();
                seatLetter++;
            }
        }        
    }

    private void printline(Integer[][] seatArray, int seat) {
        for (int row = 0; row < seatArray.length; row++) {
            Integer seatReservation = seatArray[row][seat];
            System.out.printf("%3d", seatReservation);
        }
    }

    public String stringAvailableSeats() {
        String stringAvailableSeats;

        if (hasExecutiveClass()) {
            stringAvailableSeats = String.format("%d em classe Executiva; %d lugares em classe Turística.", availableExecutiveSeats , availableTouristicSeats);
        } else {
            stringAvailableSeats = String.format("%d lugares em classe Turística. Classe executiva não disponível neste voo.", availableTouristicSeats);
        }    
        return stringAvailableSeats;
    }
}