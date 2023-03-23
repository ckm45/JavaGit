package com.ckm.library;

import java.util.ArrayList;
import java.util.List;

public class library {
    private List<BookInfo> books = new ArrayList<>();

    Member member;
    BookInfo bookinfo;

    public void borrowBook(String bookName) {
        bookinfo.setStatus(false);


    }
}
