package wallet;

public class CashSlot {
    private long contents;

    public long getContents() {
        return contents;
    }

    public void dispense(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Dispense amount must be positive, got: " + amount);
        }
        this.contents = amount;
    }
}
