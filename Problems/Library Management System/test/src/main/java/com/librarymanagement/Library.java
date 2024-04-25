package com.librarymanagement;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Book> books;
    private Map<Integer, Member> members;

    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public boolean lendBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book != null && member != null && book.borrowBook()) {
            member.borrowBook(bookId);
            return true;
        }
        return false;
    }

    public boolean returnBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book != null && member != null && book.returnBook()) {
            member.returnBook(bookId);
            return true;
        }
        return false;
    }

}
