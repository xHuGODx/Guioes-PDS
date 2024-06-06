import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;

public class FlightManager {
    HashMap<String, Flight> FlightArray = new HashMap<>();
    HashMap<String, Reservation> ReservationArray = new HashMap<>();

    public void importDataFromFile(String filename) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(filename));
        if (!scanner.hasNextLine()) {
            System.out.println("The file is empty.");
        } else {
            Flight flight = processFirstLine(scanner);
            FlightArray.put(flight.getFlightCode(), flight);

            // Make reservations
            System.out.printf("Codigo de voo %s. Lugares disponíveis: %s \n", flight.getFlightCode(), flight.getPlane().stringAvailableSeats());
            while (scanner.hasNextLine()) {
                String[] desiredReserve = scanner.nextLine().split(" ");
                String seatsClass = desiredReserve[0];
                int numberSeats = Integer.parseInt(desiredReserve[1]);

                // System.out.println();

                reserveSeats(flight.getFlightCode(),seatsClass,numberSeats);
            }
            System.out.println();
        }
    }    
        

    private Flight processFirstLine(Scanner scanner) {
        String firstLine = scanner.nextLine();
        String[] tokens = firstLine.trim().split(" ");
        Character firstCharacter = tokens[0].charAt(0);
        String flightCode = tokens[0].substring(1);
        Integer numSeatsE = 0, numRowsE = 0, numSeatsT = 0, numRowsT = 0;

        if(!firstCharacter.equals('>')) {
            System.out.println("File with invalid format!"); 
            System.exit(1);
        }  

        if (tokens.length != 3 && tokens.length != 2) {
            System.out.println("File with invalid format!");
            System.exit(1);
        }

        // Process
        if (tokens.length == 3) { // Executive and Turistic Seats
            String executiveData = tokens[1]; // e.g: 4x3 (4 rows and 3 seats)
            String[] executiveParts = executiveData.split("x"); 

            if (executiveParts.length == 2) {
                numRowsE = Integer.parseInt(executiveParts[0]) ;
                numSeatsE = Integer.parseInt(executiveParts[1]) ;
            } else {
                System.out.println("Invalid format. Expected format: 'number1xnumber2'"); 
                System.exit(1);
            }

            String turisticData = tokens[2]; // e.g: 4x3 (4 rows and 3 seats)
            String[] turisticParts = turisticData.split("x"); 

            if (turisticParts.length == 2) {
                numRowsT = Integer.parseInt( turisticParts[0] );
                numSeatsT = Integer.parseInt( turisticParts[1] );
            } else {
                System.out.println("Invalid format. Expected format: 'number1xnumber2'");
                System.exit(1);
            }


        } else { // tokens.length == 2 -> Only Turistic Seats
            String turisticData = tokens[1]; // e.g: 4x3 (4 rows and 3 seats)
            String[] turisticParts = turisticData.split("x"); 

            if (turisticParts.length == 2) {
                numRowsT = Integer.parseInt( turisticParts[0] );
                numSeatsT = Integer.parseInt( turisticParts[1] );
            } else {
                System.out.println("Invalid format. Expected format: 'number1xnumber2'");
                System.exit(1);
            }
        }

        Plane plane;
        if( numRowsE == 0) { // Only Turistic Class
            plane = new Plane(numSeatsT, numRowsT);
        } else { // Executive and Turistic Seats
            plane = new Plane(numSeatsT, numRowsT, numSeatsE, numRowsE);
        }

        Flight flight = new Flight(flightCode, plane);
        return flight;
    }

    public void displayFlightDetails(String flightCode) {
        /* Get Flight */
        Flight flight = locateFlightByFlightCode(flightCode);
        if (flight == null) {
            System.out.printf("Cannot locate flight \"%s\"!\n", flightCode);
            return;
        }

        /* Get plane object and print its configuration */
        flight.getPlane().printPlaneConfiguration();
    }

    /**
     * 
     * @param flightCode
     * @param TouristicSize Integer[Seats, Rows]
     * @param ExecutiveSize Integer[Seats, Rows]
     */
    public void createFlight(String flightCode, int[] TouristicSize, int[] ExecutiveSize) {
        if (flightExists(flightCode)) {
            System.out.printf("There is already a flight with flight code \"%s\"\n", flightCode);
        }
        
        /* Create Plane for flight 
         * If ExecutiveSize == [0, 0] 
         * then executive class is nonexistent on plane
        */
        Plane plane;
        if (! Arrays.equals(ExecutiveSize, new int[]{0, 0})) {
            plane = new Plane(TouristicSize[0], TouristicSize[1], ExecutiveSize[0], ExecutiveSize[1]);
        } else {
            plane = new Plane(TouristicSize[0], TouristicSize[1]);
        }

        /* Create the flight and save it on Flight List */
        Flight flight = new Flight(flightCode, plane);
        FlightArray.put(flight.getFlightCode(), flight);
    }
    
    private boolean flightExists(String flightCode) {
        return locateFlightByFlightCode(flightCode) != null;
    }

    public Reservation reserveSeats(String flightCode, String seatsClass, int numberSeats) {
        Flight flight = locateFlightByFlightCode(flightCode);
        if (flight == null) {
            System.out.printf("Voo \"%s\" não encontrado!\n", flightCode);
            return null;
        }

        /* Get travel class to make reservation */
        TravelClass type = TravelClass.getTypeByName(seatsClass);
        if (type == null) {
            System.out.printf("Classe de voo inserida não é valida \"%s\". Deveria ser \"T\" ou \"E\"!\n", seatsClass);
            return null;
        }

        /* Try to reserve seats at flight */ 
        Reservation reservation = flight.reserveSeats(numberSeats, type);
        if (reservation == null) {
            return null;
        }

        /* Save reservation on Reservation Container */
        ReservationArray.put(reservation.getReservationCode(), reservation);
        return reservation;
    }

    private Flight locateFlightByFlightCode(String flightCode) {
        return FlightArray.getOrDefault(flightCode, null);
    }

    public void cancelReservation(String reservationCode) {
        Reservation reservation = ReservationArray.getOrDefault(reservationCode, null);
        if (reservation == null) {
            System.out.printf("Reserva com código \"%s\" não encontrado!\n", reservationCode);
            return;
        }
        
        /* Get flight regarding this reservation
         * No error checking as if reservation exists
         * then flight MUST exist
        */
        String flightcode = reservation.getReservationCode().split(":")[0];
        Flight flight = locateFlightByFlightCode(flightcode);

        /* Free reservation seats from plane */
        flight.deleteReservation(reservation);

        /* Delete Reservation */
        ReservationArray.remove(reservationCode);
    }
}
