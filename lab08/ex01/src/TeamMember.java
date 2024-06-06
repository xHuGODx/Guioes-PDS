/**
 * Represents a team member, which is a type of employee decorator.
 * A team member collaborates with others to perform work.
 */
public class TeamMember extends EmployeeDecorator {
    
    /**
     * Constructs a new TeamMember object.
     * 
     * @param employee the employee to be decorated
     */
    public TeamMember(EmployeeInterface employee) {
        super(employee);
    }

    /**
     * Performs work by calling the super class's work method
     * and adding the collaboration action.
     * 
     * @return the result of the work performed
     */
    @Override
    public String work() {
        return super.work() + collaborate();
    }

    /**
     * Performs the collaboration action.
     * 
     * @return a string representing the collaboration action
     */
    public String collaborate(){
        return " is collaborating";
    }
}
