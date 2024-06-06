public class App2 {
    public static void main(String[] args) {

    System.out.println("\n" + "\n" + "Alinea 2" + "\n");
        //alinea 2
        //O objetivo é ter empregados na database e employee nos registos (na verdade é só um destes dois que é necessário)
        //(empregados nos registos e employees na database já vimos que funciona)

        //empregados na database

        Database db2 = new Database();
        Empregado empr3 = new Empregado("Rafa", "Silva", 54111, 9999.0);
        EmpregadosAdaptor empr3adapted = EmpregadosAdaptor.createEmpregadosAdaptor(empr3);
        db2.addEmployee(empr3adapted);

        Employee[] employees3 = db2.getAllEmployees();
        for (Employee employee : employees3) {
            System.out.println(employee.toString());
        }

        //employees nos registos

        Registos reg2 = new Registos();
        Employee empl3 = new Employee("Arthur Cabral", 69, 0.1);
        EmployeeAdaptor empl3adapted = EmployeeAdaptor.createEmployeeAdaptor(empl3);
        reg2.insere(empl3adapted);

        reg2.getEmpregados().forEach(emp -> System.out.println(emp.toString()));


        //agora posso escolher a implementação que quero usar pois ambos suportam ambos os conjuntos de funcionarios
        //(vou usar a que ja tem um metodo para ver se um empregado existe na lista de empregados)

        System.out.println("\n\n\n\n" + "------------Teste Final--------------" + "\n");

        Registos reg3 = new Registos();
        Empregado empr4 = new Empregado("Di", "Maria", 1, 9999.0);
        Empregado empr5 = new Empregado("Anatoly", "Trubin", 2, 10000.0);
        reg3.insere(empr4);
        reg3.insere(empr5);
        Employee empl4 = new Employee("Alexandder Bah", 3, 8000.0);
        Employee empl5 = new Employee("David Neres", 4, 15000.0);
        reg3.insere(EmployeeAdaptor.createEmployeeAdaptor(empl4));
        reg3.insere(EmployeeAdaptor.createEmployeeAdaptor(empl5));

        System.out.println("\nEmpregados nos registos:");
        reg3.getEmpregados().forEach(emp -> System.out.println(emp.toString()));

        //remover empregados normais

        System.out.println("\nO empregado com o código 1 existe nos registos? " + reg3.isEmpregado(1));
        System.out.println("A remover o empregado com o código 1");
        reg3.remove(1);
        System.out.println("O empregado com o código 1 existe nos registos? " + reg3.isEmpregado(1));

        //remover empregados adaptados agora

        System.out.println("\nO empregado com o código 3 existe nos registos? " + reg3.isEmpregado(3));
        System.out.println("A remover o empregado com o código 3");
        reg3.remove(3);
        System.out.println("O empregado com o código 3 existe nos registos? " + reg3.isEmpregado(3));

        System.out.println("\nEmpregados nos registos:");
        reg3.getEmpregados().forEach(emp -> System.out.println(emp.toString()));
}
}