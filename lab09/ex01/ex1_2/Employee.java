class Employee{

private Person person;
private double salary;
	
	public Employee(Person p, double s) {
		person = p;
		salary = s;
	}

	public double getSalary() {
		return salary;
	}

	public BankAccount getBankAccount() {
		return person.getBankAccount();
	}
}