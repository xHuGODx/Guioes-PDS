public class Person {
    private final String name;
    private final Integer id;
    private static Integer id_counter = 1;


    private Person(String name){
        this.name = name;
        if (name.equals("Unspecified")) this.id = 0;
        else this.id = id_counter++;
    }

    public static Person createPerson(String name){
        return new Person(name);
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    
}