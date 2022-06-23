package main.java.entity;

public class Fine {

    private String id;

    private double amount;

    private boolean isPaid;

    public Fine(String id, double amount, boolean isPaid) {
        this.id = id;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
