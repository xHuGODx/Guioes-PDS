public class Employee implements EmployeeInterface{
    
    private final String name;
    private final Date startDate;
    private final Date endDate;

    public Employee(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date start() {
        return this.startDate;
    }

    public Date terminate() {
        return this.endDate;
    }

    @Override
    public String work() {
        return this.getClass().getSimpleName() + " with name " + name + " is working";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
