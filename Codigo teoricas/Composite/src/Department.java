public class Department implements Employee{
    
    private Leaf[] leafs = new Leaf[10];
    private String name;
    
    
    public Department(String name) {
        this.name = name;
    }

    public void addLeaf(Leaf leaf) {
        for (int i = 0; i < leafs.length; i++) {
            if (leafs[i] == null) {
                leafs[i] = leaf;
                break;
            }
        }
    }

    public void removeLeaf(Leaf leaf) {
        for (int i = 0; i < leafs.length; i++) {
            if (leafs[i] == leaf) {
                leafs[i] = null;
                break;
            }
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (Leaf leaf : leafs) {
            if (leaf != null) {
                leaf.showDetails();
            }
        }
    }

}
