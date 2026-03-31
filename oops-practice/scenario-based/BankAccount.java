class BankAccount {
    int accountNumber;
    double balance;
    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
    void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(101, 5000);
        account.checkBalance();
        account.deposit(2000);
        account.withdraw(1000);
        account.withdraw(7000);
        account.checkBalance();
    }
}
