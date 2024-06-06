// package Flight; // Assuming the same package as java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reservation {
    private TravelClass travelClass;
    private int numberOfPassengers;
    private String reservationCode;
    private ArrayList<ArrayList<Integer>> positionOfPassengers; // [ [0,1], [1,2], ... ]

    public Reservation(TravelClass travelClass, int numberOfPassengers, String flightCode, int sequentialReservationNumber) {
        this.travelClass = travelClass;
        this.numberOfPassengers = numberOfPassengers;
        this.reservationCode = generateReservationCode(flightCode, sequentialReservationNumber);
        this.positionOfPassengers = new ArrayList<>();
    }

    
    public TravelClass getTravelClass() {
        return travelClass;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public ArrayList<ArrayList<Integer>> getPositionOfPassengers() {
        return positionOfPassengers;
    }

    private String generateReservationCode(String flightCode, int sequentialReservationNumber) {
        return flightCode + ":" + sequentialReservationNumber;
    }


    public void addPassengerPosition(int numRow, int numSeat) {
        ArrayList<Integer> position = new ArrayList<>(Arrays.asList(numRow, numSeat));
        positionOfPassengers.add(position);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("Reservation Details:\n");
        result.append("Class: ").append(travelClass).append("\n");
        result.append("Number of Passengers: ").append(numberOfPassengers).append("\n");
        result.append("Reservation Code: ").append(reservationCode).append("\n");

        // Append passenger positions
        for(int i=0; i<numberOfPassengers;i++) {
            List<Integer> passengerPosition = positionOfPassengers.get(i); // list with position [numRow,numSeat] of one passenger
            result.append("Passenger: ").append(i+1).append(" ; Position: ").append(passengerPosition);

            // Check if it's the last iteration to avoid adding newline
            if (i < numberOfPassengers - 1) {
                result.append("\n");
            }

        }

        return result.toString();
    }
}
