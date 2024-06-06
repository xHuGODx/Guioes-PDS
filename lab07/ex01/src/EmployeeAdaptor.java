public class EmployeeAdaptor extends Empregado{
    
    /**
     * Constructs a new EmployeeAdaptor object.
     * 
     * @param employee the Employee object to be adapted
     */
    private EmployeeAdaptor(Employee employee){
        super(employee.getName().split(" ")[0], employee.getName().split(" ")[1], (int) employee.getEmpNum(), employee.getSalary());
    }
    
    /**
     * Creates a new EmployeeAdaptor object.
     * 
     * @param employee the Employee object to be adapted
     * @return a new EmployeeAdaptor object
     */
    public static EmployeeAdaptor createEmployeeAdaptor(Employee employee){
        return new EmployeeAdaptor(employee);
}
}