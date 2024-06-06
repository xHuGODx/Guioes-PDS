/**
 * Represents a Manager, which is a type of EmployeeDecorator.
 * Managers have the ability to manage tasks in addition to performing regular employee tasks.
 */
public class Manager extends EmployeeDecorator{
    
    /**
     * Constructs a Manager object with the specified employee.
     * 
     * @param employee the employee to be decorated
     */
    public Manager(EmployeeInterface employee) {
        super(employee);
    }

    /**
     * Performs the work of the manager, which includes both the regular employee work and managing tasks.
     * 
     * @return a string representing the work performed by the manager
     */
    @Override
    public String work() {
        return super.work() + manage();
    }

    /**
     * Manages tasks.
     * 
     * @return a string representing the management task
     */
    public String manage(){
        return " is managing";
    }
}
