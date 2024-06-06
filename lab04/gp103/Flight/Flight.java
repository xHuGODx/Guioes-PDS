import java.util.ArrayList;

public class Flight {
    private String flightCode;
    private Plane plane;
    private int nextReservationCode = 1;


    // Constructor
    public Flight(String flightCode, Plane plane) {
        this.flightCode = flightCode;
        this.plane = plane;
    }

    // Getters and Setters
    public String getFlightCode() {
        return flightCode;
    }
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }
    public Plane getPlane() {
        return plane;
    }
    public void setPlane(Plane plane) {
        this.plane = plane;
    }


    /* Try to reserve seats at this.plane
     * if failure return null
     * else return reservation Object
     */
    public Reservation reserveSeats(int numOfSeats, TravelClass travelClass) {
        Reservation reservation = new Reservation(travelClass, numOfSeats, this.flightCode, nextReservationCode);
        boolean success = plane.reserveSeats(numOfSeats, travelClass, reservation);

        if (!success) {
            return null;
        }

        // Increment reservationcode only if reservation was successful
        nextReservationCode++;
        return reservation;
    }


    /* Free all seats reserved on the plane
     * by this reservation.
    **/
    public void deleteReservation(Reservation reservation) {
        ArrayList<ArrayList<Integer>> passengers = reservation.getPositionOfPassengers();

        // passenger is [row, seat]
        for (ArrayList<Integer> passenger : passengers) {
            int row = passenger.get(0),
                seat= passenger.get(1);
            TravelClass travelClass = reservation.getTravelClass();
            
            plane.freeSeats(row, seat, travelClass);
        }
    }
}