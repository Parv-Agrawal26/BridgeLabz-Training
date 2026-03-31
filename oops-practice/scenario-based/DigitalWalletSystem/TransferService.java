public interface TransferService {
    void transfer(double amount) throws InsufficientBalanceException;
}
