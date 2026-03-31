public class DigitalWalletSystem {
    public static void main(String[] args) {
        Wallet wallet = new Wallet(2000);
        wallet.addMoney(1000);

        try {
            TransferService ts = new WalletTransfer(wallet);
            ts.transfer(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (String h : wallet.history) {
            System.out.println(h);
        }
    }
}
