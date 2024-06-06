public class BankAccountProxy implements BankAccount{
    private BankAccount bankAccount;

    private BankAccountProxy(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public static BankAccountProxy createProxy(BankAccount bankAccount) {
        return new BankAccountProxy(bankAccount);
    }

    public void deposit(double amount) {
        this.bankAccount.deposit(amount);
    }

    public boolean withdraw(double amount) {
        System.out.println("Access denied.");
        return false;        
    }

    public double balance() {
        System.out.println("Access denied.");
        return 0;
    }
    
}
