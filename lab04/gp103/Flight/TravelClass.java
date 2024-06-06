public enum TravelClass {
    EXECUTIVE("E"),
    TOURISTIC("T");


    String typeOfClass;
    TravelClass(String typeOfClass) {
        this.typeOfClass = typeOfClass;
    }

    @Override
    public String toString() {
        return this.typeOfClass;
    }

    public static TravelClass getTypeByName(String type) {
        switch (type.charAt(0)) {
            case 'T':
                return TravelClass.TOURISTIC;
            case 'E':
                return TravelClass.EXECUTIVE;
            default:
                return null;
        }
    }
}