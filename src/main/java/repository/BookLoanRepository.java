package main.java.repository;

import main.java.entity.BookLoan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookLoanRepository {

    private HashMap borrowerBookLoanMapping;

    public BookLoanRepository(HashMap borrowerBookLoanMapping) {
        this.borrowerBookLoanMapping = borrowerBookLoanMapping;
    }

    public BookLoanRepository() {
        this.borrowerBookLoanMapping = new HashMap<String, ArrayList<BookLoan>>();
    }

    public List getBookLoansByBorrowerId(String bid) {
        return (ArrayList<BookLoan>) this.borrowerBookLoanMapping.get(bid);
    }

    public void addBookLoansByBorrowerId(String bid, BookLoan bookLoan) {
        List<BookLoan> bl = (List<BookLoan>)this.borrowerBookLoanMapping.get(bid);
        if(bl==null){
            bl=new ArrayList<>();
            borrowerBookLoanMapping.put(bid, bl);
        }
        bl.add(bookLoan);
    }
}
