package com.librarymanagement;

import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book(1, "Pride and Prejudice", "Jane Austen", 3));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", 2));

        // Registering members
        library.registerMember(new Member(1, "Alice Johnson"));
        library.registerMember(new Member(2, "Bob Smith"));

        // Test cases
        if (library.lendBook(1, 1)) {
            System.out.println("Test Case Passed: Book 1 lent to Member 1 successfully.");
        } else {
            System.out.println("Test Case Failed: Book 1 could not be lent to Member 1.");
        }

        if (library.lendBook(2, 2)) {
            System.out.println("Test Case Passed: Book 2 lent to Member 2 successfully.");
        } else {
            System.out.println("Test Case Failed: Book 2 could not be lent to Member 2.");
        }

        if (!library.lendBook(2, 1)) {
            System.out.println("Test Case Passed: Book 2 was not lent to Member 1 as expected.");
        } else {
            System.out.println("Test Case Failed: Book 2 should not be available for lending.");
        }

        if (library.returnBook(1, 1)) {
            System.out.println("Test Case Passed: Book 1 returned by Member 1 successfully.");
        } else {
            System.out.println("Test Case Failed: Book 1 could not be returned by Member 1.");
        }

        if (!library.returnBook(1, 1)) {
            System.out.println("Test Case Passed: Book 1 was not returned by Member 1 as it was not borrowed.");
        } else {
            System.out.println("Test Case Failed: Book 1 should not be returned as it's not borrowed.");
        }

        if ("Available".equals(library.checkBookAvailability(1))) {
            System.out.println("Test Case Passed: Book 1 is available.");
        } else {
            System.out.println("Test Case Failed: Book 1 should be available.");
        }

        if ("Borrowed".equals(library.checkBookAvailability(2))) {
            System.out.println("Test Case Passed: Book 2 is borrowed.");
        } else {
            System.out.println("Test Case Failed: Book 2 should be borrowed.");
        }

        // Borrowing a book that is already borrowed to test reservation system
        if (!library.lendBook(2, 1)) {
            System.out.println("Test Case Passed: Book 2 was not lent to Member 1 as it's already borrowed.");
        } else {
            System.out.println("Test Case Failed: Book 2 should not be lent as it's already borrowed.");
        }

        library.returnBook(2, 2); // Returning the book to trigger the reservation system

        // Testing getBooksBorrowedByMember method
        List<Book> borrowedBooks = library.getBooksBorrowedByMember(1);
        if (borrowedBooks.size() == 1 && "Pride and Prejudice".equals(borrowedBooks.get(0).getTitle())) {
            System.out.println("Test Case Passed: Member 1 has the correct borrowed book.");
        } else {
            System.out.println("Test Case Failed: Member 1 should have the correct borrowed book.");
        }

        System.out.println("All test cases executed!");
    }

}
