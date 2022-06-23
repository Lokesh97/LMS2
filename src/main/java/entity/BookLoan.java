package main.java.entity;

import java.util.UUID;

public class BookLoan {

    private String id;

    private Borrower borrower;

    private Book book;

    private Fine fine;

    private int start;
    private int end;
    private int due;

    public BookLoan(String id, Borrower borrower, Book book) {
        this.id = id;
        this.borrower = borrower;
        this.book = book;
        this.start = 0;
        this.end = -1;
        this.due = 15;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Fine getFine() {
        return fine;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }

    public void calculateFine(){
        UUID uuid = UUID.randomUUID();
        this.fine = new Fine(uuid.toString(),Math.max(0,end-start-due),false);
    }
}
