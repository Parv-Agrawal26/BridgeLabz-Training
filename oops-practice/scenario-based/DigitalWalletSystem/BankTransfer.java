public class BankTransfer implements TransferService {
    Wallet wallet;

    public BankTransfer(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void transfer(double amount) throws InsufficientBalanceException {
        wallet.withdraw(amount);
        wallet.history.add("Bank Transfer " + amount);
    }
}
