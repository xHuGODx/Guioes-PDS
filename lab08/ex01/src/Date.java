public class Date {

    private final int day;
    private final int month;
    private final int year;

    private Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Date createDate(int day, int month, int year) {
        assert day > 0 && day <= 31 : "Invalid day";
        assert month > 0 && month <= 12: "Invalid month";
        assert year > 0: "Invalid year";
        return new Date(day, month, year);
    }
    
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "This date:" + day + "/" + month + "/" + year;
    }
    
}
