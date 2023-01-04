package se.lexicon.exception;

public class InsufficientFundsException extends Exception{

    private final double amount;

    public InsufficientFundsException(double amount, String message) {
        super(message);
        this.amount=amount;
    }

    public double getAmount() {
        return amount;
    }
}
