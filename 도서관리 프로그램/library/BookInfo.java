package com.ckm.library;

import java.util.concurrent.atomic.AtomicInteger;

public class BookInfo {
    private static AtomicInteger BOOKID_GENERATOR = new AtomicInteger(0);
    
    private int bookId; // 책 id
    private String bookName; // 책이름
    private String publishDate; // 출판날짜
    private boolean status; // 대출 상태


    public BookInfo(String bookName, String publishDate, boolean status) {

        this.bookId = BOOKID_GENERATOR.getAndIncrement();
        this.bookName = bookName;
        this.publishDate = publishDate;
        this.status = status;
    }

    public String getBookName() {
        return bookName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BookInfo [bookId=" + bookId + ", bookName=" + bookName + ", publishDate="
                + publishDate + ", status=" + status + "]";
    }



}
