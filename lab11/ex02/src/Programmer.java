/**
 * The Programmer class represents a programmer employee.
 * It extends the Employee class and provides additional functionality specific to programmers.
 */
class Programmer extends Employee {
    /**
     * Constructs a Programmer object with the given name.
     *
     * @param name the name of the programmer
     */
    public Programmer(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the programmer.
     *
     * @return the name of the programmer
     */
    @Override
    public String getName() {
        return name;
    }
}