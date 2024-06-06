public class Place {
    private final String name;
    private final String location;

    private Place(String name, String location){
        this.name = name;
        this.location = location;
    }

    public static Place createPlace(String name, String location){

        return new Place(name, location);
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }
}