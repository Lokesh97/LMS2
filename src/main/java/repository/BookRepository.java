package main.java.repository;

import main.java.entity.Book;

import java.util.HashMap;

public class BookRepository {

    private HashMap bookMapping;

    public BookRepository() {
        this.bookMapping = new HashMap<String, Book>();
    }

    public void addBook(Book book){
        this.bookMapping.put(book.getIsbn(), book);
    }

    public Book getBook(String id){
        return (Book) this.bookMapping.get(id);
    }

}
