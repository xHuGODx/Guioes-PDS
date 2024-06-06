/**
 * The EmployeeFactory class is responsible for creating instances of Employee objects based on the provided name.
 */
public class EmployeeFactory {
    public static final String[] names = { "Mac", "Linux", "Win" };
    
    /**
     * Returns an Employee object based on the provided name.
     * If the name matches one of the predefined names, a Programmer object is returned.
     * Otherwise, a NullEmployee object is returned.
     *
     * @param name the name of the employee
     * @return an Employee object based on the provided name
     */
    public static Employee getEmployee(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return new Programmer(name);
            }
        }
        return new NullEmployee();
    }
}