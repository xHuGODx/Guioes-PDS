/**
 * The TeamLeader class represents a team leader employee.
 * It extends the EmployeeDecorator class and adds the ability to plan.
 */
public class TeamLeader extends EmployeeDecorator {
    
    /**
     * Constructs a TeamLeader object with the specified employee.
     * 
     * @param employee the employee to be decorated
     */
    public TeamLeader(EmployeeInterface employee) {
        super(employee);
    }

    /**
     * Overrides the work method from the EmployeeDecorator class.
     * Appends the planning action to the work action of the decorated employee.
     * 
     * @return the combined work and planning action
     */
    @Override
    public String work() {
        return super.work() + plan();
    }
    
    /**
     * Performs the planning action.
     * 
     * @return the planning action
     */
    public String plan(){
        return " is planning";
    }
}
