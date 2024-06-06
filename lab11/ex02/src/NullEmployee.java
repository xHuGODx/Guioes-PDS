/**
 * Represents a null employee.
 * This class extends the Employee class and provides a default implementation for a null employee.
 */
class NullEmployee extends Employee {
    /**
     * Constructs a new NullEmployee object.
     * Sets the name of the null employee to "No Employee Found".
     */
    public NullEmployee() {
        this.name = "No Employee Found";
    }
    
    /**
     * Returns the name of the null employee.
     * @return The name of the null employee.
     */
    @Override
    public String getName() {
        return name;
    }
}