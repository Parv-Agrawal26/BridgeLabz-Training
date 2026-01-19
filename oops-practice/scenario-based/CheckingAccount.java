abstract class BankAccount {

    private final String accountNumber;
    private final double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    abstract double calculateFee();
}

class SavingsAccount extends BankAccount {

    SavingsAccount(String acc, double bal) {
        super(acc, bal);
    }

    double calculateFee() {
        return getBalance() * 0.005;
    }
}

class CheckingAccount extends BankAccount {

    CheckingAccount(String acc, double bal) {
        super(acc, bal);
    }

    double calculateFee() {
        return getBalance() < 1000 ? 1.0 : 0.0;
    }

    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount("12345", 1000);
        System.out.printf("%.2f%n", savings.calculateFee());
    }
}
