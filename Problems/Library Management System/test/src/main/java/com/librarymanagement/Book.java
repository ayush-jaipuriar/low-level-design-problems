package com.librarymanagement;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private int totalCopies;
    private int borrowedCopies;

    public Book(int bookId, String title, String author, int totalCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.borrowedCopies = 0;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getBorrowedCopies() {
        return borrowedCopies;
    }

    public boolean isAvailable() {
        return totalCopies > borrowedCopies;
    }

    public boolean borrowBook() {
        if (isAvailable()) {
            borrowedCopies++;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (borrowedCopies > 0) {
            borrowedCopies--;
            return true;
        }
        return false;
    }

}
