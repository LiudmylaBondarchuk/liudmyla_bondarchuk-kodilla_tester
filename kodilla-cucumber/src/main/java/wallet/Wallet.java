package wallet;

public class Wallet {
    private long balance = 0;

    public void deposit(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be positive, got: " + amount);
        }
        this.balance += amount;
    }

    public void debit(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Debit amount must be positive, got: " + amount);
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException(amount, this.balance);
        }
        this.balance -= amount;
    }

    public long getBalance() {
        return balance;
    }
}
