package main.java.controller;

import main.java.entity.Book;
import main.java.entity.BookLoan;
import main.java.entity.Borrower;
import main.java.repository.BookLoanRepository;
import main.java.repository.BookRepository;
import main.java.repository.BorrowerRepository;

import java.util.List;
import java.util.UUID;

public class LibraryController {

    private BookRepository bookRepository;

    private BorrowerRepository borrowerRepository;

    private BookLoanRepository bookLoanRepository;

    public LibraryController(BookRepository bookRepository, BorrowerRepository borrowerRepository, BookLoanRepository bookLoanRepository) {
        this.bookRepository = bookRepository;
        this.borrowerRepository = borrowerRepository;
        this.bookLoanRepository = bookLoanRepository;
    }

    public String checkoutBook(String bookId, String borrowerId){
        Book book = bookRepository.getBook(bookId);

        if(book == null || book.getIsBorrowed()){
            return "------------------- ERROR ------------------- Book is null or Borrowed";
        }

        Borrower borrower = borrowerRepository.getBorrower(borrowerId);
        if(borrower == null){
            return "------------------- ERROR ------------------- Borrower null";
        }

        List<BookLoan> bookLoans = bookLoanRepository.getBookLoansByBorrowerId(borrowerId);
        if(bookLoans != null) {
            int loans = 0;
            for (BookLoan bookLoan : bookLoans) {
                if (bookLoan.getEnd() == -1) {
                    loans = loans + 1;
                }
            }

            if (loans >= 2) {
                return "------------------- ERROR ------------------- Borrower already have 2 books";
            }
        }

        book.setIsBorrowed(true);
        bookLoanRepository.addBookLoansByBorrowerId(borrowerId, new BookLoan(UUID.randomUUID().toString(), borrower, book));

        return " ------------------- SUCCESS ------------------- ";
    }

    public String returnBook(String bookId, String borrowerId, int days){
        Book book = bookRepository.getBook(bookId);

        if(book == null || !book.getIsBorrowed()){
            return "------------------- ERROR ------------------- Book is null or not Borrowed";
        }

        Borrower borrower = borrowerRepository.getBorrower(borrowerId);
        if(borrower == null){
            return "------------------- ERROR ------------------- Borrower null";
        }

        List<BookLoan> bookLoans = bookLoanRepository.getBookLoansByBorrowerId(borrowerId);
        BookLoan bookLoanObj = null;
        if(bookLoans != null) {
            for (BookLoan bookLoan : bookLoans) {
                if (bookLoan.getEnd() == -1 && bookLoan.getBook().getIsbn().equals(bookId)) {
                    bookLoanObj = bookLoan;
                    break;
                }
            }
        }

        if(bookLoanObj == null){
            return "------------------- ERROR ------------------- No Such Book Borrowed";
        }

        book.setIsBorrowed(false);
        bookLoanObj.setEnd(days);
        bookLoanObj.calculateFine();

        return " ------------------- SUCCESS ------------------- ";
    }

    public int getLoanedBooksCount(String borrowerId){
        Borrower borrower = borrowerRepository.getBorrower(borrowerId);
        if(borrower == null){
            return -1;
        }

        int loans = 0;
        List<BookLoan> bookLoans = bookLoanRepository.getBookLoansByBorrowerId(borrowerId);
        if(bookLoans != null) {
            for (BookLoan bookLoan : bookLoans) {
                if (bookLoan.getEnd() == -1) {
                    loans = loans + 1;
                }
            }
        }

        return loans;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BorrowerRepository getBorrowerRepository() {
        return borrowerRepository;
    }

    public void setBorrowerRepository(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public BookLoanRepository getBookLoanRepository() {
        return bookLoanRepository;
    }

    public void setBookLoanRepository(BookLoanRepository bookLoanRepository) {
        this.bookLoanRepository = bookLoanRepository;
    }
}
