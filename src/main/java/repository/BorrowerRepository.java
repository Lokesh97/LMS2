package main.java.repository;

import main.java.entity.Borrower;

import java.util.HashMap;

public class BorrowerRepository {

    private HashMap borrowerMapping;

    public BorrowerRepository() {
        this.borrowerMapping = new HashMap<String, Borrower>();
    }

    public void addBorrower(Borrower borrower){
        this.borrowerMapping.put(borrower.getId(), borrower);
    }

    public Borrower getBorrower(String id){
        return (Borrower) this.borrowerMapping.get(id);
    }
}
