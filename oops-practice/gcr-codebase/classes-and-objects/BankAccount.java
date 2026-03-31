public class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current balance: " + balance);
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn amount is: " + amount);
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    public void printDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Alice", 1001, 5000);
        BankAccount account2 = new BankAccount("Bob", 1002, 3000);

        account1.printDetails();
        account1.deposit(1500);
        account1.withdraw(2000);
        System.out.println();

        account2.printDetails();
        account2.deposit(2000);
        account2.withdraw(6000);
    }
}
