package wallet;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(int requested, int available) {
        super("Insufficient funds: requested " + requested + ", available " + available);
    }
}
