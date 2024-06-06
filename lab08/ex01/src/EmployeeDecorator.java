/**
 * The EmployeeDecorator class is an abstract class that implements the EmployeeInterface.
 * It serves as a base class for decorators that add additional functionality to an employee object.
 * 
 * The class contains a protected instance variable, decoratedEmployee, which represents the decorated employee object.
 * 
 * The class provides implementations for the methods defined in the EmployeeInterface by delegating the calls to the decorated employee object.
 * 
 * Subclasses of EmployeeDecorator can override these methods to add additional behavior before or after calling the corresponding method on the decorated employee object.
 */
public abstract class EmployeeDecorator implements EmployeeInterface{
    
    protected EmployeeInterface decoratedEmployee;

    public EmployeeDecorator(EmployeeInterface decoratedEmployee){
        this.decoratedEmployee = decoratedEmployee;
    }

    @Override
    public Date start() {
        return decoratedEmployee.start();
    }

    @Override
    public Date terminate() {
        return decoratedEmployee.terminate();
    }

    @Override
    public String work() {
        return this.decoratedEmployee.work();
    }

    @Override
    public String getName() {
        return decoratedEmployee.getName();
    }

}
