import java.util.ArrayList;
import java.util.List;

public class Wallet {
    double balance;
    List<String> history = new ArrayList<>();

    public Wallet(double balance) {
        this.balance = balance;
    }

    void addMoney(double amount) {
        balance += amount;
        history.add("Added " + amount);
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Low balance");
        }
        balance -= amount;
        history.add("Withdraw " + amount);
    }
}
