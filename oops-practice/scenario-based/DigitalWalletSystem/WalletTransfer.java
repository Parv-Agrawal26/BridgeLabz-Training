public class WalletTransfer implements TransferService {
    Wallet wallet;

    public WalletTransfer(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void transfer(double amount) throws InsufficientBalanceException {
        wallet.withdraw(amount);
        wallet.history.add("Wallet Transfer " + amount);
    }
}
