package com.librarymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Library {
    private Map<Integer, Book> books;
    private Map<Integer, Member> members;
    private Map<Integer, Queue<Integer>> bookReservations;

    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
        bookReservations = new HashMap<>();
    }

    public void addBook(Book book) {
        if (book == null || books.containsKey(book.getBookId())) {
            throw new IllegalArgumentException("Invalid book or book already exists.");
        }
        books.put(book.getBookId(), book);
        bookReservations.put(book.getBookId(), new LinkedList<>());
    }

    public void registerMember(Member member) {
        if (member == null || members.containsKey(member.getMemberId())) {
            throw new IllegalArgumentException("Invalid member or member already exists.");
        }
        members.put(member.getMemberId(), member);
    }

    public boolean lendBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }
        if (member == null) {
            throw new IllegalArgumentException("Member not found.");
        }
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(bookId);
            return true;
        } else {
            Queue<Integer> reservations = bookReservations.get(bookId);
            if (!reservations.contains(memberId)) {
                reservations.add(memberId);
            }
            return false;
        }
    }

    public boolean returnBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }
        if (member == null) {
            throw new IllegalArgumentException("Member not found.");
        }
        if (book.returnBook()) {
            member.returnBook(bookId);
            Queue<Integer> reservations = bookReservations.get(bookId);
            if (!reservations.isEmpty()) {
                int nextMemberId = reservations.poll();
                lendBook(bookId, nextMemberId);
                // Notify the member
                System.out.println("Book with ID: " + bookId + " is now available for Member ID: " + nextMemberId);
            }
            return true;
        }
        return false;
    }

    public List<Book> getBooksBorrowedByMember(int memberId) {
        Member member = members.get(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member not found.");
        }
        List<Book> borrowedBooks = new ArrayList<>();
        for (int bookId : member.getBorrowedBookIds()) {
            borrowedBooks.add(books.get(bookId));
        }
        return borrowedBooks;
    }

    public String checkBookAvailability(int bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }
        return book.isAvailable() ? "Available" : "Borrowed";
    }

}
