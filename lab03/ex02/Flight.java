package lab03.Voos;

public class Flight {
    private String code;
    private Plane plane;
    private int reservationNumber;

    Flight(String c, Plane p) {
        this.code = c;
        this.plane = p;
        reservationNumber = 1;
    } 
    public String getCode() {
        return code;
    } 
    public Plane getPlane() {
        return plane;
    }
    public boolean addReservation(String classe, int numberOfSits){
        switch (classe) {
            case "E":
                if (!(this.plane instanceof PlaneWithExecutive)){
                    System.err.println("Classe executiva não disponível neste voo.");
                    return false;
                }
                PlaneWithExecutive executivePlane = (PlaneWithExecutive) this.plane;
                executivePlane.addExecutiveReservation(numberOfSits, this.reservationNumber);
                break;
            case "T":
                this.plane.addTouristReservation(numberOfSits, reservationNumber);
            default:
                System.err.println("Classe não existente.");
                return false;
        }
        this.reservationNumber++;
        return true;
    }

    //public abstract void cancelReservation();
}
