package main.java.entity;

public class Borrower {

    private String name;

    private String id;

    private String phone;

    public Borrower(String name, String bid, String phone) {
        this.name = name;
        this.id = bid;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
