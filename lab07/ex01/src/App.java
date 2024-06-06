public class App {
    public static void main(String[] args) {
        //alinea 1
        System.out.println("Alinea 1");

        Employee empl1 = new Employee("John Doe", 12345, 50000.0);
        Employee empl2 = new Employee("Jane Smith", 67890, 60000.0);
        Empregado empr1 = new Empregado("Paulo", "Raimundo", 54321, 501110.0);
        Empregado empr2 = new Empregado("Joao", "Sozinho", 67412, 6042130.0);

        Database db = new Database();
        Registos reg = new Registos();

        db.addEmployee(empl1);
        db.addEmployee(empl2);
        System.out.println("\n" + "Empregados na database:");
        Employee[] employees1 = db.getAllEmployees();
        for (Employee employee : employees1) {
            System.out.println(employee.toString());
        }
        

        reg.insere(empr1);
        reg.insere(empr2);
        System.out.println("\n" + "Empregados nos registos:");
        reg.getEmpregados().forEach(emp -> System.out.println(emp.toString()));
        System.out.println("\nO empregado com o código 54321 existe nos registos? " + reg.isEmpregado(54321));

        System.out.println("\n\nA remover o employee com numero 12345 e o empregado com o código 54321");
        db.deleteEmployee(12345);
        reg.remove(54321);
        
        System.out.println("\n\n" + "Empregados na database:");
        Employee[] employees2 = db.getAllEmployees();
        for (Employee employee : employees2) {
            System.out.println(employee.toString());
        }

        System.out.println("\n\n" + "Empregados nos registos:");
        reg.getEmpregados().forEach(emp -> System.out.println(emp.toString()));

        System.out.println("\n\nO empregado com o código 54321 existe nos registos? " + reg.isEmpregado(54321));
}
}