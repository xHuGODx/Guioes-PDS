package lab03.Voos;

public class TouristicPlaneOnly extends Plane{
    TouristicPlaneOnly(int numberOfTouristicQueues, int sitsPerTouristicQueue){
        super(numberOfTouristicQueues, sitsPerTouristicQueue);
    }

    public int getNumberOfTouristicSeats() {
        return this.numberOfTouristQueues*this.sitsPerTouristQueue;
    }

    @Override
    public String toString(){
        return "Touristic Plane with " + this.numberOfTouristQueues*this.sitsPerTouristQueue + "touristic sits.";
    }
}
