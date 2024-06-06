public class App {
    public static void main(String[] args) throws Exception {
        Date date1 = Date.createDate(10, 10, 10);
        Date date2 = Date.createDate(12,12,12);
        EmployeeInterface emp1 = new Employee("Mario",date1,date2);

        System.out.println(emp1.work());

        EmployeeInterface emp2 = new TeamMember(emp1);

        System.out.println(emp2.work());

        EmployeeInterface emp3 = new TeamLeader(emp2);
        EmployeeInterface emp4 = new Manager(emp3);

        System.out.println(emp4.work());
    }
}
