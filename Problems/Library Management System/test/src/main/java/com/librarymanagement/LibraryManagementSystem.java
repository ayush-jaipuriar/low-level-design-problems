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

        // Test Case 1: Lend Book 1 to Member 1
        if (library.lendBook(1, 1)) {
            System.out.println("Test Case 1 Passed: Book 1 lent to Member 1 successfully.");
        } else {
            System.out.println("Test Case 1 Failed: Book 1 could not be lent to Member 1.");
        }

        // Test Case 2: Lend Book 2 to Member 2
        if (library.lendBook(2, 2)) {
            System.out.println("Test Case 2 Passed: Book 2 lent to Member 2 successfully.");
        } else {
            System.out.println("Test Case 2 Failed: Book 2 could not be lent to Member 2.");
        }

        // Test Case 3: Attempt to Lend Book 2 to Member 1 (should fail)
        if (!library.lendBook(2, 1)) {
            System.out.println("Test Case 3 Passed: Book 2 was not lent to Member 1 as expected.");
        } else {
            System.out.println("Test Case 3 Failed: Book 2 should not be available for lending.");
        }

        // Test Case 4: Return Book 1 by Member 1
        if (library.returnBook(1, 1)) {
            System.out.println("Test Case 4 Passed: Book 1 returned by Member 1 successfully.");
        } else {
            System.out.println("Test Case 4 Failed: Book 1 could not be returned by Member 1.");
        }

        // Test Case 5: Check Availability of Book 1 (should be available)
        if ("Available".equals(library.checkBookAvailability(1))) {
            System.out.println("Test Case 5 Passed: Book 1 is available.");
        } else {
            System.out.println("Test Case 5 Failed: Book 1 should be available.");
        }

        // Test Case 6: Check Availability of Book 2 (should be borrowed)
        if ("Borrowed".equals(library.checkBookAvailability(2))) {
            System.out.println("Test Case 6 Passed: Book 2 is borrowed.");
        } else {
            System.out.println("Test Case 6 Failed: Book 2 should be borrowed.");
        }

        // Test Case 7: Attempt to Lend Book 2 to Member 1 again (should pass due to
        // return)
        library.returnBook(2, 2); // Returning the book to trigger the reservation system
        if (library.lendBook(2, 1)) {
            System.out.println("Test Case 7 Passed: Book 2 lent to Member 1 successfully.");
        } else {
            System.out.println("Test Case 7 Failed: Book 2 could not be lent to Member 1.");
        }

        System.out.println("All test cases executed!");

}
