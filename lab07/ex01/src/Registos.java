import java.util.ArrayList;
import java.util.List;

public class Registos {
    
    private ArrayList<Empregado> empregados;
    public Registos() {
        empregados = new ArrayList<>();
    }

    /**
     * Inserts an employee into the list of employees.
     *
     * @param emp the employee to be inserted
     */
    public void insere(Empregado emp) {
        empregados.add(emp);
    }

    /**
     * Removes an employee from the list based on the given employee code.
     * If an employee with the specified code is found, it is removed from the list.
     *
     * @param codigo the code of the employee to be removed
     */
    public void remove(int codigo) {
        for (Empregado emp : empregados) {
            if (emp.codigo() == codigo) {
                empregados.remove(emp);
                break;
            }
        }
    }

    /**
     * Checks if an employee with the given code exists in the employee records.
     *
     * @param codigo the code of the employee to check
     * @return true if an employee with the given code exists, false otherwise
     */
    public Boolean isEmpregado(int codigo) {
        for (Empregado emp : empregados) {
            if (emp.codigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the list of employees.
     *
     * @return the list of employees
     */
    public List<Empregado> getEmpregados() {
        return empregados;
    }

}
