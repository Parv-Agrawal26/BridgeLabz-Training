public class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    void display() {
        System.out.println(accountNumber + " " + accountHolder);
    }
}
