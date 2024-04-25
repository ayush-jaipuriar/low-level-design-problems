package com.librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    private String name;
    private List<Integer> borrowedBookIds;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBookIds = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getBorrowedBookIds() {
        return borrowedBookIds;
    }

    public void borrowBook(int bookId) {
        borrowedBookIds.add(bookId);
    }

    public void returnBook(int bookId) {
        borrowedBookIds.remove(Integer.valueOf(bookId));
    }
}
