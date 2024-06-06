public class CompanyFacade {


    public void admitEmployee(Person person, double salary) {
        Employee e = new Employee(person, salary);
        registerInSocialSecurity(e);


    }

    private static void registerInSocialSecurity(Employee e) {
        // register in social security
    }

    private static void registerInInsurance(Employee e) {
        // register in insurance
    }

    private static void createEmployeeCard(Employee e) {
        // create employee card
    }

    private static void giveParkingSpace(Employee e) {
        if (e.getSalary())
    }
}
