package main.java;

import main.java.controller.LibraryController;
import main.java.initial.Setup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Setup setup = new Setup();
        LibraryController libraryController = setup.init();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("1. Loan Book");
            System.out.println("2. Return Book");
            System.out.println("3. Get Loaned Books Count");
            System.out.println("Select option -- ");

            int option = sc.nextInt();
            switch (option){

                case 1:
                    System.out.println("Enter isbn of book: ");
                    sc = new Scanner(System.in);
                    String isbn = sc.nextLine();

                    System.out.println("Enter borrower Id: ");
                    sc = new Scanner(System.in);
                    String borrowerId = sc.nextLine();

                    System.out.println(libraryController.checkoutBook(isbn, borrowerId));
                    break;

                case 2:
                    System.out.println("Enter isbn of book: ");
                    sc = new Scanner(System.in);
                    isbn = sc.nextLine();

                    System.out.println("Enter borrower Id: ");
                    sc = new Scanner(System.in);
                    borrowerId = sc.nextLine();

                    System.out.println("Enter days: ");
                    sc = new Scanner(System.in);
                    int days = sc.nextInt();

                    System.out.println(libraryController.returnBook(isbn, borrowerId, days));
                    break;
                case 3:
                    System.out.println("Enter borrower Id: ");
                    sc = new Scanner(System.in);
                    borrowerId = sc.nextLine();

                    System.out.println(libraryController.getLoanedBooksCount(borrowerId));
                    break;

            }
        }



    }

}
