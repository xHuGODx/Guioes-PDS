import java.util.Vector;

class Database {
    // Data elements
    private Vector<Employee> employees; // Stores the employees
    public Database() {
    employees = new Vector<>();
    }

    /**
     * Adds an employee to the database.
     *
     * @param employee the employee to be added
     * @return true if the employee was successfully added, false if employee already exists
     */

    public boolean addEmployee(Employee employee) {
    // Code to add employee

        if (employees.contains(employee)) {
            return false;
        }
        employees.add(employee);
        return true;

    }

    /**
     * Deletes an employee from the database based on the employee number.
     *
     * @param emp_num the employee number of the employee to be deleted
     */

    public void deleteEmployee(long emp_num) {
    // Code to delete employee
        for (Employee employee : employees) {
            if (employee.getEmpNum() == emp_num) {
                employees.remove(employee);
                break;
            }
        }
    }
    /**
     * Retrieves all employees from the database.
     *
     * @return an array of Employee objects representing all employees in the database
     */
    public Employee[] getAllEmployees() {
    // Code to retrieve collection
        Employee[] employeeArray = new Employee[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            employeeArray[i] = employees.get(i);
        }
        return employeeArray;
    }
}