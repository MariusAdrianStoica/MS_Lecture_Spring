package se.lexicon.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private final String id; //TransactionId
    private final Customer customer;
    private final TransactionType type;
    private final Double amount;
    private final LocalDateTime dateTime;

    public Transaction(Customer customer, TransactionType type, Double amount) {
        this.id = UUID.randomUUID().toString(); // unique(random) id of String type
        this.customer = customer;
        this.type = type;
        this.amount = amount;
        this.dateTime= LocalDateTime.now(); //current date
    }

    //only getter methods - because we don't want to initialize fields -> we define them final
    // read only values
    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", type=" + type +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}
