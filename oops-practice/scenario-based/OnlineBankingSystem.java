public class OnlineBankingSystem {

    public static void main(String[] args) {

        User u1 = new User("Rohan");
        User u2 = new User("Sohan");

        Account a1 = new SavingsAccount("101", 5000);
        Account a2 = new CurrentAccount("102", 3000);

        BankService bank = new SimpleBankService();

        bank.createAccount(u1, a1);
        bank.createAccount(u2, a2);

        Thread t1 = new Thread(() -> {
            try {
                bank.transferFunds(u1, a1, a2, 2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                bank.transferFunds(u2, a1, a2, 3000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception ignored) {
        }

        bank.checkBalance(u1, a1);
        bank.checkBalance(u2, a2);

        System.out.println("\nInterest Calculations:");
        System.out.println("Savings Interest = " + a1.calculateInterest());
        System.out.println("Current Interest = " + a2.calculateInterest());
    }
}

class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

abstract class Account {
    String accountNum;
    int balance;
    String user;

    Account(String accountNum, int balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }

    abstract double calculateInterest();
}

class SavingsAccount extends Account {

    SavingsAccount(String accountNum, int balance) {
        super(accountNum, balance);
    }

    double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {

    CurrentAccount(String accountNum, int balance) {
        super(accountNum, balance);
    }

    double calculateInterest() {
        return balance * 0.02;
    }
}

class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {
        super(message);
    }
}

interface BankService {
    void createAccount(User user, Account account);

    void checkBalance(User user, Account account);

    void transferFunds(User user,
            Account fromAccount,
            Account toAccount,
            int amount)
            throws InsufficientBalanceException;
}

class SimpleBankService implements BankService {

    public void createAccount(User user, Account account) {
        account.user = user.name;
        System.out.println("Account created for " + user.name +
                " | A/C: " + account.accountNum +
                " | Balance: " + account.balance);
    }

    public void checkBalance(User user, Account account) {
        System.out.println("Balance for " + user.name +
                " | A/C: " + account.accountNum +
                " = " + account.balance);
    }

    public synchronized void transferFunds(User user,
            Account from,
            Account to,
            int amount)
            throws InsufficientBalanceException {

        if (from.balance < amount) {
            throw new InsufficientBalanceException(
                    "Transaction failed! Not enough balance in " + from.accountNum);
        }

        System.out.println(user.name + " initiating transfer of " + amount);

        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {
        }

        from.balance -= amount;
        to.balance += amount;

        System.out.println("Transferred " + amount +
                " from " + from.accountNum +
                " to " + to.accountNum);
    }
}