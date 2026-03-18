package wallet;

public class Wallet {
    private int balance = 0;

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive, got: " + amount);
        }
        this.balance += amount;
    }

    public void debit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Debit amount must be positive, got: " + amount);
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException(amount, this.balance);
        }
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
