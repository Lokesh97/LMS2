package main.java.initial;

import main.java.controller.LibraryController;
import main.java.entity.Book;
import main.java.entity.Borrower;
import main.java.repository.BookLoanRepository;
import main.java.repository.BookRepository;
import main.java.repository.BorrowerRepository;

public class Setup {

    public Setup() {
    }

    public LibraryController init(){
        BookRepository bookRepository = new BookRepository();
        bookRepository.addBook(new Book("1", "c++", false));
        bookRepository.addBook(new Book("2", "java", false));
        bookRepository.addBook(new Book("3", "python", false));
        bookRepository.addBook(new Book("4", "goland", false));

        BorrowerRepository borrowerRepository = new BorrowerRepository();
        borrowerRepository.addBorrower(new Borrower("a", "12", "123"));
        borrowerRepository.addBorrower(new Borrower("b", "13", "234"));

        BookLoanRepository bookLoanRepository = new BookLoanRepository();

        LibraryController libraryController = new LibraryController(bookRepository, borrowerRepository, bookLoanRepository);

        return libraryController;
    }


}
