public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Leaf leaf1 = new Leaf("John", "Manager");
        Leaf leaf2 = new Leaf("Jane", "Developer");
        Leaf leaf3 = new Leaf("Doe", "Tester");
        Leaf leaf4 = new Leaf("Pedro", "Trolha");

        Department department = new Department("Deti");


        department.addLeaf(leaf1);
        department.addLeaf(leaf2);
        department.addLeaf(leaf3);

        leaf4.showDetails();
        department.showDetails();

        department.removeLeaf(leaf2);
        department.showDetails();
    }
}
