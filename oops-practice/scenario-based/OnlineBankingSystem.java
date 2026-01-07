import java.util.*;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

interface BankService {
    void deposit(double amount);

    void withdraw(double amount) throws InsufficientBalanceException;

    double calculateInterest();
}

abstract class Account implements BankService {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactionHistory = new ArrayList<>();

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactionHistory.add("Account created with balance " + balance);
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited " + amount);
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

class SavingsAccount extends Account {

    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {

    CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}

class TransferTask extends Thread {
    Account fromAccount;
    Account toAccount;
    double amount;

    TransferTask(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public void run() {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                try {
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    System.out.println("Transfer of " + amount + " completed");
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
    }
}

public class OnlineBankingSystem {

    public static void main(String[] args) {

        Account savings = new SavingsAccount("SA101", 5000);
        Account current = new CurrentAccount("CA201", 3000);

        System.out.println("Initial Balance:");
        System.out.println("Savings: " + savings.getBalance());
        System.out.println("Current: " + current.getBalance());

        Thread transaction1 = new TransferTask(savings, current, 1000);
        Thread transaction2 = new TransferTask(current, savings, 500);

        transaction1.start();
        transaction2.start();

        try {
            transaction1.join();
            transaction2.join();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\nFinal Balance:");
        System.out.println("Savings: " + savings.getBalance());
        System.out.println("Current: " + current.getBalance());

        System.out.println("\nSavings Interest: " + savings.calculateInterest());
        System.out.println("Current Interest: " + current.calculateInterest());

        System.out.println("\nSavings Transaction History:");
        savings.showTransactions();

        System.out.println("\nCurrent Transaction History:");
        current.showTransactions();
    }
}
