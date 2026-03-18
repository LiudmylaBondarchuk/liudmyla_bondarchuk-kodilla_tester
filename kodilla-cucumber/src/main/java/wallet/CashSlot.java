package wallet;

public class CashSlot {
    private int contents;

    public int getContents() {
        return contents;
    }

    public void dispense(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Dispense amount must be positive, got: " + amount);
        }
        this.contents = amount;
    }
}
