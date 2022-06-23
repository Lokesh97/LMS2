package main.java.entity;

public class Book {

    private String isbn;

    private String title;

    private Author author;

    private boolean isBorrowed;

    public Book(String isbn, String title, boolean isBorrowed) {
        this.isbn = isbn;
        this.title = title;
        this.isBorrowed = isBorrowed;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
}
